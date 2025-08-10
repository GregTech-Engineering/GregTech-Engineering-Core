package org.gte.gtecore.utils;

import net.minecraft.ChatFormatting;

import java.util.regex.Pattern;

import static net.minecraft.ChatFormatting.*;
import static net.minecraft.ChatFormatting.AQUA;
import static net.minecraft.ChatFormatting.BLUE;
import static net.minecraft.ChatFormatting.GOLD;
import static net.minecraft.ChatFormatting.GREEN;
import static net.minecraft.ChatFormatting.LIGHT_PURPLE;
import static net.minecraft.ChatFormatting.YELLOW;

public final class StringUtils {

    private StringUtils() {}

    public static String[] lastDecompose(char spot, String string) {
        String[] result = { string, "" };
        int lastIndex = string.lastIndexOf(spot);
        if (lastIndex >= 0) {
            result[1] = string.substring(lastIndex + 1);
            result[0] = string.substring(0, lastIndex);
        }
        return result;
    }

    /**
     * 查询某个内容是否出现在数组中
     *
     * @param array  要查询的数组，支持通配符
     * @param target 要查询的内容
     * @return 是否存在
     */
    public static boolean containsWithWildcard(String[] array, String target) {
        for (String element : array) {
            if (Pattern.matches(element, target)) {
                return true;
            }
        }
        return false;
    }

    public static String full_color(String input) {
        return formatting(input, new ChatFormatting[] { RED, GOLD, YELLOW, GREEN, AQUA, BLUE, LIGHT_PURPLE }, 80.0D);
    }

    public static String dark_purplish_red(String input) {
        return formatting(input, new ChatFormatting[] { DARK_PURPLE, DARK_RED }, 160.0D);
    }

    private static String formatting(String input, ChatFormatting[] colours, double delay) {
        StringBuilder sb = new StringBuilder(input.length() * 3);
        if (delay <= 0.0D)
            delay = 0.001D;
        int offset = (int) Math.floor((System.currentTimeMillis() & 0x3FFFL) / delay) % colours.length;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            sb.append(colours[(colours.length + i - offset) % colours.length].toString());
            sb.append(c);
        }
        return sb.toString();
    }

    public static String[] decompose(String location) {
        return decompose(':', location);
    }

    public static String[] decompose(char spot, String string) {
        String[] astring = { string, "" };
        int i = string.indexOf(spot);
        if (i >= 0) {
            astring[1] = string.substring(i + 1);
            if (i >= 1) {
                astring[0] = string.substring(0, i);
            }
        }
        return astring;
    }
}
