package pigcart.telefragging.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import pigcart.telefragging.Telefragging;

@Mod(Telefragging.MOD_ID)
public class TelefraggingForge {
    public TelefraggingForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Telefragging.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Telefragging.init();
    }
}
