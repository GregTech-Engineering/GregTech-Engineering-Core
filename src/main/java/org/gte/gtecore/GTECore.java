package org.gte.gtecore;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gte.gtecore.client.ClientProxy;
import org.gte.gtecore.common.CommonProxy;

@Mod(GTECore.MOD_ID)
public class GTECore {

    public static final String MOD_ID = "gtecore";
    public static final String NAME = "GregTech Engineering Core";
    public static final Logger LOGGER = LogManager.getLogger(NAME);
	public static MaterialRegistry MATERIAL_REGISTRY;

    public GTECore() {
	    GTECore.init();
        DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    }
	
	public static void init() {
		LOGGER.info("{} is initializing...", NAME);
	}
	
	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
	
	@SubscribeEvent
	public void registerMaterialRegistry(MaterialRegistryEvent event) {
		GTECore.MATERIAL_REGISTRY = GTCEuAPI.materialManager.createRegistry(GTECore.MOD_ID);
	}
}
