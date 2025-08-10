package org.gte.gtecore.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import net.minecraft.data.recipes.FinishedRecipe;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface GTEPartsRecipeHandler {

    static void run(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {}

    private static void processScrew(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processFoil(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processLens(@NotNull Material material, @NotNull Consumer<FinishedRecipe> provider) {}

    private static void processFineWire(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processGear(TagPrefix gearPrefix, Material material, Consumer<FinishedRecipe> provider) {}

    private static void processPlate(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processPlateDouble(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processPlateDense(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processRing(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processSpringSmall(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processSpring(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processRotor(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processBolt(@NotNull Material material, @NotNull Consumer<FinishedRecipe> provider) {}

    private static void processStick(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processLongStick(Material material, Consumer<FinishedRecipe> provider) {
        /*
         * if (material.hasProperty(PropertyKey.INGOT)) {
         * EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_ingot_to_long_rod")
         * .inputItems(ingot, material)
         * .notConsumable(GTItems.SHAPE_EXTRUDER_ROD_LONG)
         * .outputItems(stack)
         * .duration(mass)
         * .EUt((long) GTEUtils.getVoltageMultiplier(material) << 3)
         * .save();
         * 
         * if (material.hasFlag(NO_SMASHING)) {
         * EXTRUDER_RECIPES.recipeBuilder("extrude_" + material.getName() + "_dust_to_long_rod")
         * .inputItems(dust, material)
         * .notConsumable(GTItems.SHAPE_EXTRUDER_ROD_LONG)
         * .outputItems(stack)
         * .duration(mass)
         * .EUt((long) GTEUtils.getVoltageMultiplier(material) << 3)
         * .save();
         * }
         * }
         */
    }

    private static void processTurbine(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processRound(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processManoswarm(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processcurvedPlate(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processMotorEnclosure(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processPumpBarrel(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processPistonHousing(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processEmitterBases(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processSensorCasing(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processFieldGeneratorCasing(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processCatalyst(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processroughBlank(Material material, Consumer<FinishedRecipe> provider) {}

    private static void processCrystallization(Material material) {}
}
