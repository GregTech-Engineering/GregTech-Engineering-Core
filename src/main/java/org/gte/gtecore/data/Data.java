package org.gte.gtecore.data;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.data.GTELoots;
import org.gte.gtecore.data.recipe.*;
import org.gte.gtecore.data.recipe.classified.$ClassifiedRecipe;
import org.gte.gtecore.data.recipe.generated.*;
import org.gte.gtecore.data.recipe.generated.ComponentRecipes;
import org.gte.gtecore.data.recipe.mod.ImmersiveAircraft;
import org.gte.gtecore.data.recipe.processing.*;

import com.gregtechceu.gtceu.api.data.chemical.material.ItemMaterialData;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.pack.GTDynamicDataPack;
import com.gregtechceu.gtceu.data.recipe.GTCraftingComponents;
import com.gregtechceu.gtceu.data.recipe.MaterialInfoLoader;
import com.gregtechceu.gtceu.data.recipe.configurable.RecipeAddition;
import com.gregtechceu.gtceu.data.recipe.misc.*;
import com.gregtechceu.gtceu.data.recipe.serialized.chemistry.ChemistryRecipes;

import net.minecraft.data.recipes.FinishedRecipe;

import com.hepdd.gtmthings.data.GTMTRecipe;

import java.util.function.Consumer;

public interface Data {

    static void init() {
        long time = System.currentTimeMillis();

        ItemMaterialData.reinitializeMaterialData();
        MaterialInfoLoader.init();
        GTCraftingComponents.init();
        // GTERecipeBuilder.initialization();
        RecipeFilter.init();
        Consumer<FinishedRecipe> consumer = GTDynamicDataPack::addRecipe;

        BlastProperty.GasTier.LOW.setFluid(() -> FluidIngredient.of(GTMaterials.Nitrogen.getFluid(1000)));
        BlastProperty.GasTier.MID.setFluid(() -> FluidIngredient.of(GTMaterials.Helium.getFluid(100)));
        BlastProperty.GasTier.HIGH.setFluid(() -> FluidIngredient.of(GTMaterials.Argon.getFluid(100)));
        BlastProperty.GasTier.HIGHER.setFluid(() -> FluidIngredient.of(GTMaterials.Neon.getFluid(100)));
        BlastProperty.GasTier.HIGHEST.setFluid(() -> FluidIngredient.of(GTMaterials.Krypton.getFluid(100)));

        CustomToolRecipes.init(consumer);
        ChemistryRecipes.init(consumer);
        MetaTileEntityMachineRecipeLoader.init(consumer);
        MiscRecipeLoader.init(consumer);
        VanillaStandardRecipes.init(consumer);
        WoodMachineRecipes.init(consumer);
        StoneMachineRecipes.init(consumer);
        CraftingRecipeLoader.init(consumer);
        FusionLoader.init(consumer);
        MachineRecipeLoader.init(consumer);
        AssemblerRecipeLoader.init(consumer);
        AssemblyLineLoader.init(consumer);
        BatteryRecipes.init(consumer);
        DecorationRecipes.init(consumer);

        CircuitRecipes.init(consumer);
        MetaTileEntityLoader.init(consumer);

        GCYMRecipes.init(consumer);
        RecipeAddition.init(consumer);
        // SHAPED_FILTER_RECIPES = null;
        // SHAPELESS_FILTER_RECIPES = null;

        ForEachMaterial.init(consumer);

        // GTE
        GTMTRecipe.init(consumer);
        GCYRecipes.init(consumer);
        MachineRecipe.init(consumer);
        ComponentRecipes.init(consumer);
        MiscRecipe.init(consumer);
        FuelRecipe.init();
        BrineRecipes.init();
        NaquadahProcess.init();
        PlatGroupMetals.init();
        ElementCopying.init();
        StoneDustProcess.init();
        Lanthanidetreatment.init();
        NewResearchSystem.init();
        RadiationHatchRecipes.init();
        PetrochemRecipes.init();
        GlassRecipe.init();
        DyeRecipes.init();
        WoodRecipes.init();
        ImmersiveAircraft.init(consumer);
        $ClassifiedRecipe.init(consumer);
        GenerateDisassembly.DISASSEMBLY_RECORD.clear();
        GenerateDisassembly.DISASSEMBLY_BLACKLIST.clear();
        RecyclingRecipes.init(consumer);
        ItemMaterialData.ITEM_MATERIAL_INFO.clear();
        // GTERecipeBuilder.clean();
        // LootSystem.defaultBlockTable(RegistriesUtils.getBlock("farmersrespite:kettle"));
        // GTELoots.BLOCKS.forEach(b -> LootSystem.defaultBlockTable((Block) b));
        GTELoots.BLOCKS = null;
        GTECore.LOGGER.info("Data loading took {}ms", System.currentTimeMillis() - time);
    }

    static void asyncInit() {
        init();
    }
}
