package org.gte.gtecore.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public interface GTMTRecipe {

    static void init(Consumer<FinishedRecipe> provider) {}
}
