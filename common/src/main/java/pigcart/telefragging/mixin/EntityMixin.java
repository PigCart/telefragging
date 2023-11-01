package pigcart.telefragging.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.RelativeMovement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pigcart.telefragging.Telefragging;

import java.util.Set;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Inject(method = "teleportTo(DDD)V", at = @At("TAIL"))
    public void teleportTo(double d, double e, double f, CallbackInfo ci) {
        System.out.println("hey! something teleported!");
        Telefragging.onTeleport((Entity)(Object)this);
    }
    @Inject(method = "teleportTo(Lnet/minecraft/server/level/ServerLevel;DDDLjava/util/Set;FF)Z", at = @At("TAIL"))
    public void teleportTo(ServerLevel serverLevel, double d, double e, double f, Set<RelativeMovement> set, float g, float h, CallbackInfoReturnable<Boolean> cir) {
        System.out.println("asdfghjklpoiuytrewqzxcvbnm");
        Telefragging.onTeleport((Entity)(Object)this);
    }
}
