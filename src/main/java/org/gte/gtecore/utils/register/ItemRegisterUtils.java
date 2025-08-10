package org.gte.gtecore.utils.register;

import org.gte.gtecore.GTECore;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.tag.TagUtil;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import appeng.api.stacks.AEKeyType;
import appeng.api.upgrades.Upgrades;
import appeng.core.definitions.AEItems;
import appeng.core.definitions.ItemDefinition;
import appeng.core.localization.GuiText;
import appeng.items.materials.MaterialItem;
import appeng.items.materials.StorageComponentItem;
import appeng.items.storage.BasicStorageCell;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.gte.gtecore.api.registries.GTERegistration.REGISTRATE;
import static org.gte.gtecore.common.data.GTEItems.*;

public final class ItemRegisterUtils {

    private ItemRegisterUtils() {}

    public static final Map<String, String> LANG = GTCEu.isDataGen() ? new HashMap<>() : null;

    public static <T extends Item> ItemBuilder<T, GTRegistrate> item(String name, String cn, NonNullFunction<Item.Properties, T> factory) {
        if (LANG != null) {
            if (LANG.containsKey(name)) {
                GTECore.LOGGER.error("Repetitive Key: {}", name);
                throw new IllegalStateException();
            }
            if (LANG.containsValue(cn)) {
                GTECore.LOGGER.error("Repetitive Value: {}", cn);
                throw new IllegalStateException();
            }
            LANG.put(name, cn);
        }
        return REGISTRATE.item(name, factory);
    }

    public static void InitUpgrades() {
        String storageCellGroup = GuiText.StorageCells.getTranslationKey();
        String portableCellGroup = GuiText.PortableCells.getTranslationKey();

        var itemCells = List.of(
                ITEM_STORAGE_CELL_1M, ITEM_STORAGE_CELL_4M, ITEM_STORAGE_CELL_16M, ITEM_STORAGE_CELL_64M,
                ITEM_STORAGE_CELL_256M);
        for (var itemCell : itemCells) {
            Upgrades.add(AEItems.FUZZY_CARD, itemCell, 1, storageCellGroup);
            Upgrades.add(AEItems.INVERTER_CARD, itemCell, 1, storageCellGroup);
            Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, itemCell, 1, storageCellGroup);
            Upgrades.add(AEItems.VOID_CARD, itemCell, 1, storageCellGroup);
        }

        var fluidCells = List.of(
                FLUID_STORAGE_CELL_1M, FLUID_STORAGE_CELL_4M, FLUID_STORAGE_CELL_16M, FLUID_STORAGE_CELL_64M,
                FLUID_STORAGE_CELL_256M);
        for (var fluidCell : fluidCells) {
            Upgrades.add(AEItems.INVERTER_CARD, fluidCell, 1, storageCellGroup);
            Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, fluidCell, 1, storageCellGroup);
            Upgrades.add(AEItems.VOID_CARD, fluidCell, 1, storageCellGroup);
        }

        Upgrades.add(AEItems.FUZZY_CARD, SUPER_PORTABLE_ITEM_CELL, 1, portableCellGroup);
        Upgrades.add(AEItems.INVERTER_CARD, SUPER_PORTABLE_ITEM_CELL, 1, portableCellGroup);
        Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, SUPER_PORTABLE_ITEM_CELL, 1, portableCellGroup);
        Upgrades.add(AEItems.VOID_CARD, SUPER_PORTABLE_ITEM_CELL, 1, portableCellGroup);
        Upgrades.add(AEItems.ENERGY_CARD, SUPER_PORTABLE_ITEM_CELL, 2, portableCellGroup);

        Upgrades.add(AEItems.INVERTER_CARD, SUPER_PORTABLE_FLUID_CELL, 1, portableCellGroup);
        Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, SUPER_PORTABLE_FLUID_CELL, 1, portableCellGroup);
        Upgrades.add(AEItems.VOID_CARD, SUPER_PORTABLE_FLUID_CELL, 1, portableCellGroup);
        Upgrades.add(AEItems.ENERGY_CARD, SUPER_PORTABLE_FLUID_CELL, 2, portableCellGroup);
    }

    public static ItemEntry<StorageComponentItem> registerStorageComponentItem(int tier) {
        return item("cell_component_" + tier + "m", tier + "M ME存储组件", p -> new StorageComponentItem(p, 1048576 * tier))
                .register();
    }

    public static ItemEntry<BasicStorageCell> registerStorageCell(int tier,
                                                                  ItemEntry<StorageComponentItem> StorageComponent,
                                                                  boolean isItem) {
        ItemDefinition<MaterialItem> CELL_HOUSING = isItem ? AEItems.ITEM_CELL_HOUSING : AEItems.FLUID_CELL_HOUSING;
        return item((isItem ? "item" : "fluid") + "_storage_cell_" + tier + "m", tier + "M " + (isItem ? "物品" : "流体") + "存储元件", p -> new BasicStorageCell(
                p.stacksTo(1),
                StorageComponent,
                CELL_HOUSING,
                3 + 0.5 * Math.log(tier) / Math.log(4),
                1024 * tier,
                1,
                isItem ? 128 : 36,
                isItem ? AEKeyType.items() : AEKeyType.fluids()))
                .register();
    }

    public static <T extends ComponentItem> NonNullConsumer<T> attachRenderer(ICustomRenderer customRenderer) {
        return !GTCEu.isClientSide() ? NonNullConsumer.noop() : (item) -> item.attachComponents(customRenderer);
    }

    public static ItemEntry<Item> registerEssence(String id, String cn) {
        return item(id + "_essence", cn + "精华", Item::new)
                .model((ctx, prov) -> prov.generated(ctx, GTECore.id("item/essence/" + id)))
                .tag(TagUtil.optionalTag(BuiltInRegistries.ITEM, GTECore.id("vein_essence")))
                .register();
    }

    public static ItemEntry<Item> registerAlgae(String id, String cn) {
        return item(id + "_algae", cn + "藻", Item::new)
                .model((ctx, prov) -> prov.generated(ctx, GTECore.id("item/algae/" + id)))
                .tag(TagUtil.optionalTag(BuiltInRegistries.ITEM, GTECore.id("algae")))
                .register();
    }

    public static ItemEntry<Item> registerAlgaeFiber(String id, String cn) {
        return item(id + "_algae_fiber", cn + "藻纤维", Item::new)
                .tag(TagUtil.optionalTag(BuiltInRegistries.ITEM, GTECore.id("algae_fiber")))
                .register();
    }

    public static ItemEntry<Item> registerCustomModel(String id, String cn) {
        return item(id, cn, Item::new).model(NonNullBiConsumer.noop()).register();
    }

    public static ItemEntry<Item> register(String id, String cn) {
        return item(id, cn, Item::new).register();
    }

    public static ItemEntry<Item> registerTexture(String id, String cn, String texture) {
        return item(id, cn, Item::new)
                .model((ctx, prov) -> prov.generated(ctx, GTECore.id("item/" + texture)))
                .register();
    }

    public static ItemEntry<Item> registerLang(String id, String en, String cn) {
        return item(id, cn, Item::new)
                .lang(en).register();
    }
}
