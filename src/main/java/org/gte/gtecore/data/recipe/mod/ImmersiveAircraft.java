package org.gte.gtecore.data.recipe.mod;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;

import java.util.Set;
import java.util.function.Consumer;

public interface ImmersiveAircraft {

    static void init(Consumer<FinishedRecipe> provider) {}

    static void initJsonFilter(Set<ResourceLocation> filters) {}
}
