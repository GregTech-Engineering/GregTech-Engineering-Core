package org.gte.gtecore.utils.register;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.common.block.CraftingUnitType;
import org.gte.gtecore.common.data.GTELoots;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.model.generators.ConfiguredModel;

import appeng.block.crafting.AbstractCraftingUnitBlock;
import appeng.block.crafting.CraftingUnitBlock;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;

import java.util.*;

import static org.gte.gtecore.api.registries.GTERegistration.REGISTRATE;

public final class BlockRegisterUtils {

    private BlockRegisterUtils() {}

    public static BlockEntry<Block> REACTOR_CORE;

    public static final Map<String, String> LANG = GTCEu.isDataGen() ? new HashMap<>() : null;

    public static void addLang(String name, String cn) {
        if (LANG == null) return;
        if (LANG.containsKey(name)) {
            GTECore.LOGGER.error("Repetitive Key: {}", name);
            throw new IllegalStateException();
        }
        LANG.put(name, cn);
    }

    public static <T extends Block> BlockBuilder<T, GTRegistrate> block(String name, String cn, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        addLang(name, cn);
        return REGISTRATE.block(name, factory).onRegister(GTELoots.BLOCKS::add);
    }

    public static BlockEntry<CraftingUnitBlock> registerCraftingUnitBlock(int tier, CraftingUnitType Type) {
        return block("crafting_storage_" + (tier == -1 ? "max" : tier + "m"), (tier == -1 ? "MAX" : tier + "M") + "合成存储器", p -> new CraftingUnitBlock(Type))
                .blockstate((ctx, provider) -> {
                    String formed = "block/crafting/" + ctx.getName() + "_formed";
                    String unformed = "block/crafting/" + ctx.getName();
                    provider.models().cubeAll(unformed, provider.modLoc("block/crafting/" + ctx.getName()));
                    provider.models().getBuilder(formed);
                    provider.getVariantBuilder(ctx.get()).forAllStatesExcept(state -> ConfiguredModel.builder().modelFile(provider.models().getExistingFile(provider.modLoc(state.getValue(AbstractCraftingUnitBlock.FORMED) ? formed : unformed))).build(), AbstractCraftingUnitBlock.POWERED);
                })
                .item(BlockItem::new)
                .model((ctx, provider) -> provider.withExistingParent(ctx.getName(), provider.modLoc("block/crafting/" + ctx.getName())))
                .build()
                .register();
    }
}
