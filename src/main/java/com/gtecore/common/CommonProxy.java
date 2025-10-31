package com.gtecore.common;

import com.gtelib.GTECore;

import com.gtecore.config.GTEConfig;
import com.gtecore.config.GTECoreStartUpConfig;

import com.gregtechceu.gtceu.GTCEu;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CommonProxy {

    public CommonProxy() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        init();
    }

    private static void init() {
        GTECore.LOGGER.info("GTECore common proxy init!");
        GTECoreStartUpConfig.init();
        GTEConfig.init();
        if (GTCEu.isDev() || GTCEu.isDataGen()) {
            GTEConfig.INSTANCE.dev = true;
            GTECoreStartUpConfig.INSTANCE.dev = true;
            GTEConfig.INSTANCE.enablePrimitiveVoidOre = true;
        }
    }
}
