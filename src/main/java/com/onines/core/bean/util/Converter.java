package com.onines.core.bean.util;

/**
 * @Author: Onines
 * @Date: 2022/10/4 17:55
 * @Package: com.onines.core.bean.util
 */
public interface Converter {
    /**
     * 转换为特定类型
     * @param tClass 目标类型
     * @param obj 源类型
     * @param <T> 返回值类型
     * @return 转后结果
     */
    <T> T converter(Class<T> tClass,Object obj);
}
