package org.gte.gtecore.data.lang;

import com.gregtechceu.gtceu.api.GTValues;

import static org.gte.gtecore.data.lang.LangHandler.addENCN;

final class ItemLang {

    static void init() {
        addENCN("item.gtceu.circuits", "Circuits", "电路");
        for (int i = 0; i < 15; i++) {
            addENCN("tag.item.gtceu.circuits." + GTValues.VN[i].toLowerCase(), GTValues.VN[i] + " Circuit", GTValues.VN[i] + "电路");
        }

        // Tooltips.TOOL_TIPS_MAP.forEach((i, s) -> {
        // for (int j = 0; j < s.length(); j++) {
        // addENCN("gtecore.tooltip.item." + ItemUtils.getIdLocation(i).getPath() + "." + j, s.ens()[j], s.cns()[j]);
        // }
        // });

        addENCN("gtecore.tooltip.item.really_max_battery", "Filling it up can allow you to complete GregTechCEu Modern", "填满它就能通关GregTechCEu Modern");
        addENCN("gtecore.tooltip.item.transcendent_max_battery", "Filling it up can allow you to complete GregTech Engineering", "填满它就能通关GregTech Engineering");
        addENCN("gtecore.tooltip.item.extremely_max_battery", "Fill it up within your lifetime", "有生之年将它填满");
        addENCN("gtecore.tooltip.item.insanely_max_battery", "Filling it up is just for fun", "填满也就图一乐");
        addENCN("gtecore.tooltip.item.mega_max_battery", "Fill up the battery for mechanical ascension", "填满电池 机械飞升");

        addENCN("gtecore.tooltip.item.craft_step", "Craft Step: %s", "合成步骤：%s");

        addENCN("item.gtecore.order.config", "Order Config", "订单配置");
    }
}
