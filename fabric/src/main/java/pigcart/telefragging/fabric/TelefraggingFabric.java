package pigcart.telefragging.fabric;

import pigcart.telefragging.Telefragging;
import net.fabricmc.api.ModInitializer;

public class TelefraggingFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Telefragging.init();
    }
}
