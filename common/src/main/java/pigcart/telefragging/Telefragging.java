package pigcart.telefragging;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;

import java.util.List;

public class Telefragging {
    public static final String MOD_ID = "telefragging";

    public static void init() {

    }

    public static void onTeleport(Entity cluelessChump) {
        if (!cluelessChump.level().isClientSide) {
            List<Entity> list = cluelessChump.level().getEntities(cluelessChump, cluelessChump.getBoundingBox(), EntitySelector.pushableBy(cluelessChump));
            if (!list.isEmpty()) {
                for (Entity poorSod : list) {
                    if (poorSod instanceof LivingEntity) {
                        System.out.println(poorSod.getDisplayName().getString() + " got telefragged at " + poorSod.getBlockX() + " " + poorSod.getBlockY() + " " + poorSod.getBlockZ());
                        ServerLevel lvl = (ServerLevel) poorSod.level();
                        lvl.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, Items.FERMENTED_SPIDER_EYE.getDefaultInstance()), poorSod.getX(), poorSod.getY() + 0.5, poorSod.getZ(), 1100, 0, 0, 0, 0.2);
                        lvl.playSound(null, poorSod.blockPosition(), SoundEvents.SLIME_DEATH, SoundSource.NEUTRAL);
                        poorSod.remove(Entity.RemovalReason.KILLED);
                    }
                }
            }
        }
    }
}
