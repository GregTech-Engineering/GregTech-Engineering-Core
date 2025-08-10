package org.gte.gtecore.common.data;

import org.gte.gtecore.client.renderer.item.OrderItemProviderRenderer;
import org.gte.gtecore.common.item.*;
import org.gte.gtecore.integration.ae2.InfinityCellItem;
import org.gte.gtecore.utils.StringUtils;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.ElectricStats;
import com.gregtechceu.gtceu.common.data.GTFluids;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;

import com.lowdragmc.lowdraglib.utils.LocalizationUtils;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import appeng.api.stacks.AEKeyType;
import appeng.items.materials.StorageComponentItem;
import appeng.items.storage.BasicStorageCell;
import appeng.items.storage.StorageTier;
import appeng.items.tools.powered.PortableCellItem;
import appeng.menu.me.common.MEStorageMenu;
import com.tterrag.registrate.util.entry.ItemEntry;
import earth.terrarium.adastra.common.registry.ModFluids;

import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static org.gte.gtecore.utils.register.ItemRegisterUtils.*;

public interface GTEItems {

    static void init() {
        GTMaterials.Oxygen.getProperty(PropertyKey.FLUID).getStorage().store(FluidStorageKeys.GAS, ModFluids.OXYGEN, null);
        GTMaterials.Hydrogen.getProperty(PropertyKey.FLUID).getStorage().store(FluidStorageKeys.GAS, ModFluids.HYDROGEN, null);
        GTFluids.handleNonMaterialFluids(GTMaterials.Oil, ModFluids.OIL);
    }

    ItemEntry<StorageComponentItem> CELL_COMPONENT_1M = registerStorageComponentItem(1);
    ItemEntry<StorageComponentItem> CELL_COMPONENT_4M = registerStorageComponentItem(4);
    ItemEntry<StorageComponentItem> CELL_COMPONENT_16M = registerStorageComponentItem(16);
    ItemEntry<StorageComponentItem> CELL_COMPONENT_64M = registerStorageComponentItem(64);
    ItemEntry<StorageComponentItem> CELL_COMPONENT_256M = registerStorageComponentItem(256);

    ItemEntry<BasicStorageCell> ITEM_STORAGE_CELL_1M = registerStorageCell(1, CELL_COMPONENT_1M, true);
    ItemEntry<BasicStorageCell> ITEM_STORAGE_CELL_4M = registerStorageCell(4, CELL_COMPONENT_4M, true);
    ItemEntry<BasicStorageCell> ITEM_STORAGE_CELL_16M = registerStorageCell(16, CELL_COMPONENT_16M, true);
    ItemEntry<BasicStorageCell> ITEM_STORAGE_CELL_64M = registerStorageCell(64, CELL_COMPONENT_64M, true);
    ItemEntry<BasicStorageCell> ITEM_STORAGE_CELL_256M = registerStorageCell(256, CELL_COMPONENT_256M,
            true);

    ItemEntry<BasicStorageCell> FLUID_STORAGE_CELL_1M = registerStorageCell(1, CELL_COMPONENT_1M, false);
    ItemEntry<BasicStorageCell> FLUID_STORAGE_CELL_4M = registerStorageCell(4, CELL_COMPONENT_4M, false);
    ItemEntry<BasicStorageCell> FLUID_STORAGE_CELL_16M = registerStorageCell(16, CELL_COMPONENT_16M, false);
    ItemEntry<BasicStorageCell> FLUID_STORAGE_CELL_64M = registerStorageCell(64, CELL_COMPONENT_64M, false);
    ItemEntry<BasicStorageCell> FLUID_STORAGE_CELL_256M = registerStorageCell(256, CELL_COMPONENT_256M,
            false);

    ItemEntry<PortableCellItem> SUPER_PORTABLE_ITEM_CELL = item("super_portable_item_storage_cell", "超级便携物品存储元件", p -> new PortableCellItem(AEKeyType.items(),
            256,
            MEStorageMenu.PORTABLE_ITEM_CELL_TYPE,
            new StorageTier(100, "super", Integer.MAX_VALUE, 100, WETWARE_MAINFRAME_UHV),
            p.stacksTo(1), 0xDDDDDD))
            .register();

    ItemEntry<PortableCellItem> SUPER_PORTABLE_FLUID_CELL = item("super_portable_fluid_storage_cell", "超级便携流体存储元件", p -> new PortableCellItem(AEKeyType.fluids(),
            256,
            MEStorageMenu.PORTABLE_ITEM_CELL_TYPE,
            new StorageTier(100, "super", Integer.MAX_VALUE, 100, WETWARE_MAINFRAME_UHV),
            p.stacksTo(1), 0xFF6D36))
            .register();

    ItemEntry<InfinityCellItem> ITEM_INFINITY_CELL = item("item_infinity_cell", "无限物品存储元件", p -> new InfinityCellItem(AEKeyType.items())).register();
    ItemEntry<InfinityCellItem> FLUID_INFINITY_CELL = item("fluid_infinity_cell", "无限流体存储元件", p -> new InfinityCellItem(AEKeyType.fluids())).register();
    ItemEntry<ComponentItem> ORDER = item("order", "%s 订单", ComponentItem::create)
            .properties(p -> p.stacksTo(1))
            .onRegister(attach(OrderItem.INSTANCE))
            .onRegister(attachRenderer(() -> OrderItemProviderRenderer.INSTANCE))
            .register();
    ItemEntry<ComponentItem> REALLY_MAX_BATTERY = item("really_max_battery", "真·终极电池", ComponentItem::create)
            .lang("Really MAX Battery")
            .onRegister(attach(new TooltipBehavior(lines -> lines.add(Component.translatable("gtecore.tooltip.item.really_max_battery").withStyle(ChatFormatting.GRAY)))))
            .onRegister(modelPredicate(GTCEu.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.UEV)))
            .register();
    ItemEntry<ComponentItem> TRANSCENDENT_MAX_BATTERY = item("transcendent_max_battery", "超·终极电池", ComponentItem::create)
            .lang("Transcendent MAX Battery")
            .onRegister(attach(new TooltipBehavior(lines -> lines.add(Component.translatable("gtecore.tooltip.item.transcendent_max_battery").withStyle(ChatFormatting.GRAY)))))
            .onRegister(modelPredicate(GTCEu.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.UIV)))
            .register();
    ItemEntry<ComponentItem> EXTREMELY_MAX_BATTERY = item("extremely_max_battery", "极·终极电池", ComponentItem::create)
            .lang("Extremely MAX Battery")
            .onRegister(attach(new TooltipBehavior(lines -> lines.add(Component.translatable("gtecore.tooltip.item.extremely_max_battery").withStyle(ChatFormatting.GRAY)))))
            .onRegister(modelPredicate(GTCEu.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.UXV)))
            .register();
    ItemEntry<ComponentItem> INSANELY_MAX_BATTERY = item("insanely_max_battery", "狂·终极电池", ComponentItem::create)
            .lang("Insanely MAX Battery")
            .onRegister(attach(new TooltipBehavior(lines -> lines.add(Component.literal(StringUtils.dark_purplish_red(LocalizationUtils.format("gtecore.tooltip.item.insanely_max_battery")))))))
            .onRegister(modelPredicate(GTCEu.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.OpV)))
            .register();
    ItemEntry<ComponentItem> MEGA_MAX_BATTERY = item("mega_max_battery", "兆·终极电池", ComponentItem::create)
            .lang("Mega MAX Battery")
            .onRegister(attach(new TooltipBehavior(lines -> lines.add(Component.literal(StringUtils.full_color(LocalizationUtils.format("gtecore.tooltip.item.mega_max_battery")))))))
            .onRegister(modelPredicate(GTCEu.id("battery"), ElectricStats::getStoredPredicate))
            .onRegister(attach(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.MAX)))
            .register();
}
