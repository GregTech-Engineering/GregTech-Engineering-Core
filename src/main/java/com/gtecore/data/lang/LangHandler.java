package com.gtecore.data.lang;

import com.gtelib.api.annotation.dynamic.DynamicInitialData;
import com.gtelib.api.lang.CNEN;
import com.gtelib.api.lang.SimplifiedChineseLanguageProvider;
import com.gtelib.api.lang.TraditionalChineseLanguageProvider;
import com.gtelib.api.registries.ScanningClass;
import com.gtelib.utils.ChineseConverter;
import com.gtelib.utils.collection.O2OOpenCacheHashMap;

import net.minecraftforge.common.data.LanguageProvider;

import java.util.Map;

public class LangHandler {

    private static final Map<String, CNEN> LANGS = new O2OOpenCacheHashMap<>();

    private static void addCNEN(String key, CNEN CNEN) {
        if (LANGS.containsKey(key)) throw new IllegalArgumentException("Duplicate key: " + key);
        LANGS.put(key, CNEN);
    }

    public static void addCNEN(String key, String cn, String en) {
        addCNEN(key, new CNEN(cn, en));
    }

    public static void addCN(String key, String cn) {
        addCNEN(key, cn, null);
    }

    private static void init() {
        ScanningClass.LANG.forEach(LangHandler::addCNEN);
        DynamicInitialData.LANG.forEach(LangHandler::addCNEN);
    }

    public static void enInitialize(LanguageProvider provider) {
        init();
        LANGS.forEach((k, v) -> {
            if (v.en() == null) return;
            provider.add(k, v.en());
        });
    }

    public static void cnInitialize(SimplifiedChineseLanguageProvider provider) {
        LANGS.forEach((k, v) -> {
            if (v.cn() == null) return;
            provider.add(k, v.cn());
        });
    }

    public static void twInitialize(TraditionalChineseLanguageProvider provider) {
        LANGS.forEach((k, v) -> {
            if (v.cn() == null) return;
            provider.add(k, ChineseConverter.convert(v.cn()));
        });
    }
}
