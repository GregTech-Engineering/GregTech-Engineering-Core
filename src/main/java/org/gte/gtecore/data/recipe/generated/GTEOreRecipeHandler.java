package org.gte.gtecore.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.OreProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import net.minecraft.data.recipes.FinishedRecipe;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;

public interface GTEOreRecipeHandler {

    private static boolean doesMaterialUseNormalFurnace(Material material) {
        return !material.hasProperty(PropertyKey.BLAST) && !material.hasFlag(MaterialFlags.NO_ORE_SMELTING);
    }

    static void run(Consumer<FinishedRecipe> provider, Material material) {
        OreProperty property = material.getProperty(PropertyKey.ORE);
        if (property == null) {
            return;
        }
        processOre(material, property, provider);
        processRawOre(material, property, provider);
        processCrushedOre(provider, property, material);
        processCrushedPurified(provider, property, material);
        processCrushedCentrifuged(provider, property, material);
        processDirtyDust(provider, property, material);
        processPureDust(provider, property, material);
    }

    private static void processOre(Material material, OreProperty property, Consumer<FinishedRecipe> provider) {}

    private static void processRawOre(Material material, OreProperty property, Consumer<FinishedRecipe> provider) {}

    private static void processCrushedOre(@NotNull Consumer<FinishedRecipe> provider, @NotNull OreProperty property,
                                          @NotNull Material material) {
        processMetalSmelting(provider, property, crushed, material);
    }

    private static void processCrushedCentrifuged(@NotNull Consumer<FinishedRecipe> provider,
                                                  @NotNull OreProperty property, @NotNull Material material) {
        processMetalSmelting(provider, property, crushedRefined, material);
    }

    private static void processCrushedPurified(@NotNull Consumer<FinishedRecipe> provider,
                                               @NotNull OreProperty property,
                                               @NotNull Material material) {
        processMetalSmelting(provider, property, crushedPurified, material);
    }

    private static void processDirtyDust(@NotNull Consumer<FinishedRecipe> provider, @NotNull OreProperty property,
                                         @NotNull Material material) {
        // dust gains same amount of material as normal dust
        processMetalSmelting(provider, property, dustImpure, material);
    }

    private static void processPureDust(@NotNull Consumer<FinishedRecipe> provider, @NotNull OreProperty property,
                                        @NotNull Material material) {
        processMetalSmelting(provider, property, dustPure, material);
    }

    private static void processMetalSmelting(@NotNull Consumer<FinishedRecipe> provider, @NotNull OreProperty property,
                                             @NotNull TagPrefix prefix, @NotNull Material material) {}

    static Material getOutputMaterial(Material material) {
        return material;
    }
}
