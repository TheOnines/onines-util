package com.onines.core.map;

import java.util.Map;

public class MapUtil {

    /**
     * Map是否为非空
     *
     * @param map 集合
     * @return 是否为非空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return null != map && !map.isEmpty();
    }

    public static  boolean isEmpty(Map<?,?> map) {
        return null == map || map.isEmpty();
    }
}