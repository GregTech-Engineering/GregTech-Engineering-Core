package org.gte.gtecore;

import org.gte.gtecore.common.registry.GTERegistration;
import org.gte.gtecore.data.Datagen;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

@GTAddon
public class GTEAddon implements IGTAddon {

    @Override
    public String addonModId() {
        return GTECore.MOD_ID;
    }

    @Override
    public GTRegistrate getRegistrate() {
        return GTERegistration.REGISTRATE;
    }

    @Override
    public boolean requiresHighTier() {
        return true;
    }

    @Override
    public void initializeAddon() {
        GTECore.LOGGER.info("GTECore common proxy init!");
        Datagen.init();
    }

    @Override
    public void registerSounds() {
        // GTESoundEntries.init();
    }

    @Override
    public void registerElements() {
        // GTEElements.init();
    }

    @Override
    public void registerCovers() {
        // GTECovers.init();
        // GTERegistration.REGISTRATE.creativeModeTab(() -> GTECreativeModeTabs.GTE_BLOCK);
        // GTEBlocks.init();
        // GTERegistration.REGISTRATE.creativeModeTab(() -> GTECreativeModeTabs.GTE_ITEM);
        // GTEItems.init();
    }

    @Override
    public void registerTagPrefixes() {
        // GTETagPrefix.init();
    }

    @Override
    public void registerFluidVeins() {
        // GTEBedrockFluids.init();
    }

    @Override
    public void registerBedrockOreVeins() {
        // GTEOres.BEDROCK_ORES_DEFINITION.forEach(GTRegistries.BEDROCK_ORE_DEFINITIONS::registerOrOverride);
        // GTEOres.BEDROCK_ORES.forEach((id, bedrockOre) -> {
        // BedrockOreDefinition definition =
        // BedrockOreDefinition.builder(id).size(9).dimensions(bedrockOre.dimensions()).weight(bedrockOre.weight()).materials(bedrockOre.materials()).yield(2,
        // 8).depletedYield(1).depletionAmount(1).depletionChance(100).register();
        // GTEOres.BEDROCK_ORES_DEFINITION.put(id, definition);
        // });
        // GTEOres.BEDROCK_ORES.clear();
    }

    @Override
    public void registerOreVeins() {
        // GTEOres.init();
    }

    @Override
    public void registerWorldgenLayers() {
        // GTEWorldGenLayers.init();
    }

    @Override
    public void registerRecipeCapabilities() {
        // GTERecipeCapabilities.init();
    }
}
