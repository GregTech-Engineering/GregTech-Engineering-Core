package org.gte.gtecore.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public interface PetrochemRecipes {

    static void init() {
        crack(SulfuricHeavyFuel, SeverelySteamCrackedHeavyFuel, LightlySteamCrackedHeavyFuel);
        crack(SulfuricLightFuel, SeverelySteamCrackedLightFuel, LightlySteamCrackedLightFuel);
        crack(SulfuricNaphtha, SeverelySteamCrackedNaphtha, LightlySteamCrackedNaphtha);
        crack(SulfuricGas, SeverelySteamCrackedGas, LightlySteamCrackedGas);
    }

    private static void crack(Material... cracked) {}
}
