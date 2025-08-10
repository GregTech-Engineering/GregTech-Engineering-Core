package org.gte.gtecore.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public interface MachineRecipe {

    static void init(Consumer<FinishedRecipe> provider) {
        HatchRecipe.init(provider);
    }
}
