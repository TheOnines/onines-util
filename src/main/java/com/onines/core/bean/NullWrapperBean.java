package com.onines.core.bean;

/**
 *
 * @param <T> Null值对应的类型
 */
public class NullWrapperBean<T> {

	private final Class<T> clazz;

	/**
	 * @param clazz null的类型
	 */
	public NullWrapperBean(Class<T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * 获取null值对应的类型
	 *
	 * @return 类型
	 */
	public Class<T> getWrappedClass() {
		return clazz;
	}
}