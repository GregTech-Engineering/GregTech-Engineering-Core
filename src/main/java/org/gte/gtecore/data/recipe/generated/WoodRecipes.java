package org.gte.gtecore.data.recipe.generated;

import org.gte.gtecore.integration.Mods;

import com.gregtechceu.gtceu.data.recipe.WoodTypeEntry;

import java.util.ArrayList;
import java.util.List;

public interface WoodRecipes {

    static List<WoodTypeEntry> getEntries() {
        List<WoodTypeEntry> entries = new ArrayList<>();

        return entries;
    }

    static void init() {
        add("minecraft", "oak");
        add("minecraft", "spruce");
        add("minecraft", "birch");
        add("minecraft", "jungle");
        add("minecraft", "acacia");
        add("minecraft", "dark_oak");
        add("minecraft", "cherry");
        add("deeperdarker", "echo");

        if (Mods.biomesoplenty()) {
            add("biomesoplenty", "fir");
            add("biomesoplenty", "redwood");
            add("biomesoplenty", "mahogany");
            add("biomesoplenty", "jacaranda");
            add("biomesoplenty", "palm");
            add("biomesoplenty", "willow");
            add("biomesoplenty", "hellbark");
            add("biomesoplenty", "dead");
            add("biomesoplenty", "umbran");
            add("biomesoplenty", "magic");
        }

        if (Mods.biomeswevegone()) {
            add("biomeswevegone", "skyris");
            add("biomeswevegone", "white_mangrove");
            add("biomeswevegone", "willow");
            add("biomeswevegone", "witch_hazel");
            add("biomeswevegone", "zelkova");
            add("biomeswevegone", "holly");
            add("biomeswevegone", "ironwood");
            add("biomeswevegone", "jacaranda");
            add("biomeswevegone", "mahogany");
            add("biomeswevegone", "maple");
            add("biomeswevegone", "palm");
            add("biomeswevegone", "pine");
            add("biomeswevegone", "rainbow_eucalyptus");
            add("biomeswevegone", "redwood");
            add("biomeswevegone", "aspen");
            add("biomeswevegone", "baobab");
            add("biomeswevegone", "blue_enchanted");
            add("biomeswevegone", "cika");
            add("biomeswevegone", "cypress");
            add("biomeswevegone", "ebony");
            add("biomeswevegone", "fir");
            add("biomeswevegone", "green_enchanted");
        }
    }

    private static void add(String mod, String mane) {}
}
