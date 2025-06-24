package org.k4n3d4.mixins;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import org.k4n3d4.HideNightVisionModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;
import java.util.stream.Collectors;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "getActiveEffects", at = @At("RETURN"), cancellable = true)
    private void hideNightVision(CallbackInfoReturnable<Collection<MobEffectInstance>> cir) {
        if (!HideNightVisionModule.IsEnable) {
            return;
        }

        Collection<MobEffectInstance> original = cir.getReturnValue();
        if (!original.isEmpty()) {
            Collection<MobEffectInstance> filtered = original.stream()
                    .filter(effect -> effect.getEffect() != MobEffects.NIGHT_VISION)
                    .collect(Collectors.toList());
            cir.setReturnValue(filtered);
        }
    }
}