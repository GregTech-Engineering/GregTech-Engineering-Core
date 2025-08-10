package org.gte.gtecore.common.data;

import org.gte.gtecore.api.registries.GTERegistration;
import org.gte.gtecore.common.block.CraftingUnitType;

import appeng.block.crafting.CraftingUnitBlock;
import appeng.blockentity.AEBaseBlockEntity;
import appeng.blockentity.crafting.CraftingBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntry;

import static org.gte.gtecore.utils.register.BlockRegisterUtils.registerCraftingUnitBlock;

public interface GTEBlocks {

    static void init() {
        GTERegistration.REGISTRATE.creativeModeTab(() -> null);
        GTERegistration.REGISTRATE.blockEntity("crafting_storage", CraftingBlockEntity::new)
                .validBlocks(
                        CRAFTING_STORAGE_1M,
                        CRAFTING_STORAGE_4M,
                        CRAFTING_STORAGE_16M,
                        CRAFTING_STORAGE_64M,
                        CRAFTING_STORAGE_256M,
                        CRAFTING_STORAGE_MAX)
                .onRegister(type -> {
                    for (CraftingUnitType craftingUnitType : CraftingUnitType.values()) {
                        AEBaseBlockEntity.registerBlockEntityItem(type, craftingUnitType.getItemFromType());
                        craftingUnitType.getDefinition().get().setBlockEntity(CraftingBlockEntity.class, type, null, null);
                    }
                })
                .register();
    }

    BlockEntry<CraftingUnitBlock> CRAFTING_STORAGE_1M = registerCraftingUnitBlock(1,
            CraftingUnitType.STORAGE_1M);
    BlockEntry<CraftingUnitBlock> CRAFTING_STORAGE_4M = registerCraftingUnitBlock(4,
            CraftingUnitType.STORAGE_4M);
    BlockEntry<CraftingUnitBlock> CRAFTING_STORAGE_16M = registerCraftingUnitBlock(16,
            CraftingUnitType.STORAGE_16M);
    BlockEntry<CraftingUnitBlock> CRAFTING_STORAGE_64M = registerCraftingUnitBlock(64,
            CraftingUnitType.STORAGE_64M);
    BlockEntry<CraftingUnitBlock> CRAFTING_STORAGE_256M = registerCraftingUnitBlock(256,
            CraftingUnitType.STORAGE_256M);
    BlockEntry<CraftingUnitBlock> CRAFTING_STORAGE_MAX = registerCraftingUnitBlock(-1,
            CraftingUnitType.STORAGE_MAX);
}
