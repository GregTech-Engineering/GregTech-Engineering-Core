package org.gte.gtecore.common;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.DimensionMarker;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.registry.GTERegistration;
import org.gte.gtecore.config.GTEConfig;

public class CommonProxy {

    public CommonProxy() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        init();
        eventBus.addListener(CommonProxy::commonSetup);
        eventBus.addListener(CommonProxy::addMaterials);
        eventBus.addGenericListener(RecipeConditionType.class, CommonProxy::registerRecipeConditions);
        eventBus.addGenericListener(DimensionMarker.class, CommonProxy::registerDimensionMarkers);
        eventBus.addGenericListener(MachineDefinition.class, this::registerMachines);
    }

    private static void init() {
	    GTECore.LOGGER.info("GTECore common proxy init!");
        GTEConfig.init();
        if (GTCEu.isDev() || GTCEu.isDataGen()) {
            GTEConfig.INSTANCE.dev = true;
            GTEConfig.INSTANCE.enablePrimitiveVoidOre = true;
        }
	    GTERegistration.REGISTRATE.registerRegistrate();
    }

    private static void commonSetup(FMLCommonSetupEvent event) {
	    // if (GTEConfig.getDifficulty() == 3) AEConfig.instance().setChannelModel(ChannelMode.DEFAULT);
	    //
	    // FusionReactorMachine.registerFusionTier(GTValues.UHV, " (MKIV)");
	    // FusionReactorMachine.registerFusionTier(GTValues.UEV, " (MKV)");
        //
        // AdvancedTerminalBehavior.AutoBuildSetting.HATCH_NAMES.add("thread_hatch");
        // AdvancedTerminalBehavior.AutoBuildSetting.HATCH_NAMES.add("accelerate_hatch");
        // AdvancedTerminalBehavior.AutoBuildSetting.HATCH_NAMES.add("programmablec_hatch");
        // AdvancedTerminalBehavior.AutoBuildSetting.HATCH_NAMES.add("gravity_hatch");
        // AdvancedTerminalBehavior.AutoBuildSetting.HATCH_NAMES.add("vacuum_hatch");
        //
        // if (GTCEu.isProd() && GTCEu.Mods.isEMILoaded()) EMIRecipeModHelper.setRecipeModHelper();
    }
	
	private static void addMaterials(MaterialEvent event) {
	}
	
	private static void registerRecipeConditions(GTCEuAPI.RegisterEvent<ResourceLocation, RecipeConditionType<?>> event) {
	}
	
	private static void registerDimensionMarkers(GTCEuAPI.RegisterEvent<ResourceLocation, DimensionMarker> event) {
	}
	
	private void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
	}
}
