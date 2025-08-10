package org.gte.gtecore.api.registries;

import org.gte.gtecore.GTECore;

import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public final class GTERegistration extends GTRegistrate {

    public static final GTERegistration REGISTRATE = new GTERegistration();

    static {
        REGISTRATE.defaultCreativeTab((ResourceKey<CreativeModeTab>) null);
    }

    private GTERegistration() {
        super(GTECore.MOD_ID);
    }
}
