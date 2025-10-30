package org.gte.gtecore.data.lang;

import org.gte.gtecore.data.lang.provider.SimplifiedChineseLanguageProvider;
import org.gte.gtecore.data.lang.provider.TraditionalChineseLanguageProvider;
import org.gte.gtecore.utils.ChineseConverter;

import com.gregtechceu.gtceu.api.GTValues;

import net.minecraftforge.common.data.LanguageProvider;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

import java.util.Arrays;
import java.util.Map;

public final class LangHandler {

    private static final Map<String, ENCN> LANGS = new Object2ObjectOpenHashMap<>();

    private static void addENCN(String key, ENCN encn) {
        if (LANGS.containsKey(key)) throw new IllegalArgumentException("Duplicate key: " + key);
        LANGS.put(key, encn);
    }

    static void addENCN(String key, String en, String cn) {
        addENCN(key, new ENCN(en, cn));
    }

    private static void addCN(String key, String cn) {
        addENCN(key, null, cn);
    }

    private static void init() {
        addCN("entity.gtecore.task_entity", "任务执行实体");
        addCN("itemGroup.gtecore.block", "GTE | 方块");
        addCN("itemGroup.gtecore.item", "GTE | 物品");
        addCN("itemGroup.gtecore.machine", "GTE | 机器");
        addCN("itemGroup.gtecore.material_block", "GTE | 材料方块");
        addCN("itemGroup.gtecore.material_fluid", "GTE | 材料流体");
        addCN("itemGroup.gtecore.material_item", "GTE | 材料物品");
        addCN("itemGroup.gtecore.material_pipe", "GTE | 材料管道");

        for (int tier = GTValues.UHV; tier < 16; tier++) {
            int a = (1 << (2 * (tier - 4)));
            addENCN("gtceu.machine.parallel_hatch_mk" + tier + ".tooltip", "Allows to run up to " + a + " recipes in parallel.", "允许同时处理至多" + a + "个配方。");
        }

        addENCN("gtceu.machine.available_recipe_map_5.tooltip", "Available Recipe Types: %s, %s, %s, %s, %s", "可用配方类型：%s，%s，%s，%s，%s");
        addENCN("gtceu.machine.available_recipe_map_6.tooltip", "Available Recipe Types: %s, %s, %s, %s, %s, %s", "可用配方类型：%s，%s，%s，%s，%s，%s");

        addENCN("key.gtecore.flyingspeed", "Flight Speed Adjustment", "飞行速度调节");
        addENCN("key.gtecore.nightvision", "Night Vision Toggle", "夜视开关");
        addENCN("key.gtecore.vajra", "Vajra Key", "金刚杵按键");
        addENCN("key.gtecore.drift", "Flight Inertia", "飞行惯性");
        addENCN("key.keybinding.gtecore", "GTE Key Bindings", "GTE按键绑定");

        addENCN("structure_writer.export_order", "Export Order: C:%s  S:%s  A:%s", "导出顺序： C:%s  S:%s  A:%s");
        addENCN("structure_writer.structural_scale", "Structural Scale: X:%s  Y:%s  Z:%s", "结构规模： X:%s  Y:%s  Z:%s");

        addENCN("gtecore.pattern.blocking_mode", "Block insertion when the container has any content (except for programming circuits)", "容器有任何内容时阻止插入（编程电路除外）");
        addENCN("gtecore.pattern.blocking_reverse", "Reverse", "反转");
        addENCN("gtecore.pattern.multiply", "Pattern Recipe x %s", "样板配方 x %s");
        addENCN("gtecore.pattern.tooltip.multiply", "Multiply Pattern materials amount by %s", "将样板材料数量 x %s");
        addENCN("gtecore.pattern.divide", "Pattern Recipe ÷ %s", "样板配方 ÷ %s");
        addENCN("gtecore.pattern.tooltip.divide", "Divide Pattern materials amount by %s", "将样板材料数量 ÷ %s");

        addENCN("gtecore.dev", "The current version is a development test version and cannot guarantee the stability and completeness of the content. If you encounter any issues or have any suggestions, please go to %s to provide feedback.", "当前版本是开发测试版本，不能保证内容的稳定性和完整性。如果您遇到任何问题或有任何建议，请前往%s提供反馈。");
        addENCN("gtecore.fly_speed_reset", "fly Speed Reset", "飞行速度已重置");
        addENCN("gtecore.fly_speed", "fly Speed x%s", "飞行速度 x%s");
        addENCN("gtecore.reach_limit", "Reach Limit", "达到极限");
        addENCN("gtecore.me_any", "ME hatch allows connection from any side.", "ME仓允许任意面连接");
        addENCN("gtecore.me_front", "ME hatch only allows connection from the front side.", "ME仓只允许正面连接");
        addENCN("gtecore.unlocked", "Unlocked", "解锁的");
        addENCN("gtecore.ununlocked", "Ununlocked", "未解锁");
        addENCN("gtecore.build", "Build", "构建");

        addENCN("config.gtecore.option.travelStaffCD", "Travel Scepter Minimal CD", "旅行权杖最小CD");
        addENCN("config.gtecore.option.selfRestraint", "Self Restraint Mode", "自我约束模式");
        addENCN("config.gtecore.option.eioFluidRate", "EIO Fluid Pipe Rate Multiplier", "EIO流体管道速率倍数");
        addENCN("config.gtecore.option.enablePrimitiveVoidOre", "Enable Primitive Void Ore Machine", "启用原始虚空矿机");
        addENCN("config.gtecore.option.oreMultiplier", "Ore Yield Multiplier", "矿石产量乘数");
        addENCN("config.gtecore.option.fastMultiBlockPage", "Fast MultiBlock Page", "优化多方块页面");
        addENCN("config.gtecore.option.synchronousInterval", "Synchronous Interval", "双端同步间隔");
        addENCN("config.gtecore.option.recipeMaxCheckInterval", "Recipe Max Check Interval", "配方最大检查间隔");
        addENCN("config.gtecore.option.asyncRecipeSearch", "Async Recipe Search", "异步配方搜索");
        addENCN("config.gtecore.option.asyncRecipeOutput", "Async Recipe Output", "异步配方输出");
        addENCN("config.gtecore.option.breakBlocksBlackList", "Black List Of Chain Blocks", "连锁挖掘黑名单");
        addENCN("config.screen.gtecore", "GTE Core Config", "GTE Core 配置");
        addENCN("config.gtecore.option.recipeCheck", "[Debug]Recipe Abnormal Check", "[调试]配方异常检查");
        addENCN("config.gtecore.option.dev", "Dev mode", "开发模式");
        addENCN("config.gtecore.option.gameDifficulty", "Game difficulty", "游戏难度");
        addENCN("config.gtecore.option.emiGlobalFavorites", "EMI Global Favorites", "全局 EMI 书签");
        addENCN("config.gtecore.option.enableAnimalsAreAfraidToEatTheirMeat", "Enable Animals Are Afraid To Eat Their Meat", "启用动物害怕他们的肉被吃");
        addENCN("config.gtecore.option.animalsAreAfraidToEatTheirMeatRange", "Animals Are Afraid To Eat Their Meat's Range", "动物害怕他们的肉被吃的范围");
    }

    public static void enInitialize(LanguageProvider provider) {
        init();
        MachineLang.init();
        BlockLang.init();
        ItemLang.init();
        LANGS.forEach((k, v) -> {
            if (v.en == null) return;
            provider.add(k, v.en);
        });
    }

    public static void cnInitialize(SimplifiedChineseLanguageProvider provider) {
        LANGS.forEach((k, v) -> {
            if (v.cn == null) return;
            provider.add(k, v.cn);
        });
    }

    public static void twInitialize(TraditionalChineseLanguageProvider provider) {
        LANGS.forEach((k, v) -> {
            if (v.cn == null) return;
            provider.add(k, ChineseConverter.convert(v.cn));
        });
    }

    public record ENCN(String en, String cn) {

        @Override
        public boolean equals(Object o) {
            if (o instanceof ENCN encn) {
                return encn.en.equals(en) && encn.cn.equals(cn);
            }
            return false;
        }
    }

    public record ENCNS(String[] ens, String[] cns) {

        @Override
        public boolean equals(Object o) {
            if (o instanceof ENCNS encn) {
                return Arrays.equals(encn.ens, ens) && Arrays.equals(encn.cns, cns);
            }
            return false;
        }

        public int length() {
            return ens.length;
        }
    }
}
