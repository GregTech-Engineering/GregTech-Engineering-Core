package com.gtecore.config;

import com.gtelib.GTECore;

import com.gregtechceu.gtceu.config.ConfigHolder;

import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = GTECore.Config_ID, group = GTECore.Core_ID)
public class GTEConfig {

    public static GTEConfig INSTANCE;
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
                INSTANCE = Configuration.registerConfig(GTEConfig.class, ConfigFormats.YAML).getConfigInstance();
            }

            ConfigHolder.init();

            int difficulty = getDifficulty();

            int boilerFactor = 8 >> difficulty;

            ConfigHolder.INSTANCE.dev.debug = GTEConfig.INSTANCE.dev;
        }
    }

    @Configurable
    @Configurable.Comment({ "Optional: Simple, Normal, Expert" })
    public Difficulty gameDifficulty = Difficulty.Normal;
    @Configurable
    @Configurable.Comment("Prevent cheating")
    public boolean selfRestraint = false;
    @Configurable
    @Configurable.Comment("Enabled, no mining required")
    public boolean enablePrimitiveVoidOre;
    @Configurable
    @Configurable.Comment("Remove unnecessary loading")
    public boolean fastMultiBlockPage = true;
    @Configurable
    @Configurable.Comment("GT BlockEntity synchronization of client and server data")
    @Configurable.Range(min = 1, max = 40)
    public int synchronousInterval = 10;
    @Configurable
    @Configurable.Comment("The interval increases gradually when the machine cannot find a recipe; this is the maximum interval.")
    @Configurable.Range(min = 1, max = 200)
    public int recipeMaxCheckInterval = 40;
    @Configurable
    @Configurable.Comment("After enabling, the recipe search runs in an independent thread and will not affect the TPS.")
    public boolean asyncRecipeSearch = true;
    @Configurable
    @Configurable.Comment("After enabling, the recipe output runs in an independent thread and will not affect the TPS.")
    public boolean asyncRecipeOutput = true;
    @Configurable
    @Configurable.Comment("Ore product multiplier")
    @Configurable.Range(min = 1, max = 64)
    public int oreMultiplier = 4;
    @Configurable
    public String[] breakBlocksBlackList = { "ae2:cable_bus" };

    @Configurable
    @Configurable.Comment("Check for conflicts between recipes")
    public boolean recipeCheck = false;
    @Configurable
    @Configurable.Comment("Dev Mode")
    public boolean dev = false;
}
