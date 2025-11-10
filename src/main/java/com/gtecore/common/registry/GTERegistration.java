package com.gtecore.common.registry;

import com.gtelib.GTECore;

import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.registry.GTRegistration;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class GTERegistration {

    public static final GTRegistrate REGISTRATE = GTRegistrate.create(GTECore.Core_ID);
    static {
        GTRegistration.REGISTRATE.defaultCreativeTab((ResourceKey<CreativeModeTab>) null);
    }

    private GTERegistration() {/**/}
}
