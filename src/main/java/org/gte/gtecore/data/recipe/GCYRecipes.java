package org.gte.gtecore.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public interface GCYRecipes {

    static void init(Consumer<FinishedRecipe> provider) {
        registerPartsRecipes(provider);
        registerMultiblockControllerRecipes(provider);
    }

    private static void registerMultiblockControllerRecipes(Consumer<FinishedRecipe> provider) {}

    private static void registerPartsRecipes(Consumer<FinishedRecipe> provider) {}
}
