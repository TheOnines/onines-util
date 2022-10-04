package com.onines.core.clone;

/**
 * 克隆支持接口
 * @param <T> 实现克隆接口的类型
 * @Date: 2022/10/4 17:45
 * @Author: Onines
 * @Package: com.onines.core.clone
 */
public interface Cloneable<T> extends java.lang.Cloneable {
    /**
     * 浅克隆当前对象
     * @return 克隆后的对象
     */
    T clone();
}
