package org.gte.gtecore.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.data.recipe.GTCraftingComponents.*;

public interface ComponentRecipes {

    static void init(Consumer<FinishedRecipe> provider) {}

    private static void assembler(int tier, ItemStack emitter_gem, ItemStack field_gem, Material... material) {
        ItemStack motor = (ItemStack) MOTOR.get(tier);
        ItemStack conveyor = (ItemStack) CONVEYOR.get(tier);
        ItemStack pump = (ItemStack) PUMP.get(tier);
        ItemStack piston = (ItemStack) PISTON.get(tier);
        ItemStack robot_arm = (ItemStack) ROBOT_ARM.get(tier);
        ItemStack emitter = (ItemStack) EMITTER.get(tier);
        ItemStack sensor = (ItemStack) SENSOR.get(tier);
        ItemStack field_generator = (ItemStack) FIELD_GENERATOR.get(tier);
        TagKey<Item> circuit = (TagKey<Item>) CIRCUIT.get(tier);
    }

    private static void assembly_line(int tier, ItemStack pipe, ItemStack emitter_gem, ItemStack magnetic, Material... material) {
        int multiplier = tier > UV ? 8 : tier > ZPM ? 4 : tier > LuV ? 2 : 1;
        ItemStack motor = (ItemStack) MOTOR.get(tier);
        ItemStack conveyor = (ItemStack) CONVEYOR.get(tier);
        ItemStack pump = (ItemStack) PUMP.get(tier);
        ItemStack piston = (ItemStack) PISTON.get(tier);
        ItemStack robot_arm = (ItemStack) ROBOT_ARM.get(tier);
        ItemStack emitter = (ItemStack) EMITTER.get(tier);
        ItemStack sensor = (ItemStack) SENSOR.get(tier);
        ItemStack field_generator = (ItemStack) FIELD_GENERATOR.get(tier);
        TagKey<Item> circuit = (TagKey<Item>) CIRCUIT.get(tier);
    }
}
