package com.gtecore.config;

import com.gtelib.GTECore;

import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = GTECore.StartUpConfig_ID, group = GTECore.Core_ID)
public class GTECoreStartUpConfig {

    public static GTECoreStartUpConfig INSTANCE;
    private static final Object LOCK = new Object();

    private static int difficulty = 0;

    public static int getDifficulty() {
        if (difficulty == 0) {
            difficulty = INSTANCE.gameDifficulty.ordinal() + 1;
        }
        return difficulty;
    }

    public static void init() {
        synchronized (LOCK) {
            if (INSTANCE == null) {
                INSTANCE = Configuration.registerConfig(GTECoreStartUpConfig.class, ConfigFormats.YAML).getConfigInstance();
            }
        }
    }

    @Configurable
    @Configurable.Comment({ "Optional: Simple, Normal, Expert" })
    public Difficulty gameDifficulty = Difficulty.Normal;
    @Configurable
    @Configurable.Comment("Dev Mode")
    public boolean dev = false;
}
