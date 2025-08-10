package org.gte.gtecore.client;

import org.gte.gtecore.data.lang.LangHandler;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public final class Tooltips {

    public static final Map<String, LangHandler.ENCN> LANG = GTCEu.isDataGen() ? new HashMap<>() : null;

    public static final ImmutableMap<Item, String[]> TOOL_TIPS_KEY_MAP;
    public static final ImmutableMap<Item, LangHandler.ENCNS> TOOL_TIPS_MAP;

    static {
        ImmutableMap.Builder<Item, String[]> toolTipsKey = ImmutableMap.builder();
        toolTipsKey.put(GTBlocks.CASING_TEMPERED_GLASS.asItem(), new String[] { "tooltip.avaritia.tier", String.valueOf(2) });
        TOOL_TIPS_KEY_MAP = toolTipsKey.build();

        ImmutableMap.Builder<Item, LangHandler.ENCNS> toolTipsBuilder = ImmutableMap.builder();
        toolTipsBuilder.put(GTItems.VACUUM_TUBE.get(), new LangHandler.ENCNS(new String[] { "Right-click the handheld rough vacuum tube to obtain vacuum supply from a machine with vacuum level greater than 0" }, new String[] { "手持粗真空管潜行右击真空等级大于0的真空提供机器获取" }));

        TOOL_TIPS_MAP = toolTipsBuilder.build();

        if (LANG != null) {}
    }

    private static void add(ItemLike itemLike, String cn, String en) {
        LANG.put(itemLike.asItem().getDefaultInstance().getDescriptionId() + ".tooltip", new LangHandler.ENCN(cn, en));
    }
}
