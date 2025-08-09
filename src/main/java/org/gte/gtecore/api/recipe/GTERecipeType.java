package org.gte.gtecore.api.recipe;

import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;

public class GTERecipeType extends GTRecipeType {

    public GTERecipeType(ResourceLocation registryName, String group, RecipeType<?>... proxyRecipes) {
        super(registryName, group, proxyRecipes);
        setRecipeBuilder(new GTERecipeBuilder(registryName, this));
    }
}
