package org.gte.gtecore.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import net.minecraft.data.recipes.FinishedRecipe;

import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;

public interface GTERecyclingRecipeHandler {

    Set<TagPrefix> IGNORE_ARC_SMELTING = Set.of(ingot, gem, nugget);

    static void run(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {
        for (TagPrefix prefix : TagPrefix.values()) {
            if (prefix.generateRecycling()) {
                processCrushing(provider, prefix, material);
            }
        }
    }

    private static void processCrushing(@NotNull Consumer<FinishedRecipe> provider, @NotNull TagPrefix prefix, @NotNull Material material) {}
}
