package de.kxmischesdomi.more_axolotl.mixin.client;

import de.kxmischesdomi.more_axolotl.common.CustomAxolotlVariant;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author Akashii_Kun_
 * @since 1.0
 */
@Mixin(EntityRenderer.class)
public abstract class EntityRendererMixin<T extends Entity> {

  @Inject(method = "getBlockLight", at = @At("TAIL"), cancellable = true)
  protected void getBlockLight(T entity, BlockPos pos, CallbackInfoReturnable<Integer> cir) {
    if (entity instanceof AxolotlEntity axolotl) {
      AxolotlEntity.Variant variant = axolotl.getVariant();
      if (variant == CustomAxolotlVariant.GLOW.getVariant())
        cir.setReturnValue(15);
    }
  }

}