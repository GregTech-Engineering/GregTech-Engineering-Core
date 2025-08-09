package org.gte.gtecore.common;

import org.gte.gtecore.config.GTEConfig;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.DimensionMarker;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public class CommonProxy {

    public CommonProxy() {
        init();
    }

    private static void init() {
        GTEConfig.init();
        if (GTCEu.isDev() || GTCEu.isDataGen()) {
            GTEConfig.INSTANCE.dev = true;
            GTEConfig.INSTANCE.enablePrimitiveVoidOre = true;
        }
    }

    private static void commonSetup(FMLCommonSetupEvent event) {

    }

    private static void addMaterials(MaterialEvent event) {

    }

    private static void registerMaterialRegistry(MaterialRegistryEvent event) {

    }

    private static void registerRecipeConditions(GTCEuAPI.RegisterEvent<ResourceLocation, RecipeConditionType<?>> event) {

    }

    private static void registerDimensionMarkers(GTCEuAPI.RegisterEvent<ResourceLocation, DimensionMarker> event) {

    }

    public static void afterStartup() {
        ModList.get().getAllScanData().clear();
        if (GTCEu.isProd()) {
            Configurator.setRootLevel(Level.INFO);
        } else {
            Configurator.setRootLevel(Level.DEBUG);
        }
    }
}
