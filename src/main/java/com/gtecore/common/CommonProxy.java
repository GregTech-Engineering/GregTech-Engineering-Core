package com.gtecore.common;

import com.gtelib.GTECore;
import com.gtelib.api.registries.ScanningClass;

import com.gtecore.config.GTEConfig;
import com.gtecore.config.GTECoreStartUpConfig;
import com.gtecore.data.Datagen;

import com.gregtechceu.gtceu.GTCEu;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CommonProxy {

    public CommonProxy() {
        init();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(CommonProxy::modConstruct);
    }

    private static void init() {
        GTECore.CoreLOGGER.info("GTECore common proxy init!");
        ScanningClass.init();
        GTECoreStartUpConfig.init();
        GTEConfig.init();
        if (GTCEu.isDev() || GTCEu.isDataGen()) {
            GTECoreStartUpConfig.INSTANCE.dev = true;
            GTEConfig.INSTANCE.dev = true;
            GTEConfig.INSTANCE.enablePrimitiveVoidOre = true;
        }
    }

    private static void modConstruct(FMLConstructModEvent event) {
        Datagen.init();
    }
}
