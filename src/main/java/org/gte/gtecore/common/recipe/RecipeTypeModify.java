package org.gte.gtecore.common.recipe;

import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.world.level.material.Fluid;

import static org.gte.gtecore.common.data.GTERecipeTypes.*;

public final class RecipeTypeModify {

    private RecipeTypeModify() {}

    private static final CuttingFluid[] FLUID_TIERS = new CuttingFluid[] {
            new CuttingFluid(GTMaterials.Water.getFluid(), 60),
            new CuttingFluid(GTMaterials.Lubricant.getFluid(), 2880),
            new CuttingFluid(GTEMaterials.FilteredSater.getFluid(), 3840),
            new CuttingFluid(GTEMaterials.OzoneWater.getFluid(), 15360),
            new CuttingFluid(GTEMaterials.FlocculentWater.getFluid(), 61440),
            new CuttingFluid(GTEMaterials.PHNeutralWater.getFluid(), 245760),
            new CuttingFluid(GTEMaterials.ExtremeTemperatureWater.getFluid(), 983040),
            new CuttingFluid(GTEMaterials.ElectricEquilibriumWater.getFluid(), 3932160),
            new CuttingFluid(GTEMaterials.DegassedWater.getFluid(), 15728640),
            new CuttingFluid(GTEMaterials.BaryonicPerfectionWater.getFluid(), 62914560)
    };

    public static void init() {}

    private static int getEUTierIndex(int euTier) {
        return switch (euTier) {
            case 0, 1 -> 0;
            case 2, 3 -> 1;
            case 4 -> 2;
            case 5 -> 3;
            case 6 -> 4;
            case 7 -> 5;
            case 8 -> 6;
            case 9 -> 7;
            case 10 -> 8;
            default -> 9;
        };
    }

    private record CuttingFluid(Fluid fluid, int divisor) {}
}
