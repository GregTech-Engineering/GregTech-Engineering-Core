package org.gte.gtecore.data.recipe.generated;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.WireProperties;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.utils.GTUtil;

import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;

public interface GTEWireCombiningHandler {

    Map<TagPrefix, TagPrefix> cableToWireMap = ImmutableMap.of(
            cableGtSingle, wireGtSingle,
            cableGtDouble, wireGtDouble,
            cableGtQuadruple, wireGtQuadruple,
            cableGtOctal, wireGtOctal,
            cableGtHex, wireGtHex);

    TagPrefix[] WIRE_DOUBLING_ORDER = new TagPrefix[] {
            wireGtSingle, wireGtDouble, wireGtQuadruple, wireGtOctal, wireGtHex
    };

    static void run(@NotNull Material material) {
        WireProperties property = material.getProperty(PropertyKey.WIRE);
        if (property == null) {
            return;
        }
        processWireCompression(material, property);

        if (property.isSuperconductor()) return;
        for (TagPrefix cablePrefix : cableToWireMap.keySet()) {
            processCableStripping(cablePrefix, material, property);
        }
    }

    private static void processWireCompression(Material material, WireProperties property) {
        if (!material.shouldGenerateRecipesFor(wireGtSingle)) {
            return;
        }
        int mass = (int) material.getMass();
        long v = property.getVoltage();
    }

    private static void processCableStripping(TagPrefix prefix, Material material, WireProperties property) {
        if (!material.shouldGenerateRecipesFor(prefix)) {
            return;
        }
        Material rubber = GTMaterials.Rubber;
        int voltageTier = GTUtil.getTierByVoltage(property.getVoltage());
        if (voltageTier > GTValues.UV) {
            rubber = GTMaterials.StyreneButadieneRubber;
        } else if (voltageTier > GTValues.EV) {
            rubber = GTMaterials.SiliconeRubber;
        }
    }
}
