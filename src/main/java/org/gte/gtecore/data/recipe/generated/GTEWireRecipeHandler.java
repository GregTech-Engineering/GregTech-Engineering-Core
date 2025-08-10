package org.gte.gtecore.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.WireProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.gregtechceu.gtceu.utils.GTUtil;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;

import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public interface GTEWireRecipeHandler {

    Map<TagPrefix, Integer> INSULATION_AMOUNT = ImmutableMap.of(
            cableGtSingle, 1,
            cableGtDouble, 1,
            cableGtQuadruple, 2,
            cableGtOctal, 3,
            cableGtHex, 5);

    static void run(@NotNull Consumer<FinishedRecipe> provider, @NotNull Material material) {
        WireProperties property = material.getProperty(PropertyKey.WIRE);
        if (property == null) {
            return;
        }
        processWires(material, property, provider);
        if (property.isSuperconductor()) return;
        generateCableCovering(wireGtSingle, material, property, provider);
        generateCableCovering(wireGtDouble, material, property, provider);
        generateCableCovering(wireGtQuadruple, material, property, provider);
        generateCableCovering(wireGtOctal, material, property, provider);
        generateCableCovering(wireGtHex, material, property, provider);
    }

    private static void processWires(Material material, WireProperties property, Consumer<FinishedRecipe> provider) {}

    private static void generateCableCovering(TagPrefix wirePrefix, Material material, WireProperties property, Consumer<FinishedRecipe> provider) {
        ItemStack wire = ChemicalHelper.get(wirePrefix, material);
        if (wire.isEmpty()) return;

        TagPrefix cablePrefix = TagPrefix.get("cable" + wirePrefix.name().substring(4));
        int voltageTier = GTUtil.getTierByVoltage(property.getVoltage());
        int insulationAmount = INSULATION_AMOUNT.get(cablePrefix);

        if (voltageTier <= LV) {
            generateManualRecipe(wirePrefix, material, cablePrefix, provider, voltageTier == ULV);
        }
    }

    private static void generateManualRecipe(TagPrefix wirePrefix, Material material, TagPrefix cablePrefix, Consumer<FinishedRecipe> provider, boolean manual) {
        int insulationAmount = INSULATION_AMOUNT.get(cablePrefix);
        if (manual) {
            Object[] ingredients = new Object[insulationAmount + 1];
            ingredients[0] = new MaterialEntry(wirePrefix, material);
            for (int i = 1; i <= insulationAmount; i++) {
                ingredients[i] = ChemicalHelper.get(plate, Rubber);
            }
            VanillaRecipeHelper.addShapelessRecipe(provider, String.format("%s_cable_%d", material.getName(), (int) ((wirePrefix.getMaterialAmount(material) << 1) / M)),
                    ChemicalHelper.get(cablePrefix, material),
                    ingredients);
        }
    }
}
