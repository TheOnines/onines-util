package com.onines.core.clone;

/**
 * 克隆支持类，提供默认的克隆方法
 * @param <T> 继承类的类型
 * @Date: 2022/10/4 19:52
 * @Author: Onines
 * @Package: com.onines.core.clone
 */
public class CloneSupport<T> implements Cloneable<T> {
    @SuppressWarnings("unchecked")
    @Override
    public T clone() {
        try {
            return (T) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException("克隆失败",e);
        }
    }
}
