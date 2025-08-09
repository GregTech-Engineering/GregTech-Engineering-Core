package org.gte.gtecore.utils;

import java.util.regex.Pattern;

public final class StringUtils {

    private StringUtils() {}

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
}
