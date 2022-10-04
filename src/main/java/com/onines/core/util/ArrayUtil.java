package com.onines.core.util;

import java.util.Arrays;

public class ArrayUtil {
    /**
     * 判断数组是否为空
     * @param arr 数组
     * @return 空 true,非空false
     */
    public static <T> boolean isEmpty(T[] arr){
        return null == arr || arr.length == 0;
    }

    /**
     * 对象是否为数组对象
     *
     * @param obj 对象
     * @return 是否为数组对象，如果为{@code null} 返回false
     */
    public static boolean isArray(Object obj) {
        return null != obj && obj.getClass().isArray();
    }

    /**
     * 数组或集合转String
     *
     * @param obj 集合或数组对象
     * @return 数组字符串，与集合转字符串格式相同
     */
    public static String toString(Object obj) {
        if (null == obj) {
            return null;
        }

        if (obj instanceof long[]) {
            return Arrays.toString((long[]) obj);
        } else if (obj instanceof int[]) {
            return Arrays.toString((int[]) obj);
        } else if (obj instanceof short[]) {
            return Arrays.toString((short[]) obj);
        } else if (obj instanceof char[]) {
            return Arrays.toString((char[]) obj);
        } else if (obj instanceof byte[]) {
            return Arrays.toString((byte[]) obj);
        } else if (obj instanceof boolean[]) {
            return Arrays.toString((boolean[]) obj);
        } else if (obj instanceof float[]) {
            return Arrays.toString((float[]) obj);
        } else if (obj instanceof double[]) {
            return Arrays.toString((double[]) obj);
        } else if (ArrayUtil.isArray(obj)) {
            // 对象数组
            try {
                return Arrays.deepToString((Object[]) obj);
            } catch (Exception ignore) {
                //ignore
            }
        }

        return obj.toString();
    }

    /**
     * 数组是否包含null 如果数组为空或 null，认定不包含
     * @param array 待检数组
     * @param <T> 数组类型
     * @return true-if the array has null
     */
    public static <T> boolean hasNull(T[] array) {
        if (null == array || array.length == 0 ){
            return false;
        }
        return Arrays.stream(array).anyMatch(ObjectUtil::isNull);
    }

    /**
     * 判断不为空
     * @param array 待检数组
     * @param <T> 数组类型
     * @return true-if array is not empty
     */
    public static <T> boolean isNotEmpty(T[] array){
        return !isEmpty(array);
    }

}
