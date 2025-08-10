package org.gte.gtecore.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTMaterials;

public interface RadiationHatchRecipes {

    static void init() {
        registerRadioactiveMaterial(GTMaterials.Uranium238, 8000, 50);
        registerRadioactiveMaterial(GTMaterials.Uranium235, 6500, 100);
        registerRadioactiveMaterial(GTMaterials.Plutonium241, 6000, 110);
        registerRadioactiveMaterial(GTMaterials.Naquadah, 15000, 120);
        registerRadioactiveMaterial(GTMaterials.NaquadahEnriched, 10000, 140);
        registerRadioactiveMaterial(GTMaterials.Naquadria, 7500, 160);
    }

    private static void registerRadioactiveMaterial(Material material, int duration, int radioactivity) {}
}
