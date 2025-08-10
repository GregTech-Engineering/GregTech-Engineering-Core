package org.gte.gtecore.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.*;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public interface GTEMaterialRecipeHandler {

    List<TagPrefix> GEM_ORDER = Arrays.asList(gem, gemFlawless, gemExquisite);

    static void run(Consumer<FinishedRecipe> provider, Material material) {}

    private static void processIngot(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processNugget(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processBlock(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processFrame(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processGemConversion(TagPrefix gemPrefix, Material material, Consumer<FinishedRecipe> provider) {}

    private static void processDust(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processSmallDust(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processTinyDust(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processEBFRecipe(Material material, BlastProperty property, ItemStack output,
                                         Consumer<FinishedRecipe> provider) {}
}
