package org.gte.gtecore.utils;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import net.minecraft.world.item.crafting.RecipeType;
import org.gte.gtecore.api.recipe.GTERecipeType;

public final class RecipeTypeRegisterUtils {

    private RecipeTypeRegisterUtils() {}

    public static GTERecipeType register(String name, String group, RecipeType<?>... proxyRecipes) {
        GTERecipeType recipeType = new GTERecipeType(GTCEu.id(name), group, proxyRecipes);
        GTRegistries.RECIPE_TYPES.register(recipeType.registryName, recipeType);
        return recipeType;
    }
}
