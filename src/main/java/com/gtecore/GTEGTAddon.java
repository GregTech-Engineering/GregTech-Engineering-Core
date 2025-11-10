package com.gtecore;

import com.gtelib.GTECore;

import com.gtecore.common.registry.GTERegistration;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

@GTAddon
public class GTEGTAddon implements IGTAddon {

    @Override
    public GTRegistrate getRegistrate() {
        return GTERegistration.REGISTRATE;
    }

    @Override
    public void initializeAddon() {}

    @Override
    public String addonModId() {
        return GTECore.Core_ID;
    }

    @Override
    public boolean requiresHighTier() {
        return true;
    }
}
