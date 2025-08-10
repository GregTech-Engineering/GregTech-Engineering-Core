package org.gte.gtecore.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import net.minecraft.data.recipes.FinishedRecipe;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;

public class GTEPipeRecipeHandler {

    static void run(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {
        if (material.hasProperty(PropertyKey.FLUID_PIPE)) {
            processPipeTiny(provider, material);
            processPipeSmall(provider, pipeSmallFluid, material);
            processPipeNormal(provider, pipeNormalFluid, material);
            processPipeLarge(provider, pipeLargeFluid, material);
            processPipeHuge(provider, pipeHugeFluid, material);
            processPipeQuadruple(provider, material);
            processPipeNonuple(provider, material);
        } else if (material.hasProperty(PropertyKey.ITEM_PIPE)) {
            processPipeSmall(provider, pipeSmallItem, material);
            processPipeNormal(provider, pipeNormalItem, material);
            processPipeLarge(provider, pipeLargeItem, material);
            processPipeHuge(provider, pipeHugeItem, material);
            processRestrictivePipe(provider, pipeSmallRestrictive, pipeSmallItem, material);
            processRestrictivePipe(provider, pipeNormalRestrictive, pipeNormalItem, material);
            processRestrictivePipe(provider, pipeLargeRestrictive, pipeLargeItem, material);
            processRestrictivePipe(provider, pipeHugeRestrictive, pipeHugeItem, material);
        }
    }

    private static void processRestrictivePipe(@NotNull Consumer<FinishedRecipe> provider, @NotNull TagPrefix prefix, @NotNull TagPrefix unrestrictive, @NotNull Material material) {}

    private static void processPipeTiny(@NotNull Consumer<FinishedRecipe> provider,
                                        @NotNull Material material) {}

    private static void processPipeSmall(@NotNull Consumer<FinishedRecipe> provider, @NotNull TagPrefix prefix, @NotNull Material material) {}

    private static void processPipeNormal(@NotNull Consumer<FinishedRecipe> provider, @NotNull TagPrefix prefix, @NotNull Material material) {}

    private static void processPipeLarge(@NotNull Consumer<FinishedRecipe> provider, @NotNull TagPrefix prefix, @NotNull Material material) {}

    private static void processPipeHuge(@NotNull Consumer<FinishedRecipe> provider, @NotNull TagPrefix prefix, @NotNull Material material) {}

    private static void processPipeQuadruple(@NotNull Consumer<FinishedRecipe> provider,
                                             @NotNull Material material) {}

    private static void processPipeNonuple(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {}
}
