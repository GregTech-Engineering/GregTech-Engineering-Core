package com.gtecore.common;

import com.gregtechceu.gtceu.GTCEu;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.gtecore.config.GTEConfig;
import com.gtelib.GTECore;

public class CommonProxy {

    public CommonProxy() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        init();
    }

    private static void init() {
        GTECore.LOGGER.info("GTECore common proxy init!");
        GTEConfig.init();
        if (GTCEu.isDev() || GTCEu.isDataGen()) {
            GTEConfig.INSTANCE.dev = true;
            GTEConfig.INSTANCE.enablePrimitiveVoidOre = true;
        }
    }
}
