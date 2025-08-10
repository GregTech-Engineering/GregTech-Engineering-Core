package org.gte.gtecore.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;

import net.minecraft.world.item.Item;

import java.util.List;

import static com.gregtechceu.gtceu.api.GTValues.*;

class GTEDisposableToolHandler {

    private record DisposableTool(GTToolType tool, Item mold, Item item, int consume) {}

    private final static List<DisposableTool> toolToMoldMap = List.of();

    static void run(Material material) {}
}
