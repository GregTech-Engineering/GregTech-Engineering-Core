package com.gtecore.data;

import com.gtelib.api.lang.SimplifiedChineseLanguageProvider;
import com.gtelib.api.lang.TraditionalChineseLanguageProvider;

import com.gtecore.data.lang.LangHandler;

import com.gregtechceu.gtceu.GTCEu;

import com.tterrag.registrate.providers.ProviderType;

import static com.gtecore.common.registry.GTERegistration.REGISTRATE;

public class Datagen {

    public static void init() {
        if (GTCEu.isDataGen()) {
            REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::enInitialize);
            REGISTRATE.addDataGenerator(SimplifiedChineseLanguageProvider.LANG, LangHandler::cnInitialize);
            REGISTRATE.addDataGenerator(TraditionalChineseLanguageProvider.LANG, LangHandler::twInitialize);
        }
    }
}
