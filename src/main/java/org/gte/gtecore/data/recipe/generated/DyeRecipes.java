package org.gte.gtecore.data.recipe.generated;

import org.gte.gtecore.integration.Mods;

import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;

import java.util.Map;

public interface DyeRecipes {

    Map<String, Boolean> BWG = new Object2BooleanOpenHashMap<>();

    static void init() {
        if (Mods.biomeswevegone()) {
            BWG.put("white", true);
            BWG.put("orange", false);
            BWG.put("magenta", false);
            BWG.put("light_blue", false);
            BWG.put("yellow", false);
            BWG.put("lime", false);
            BWG.put("pink", true);
            BWG.put("cyan", true);
            BWG.put("purple", true);
            BWG.put("blue", true);
            BWG.put("green", false);
            BWG.put("red", false);
            BWG.put("black", false);
        }

        addBotDye("white");
        addBotDye("light_gray");
        addBotDye("gray");
        addBotDye("black");
        addBotDye("brown");
        addBotDye("red");
        addBotDye("orange");
        addBotDye("yellow");
        addBotDye("lime");
        addBotDye("green");
        addBotDye("cyan");
        addBotDye("light_blue");
        addBotDye("blue");
        addBotDye("purple");
        addBotDye("magenta");
        addBotDye("pink");
    }

    private static void addBotDye(String dye) {}
}
