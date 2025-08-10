package org.gte.gtecore.data.recipe;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.lens;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Diamond;

public interface HatchRecipe {

    static void init(Consumer<FinishedRecipe> provider) {
        MaterialEntry lensDiamond = new MaterialEntry(lens, Diamond);
        ItemStack activeTransformer = GTMultiMachines.ACTIVE_TRANSFORMER.asStack();
        ItemStack coverEnergyDetector = GTItems.COVER_ENERGY_DETECTOR_ADVANCED.asStack();
    }
}
