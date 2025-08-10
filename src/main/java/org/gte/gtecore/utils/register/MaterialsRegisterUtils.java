package org.gte.gtecore.utils.register;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.data.lang.LangHandler;

import com.gregtechceu.gtceu.GTCEu;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class MaterialsRegisterUtils {

    private MaterialsRegisterUtils() {}

    public static final Map<String, LangHandler.ENCN> LANG = GTCEu.isDataGen() ? new HashMap<>() : null;

    private static void addLang(String name, Supplier<LangHandler.ENCN> supplier) {
        if (LANG == null) return;
        LangHandler.ENCN lang = supplier.get();
        if (LANG.containsKey(name)) {
            GTECore.LOGGER.error("Repetitive Key: {}", name);
            throw new IllegalStateException();
        }
        if (LANG.containsValue(lang)) {
            GTECore.LOGGER.error("Repetitive Value: {}", lang);
            throw new IllegalStateException();
        }
        LANG.put(name, lang);
    }
}
