package tk.imaginescape.morpheusregistry;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.common.DimensionManager;
import net.quetzi.morpheus.Morpheus;

@Mod(modid = "morpheusregistry", useMetadata = true, acceptableRemoteVersions = "*")
public class ISMorpheusRegistry
{
    public static ModMetadata metadata;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        metadata = event.getModMetadata();
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        for (Integer dimension : DimensionManager.getIDs()) {
            if (dimension < -1 || dimension > 1) {
                Morpheus.register.registerHandler(new GenericDimensionHandler(dimension), dimension);
            }
        }
    }
}
