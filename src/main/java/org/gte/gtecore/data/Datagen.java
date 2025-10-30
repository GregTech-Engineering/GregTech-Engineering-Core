package org.gte.gtecore.data;

import org.gte.gtecore.common.registry.GTERegistration;
import org.gte.gtecore.data.lang.LangHandler;
import org.gte.gtecore.data.lang.provider.SimplifiedChineseLanguageProvider;
import org.gte.gtecore.data.lang.provider.TraditionalChineseLanguageProvider;

import com.tterrag.registrate.providers.ProviderType;

public class Datagen {

    public static void init() {
        GTERegistration.REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::enInitialize);
        GTERegistration.REGISTRATE.addDataGenerator(SimplifiedChineseLanguageProvider.LANG, LangHandler::cnInitialize);
        GTERegistration.REGISTRATE.addDataGenerator(TraditionalChineseLanguageProvider.LANG, LangHandler::twInitialize);
        // REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, TagsHandler::initBlock);
        // REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, TagsHandler::initItem);
    }
}
