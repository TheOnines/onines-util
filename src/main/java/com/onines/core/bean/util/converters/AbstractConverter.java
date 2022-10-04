package com.onines.core.bean.util.converters;

import com.onines.core.bean.util.Converter;

public abstract class AbstractConverter implements Converter {
    private static final String PACKAGE_NAME_CONVERTERS = "com.onines.tool.core.bean.utils.converters.";
    private static final String PACKAGE_NAME_LANG = "java.lang.";
    private static final String PACKAGE_NAME_UTIL = "java.util.";
    private static final String PACKAGE_NAME_MATH = "java.math.";
    private final boolean useDefault = false;
    private Object defaultValue = null;

    public AbstractConverter(){}

    public AbstractConverter(Object defaultValue){
        this.defaultValue = defaultValue;
    }

    /**
     * 获取默认的类型
     * @return 类型
     */
    protected abstract Class<?> getDefaultType();


    @Override
    public String toString(){
        return this.toString(this.getClass()) + "[UseDefault="+this.useDefault+"]";
    }

    @SuppressWarnings({"unchecked","all"})
    String toString(Class<?> type){
        String typeName = null;
        if (null == type){
            typeName = "null";
        }else if (type.isArray()){
            Class<?> elementType = type.getComponentType();

            int count = 1;
            for (;type.isArray();++count){
                elementType = elementType.getComponentType();
            }
            typeName = elementType.getName();

            for (int i = 0; i < count; ++i) {
                typeName = typeName + "[]";
            }
        }else {
            typeName = type.getName();
        }

        if (!typeName.startsWith(PACKAGE_NAME_LANG)&&!typeName.startsWith(PACKAGE_NAME_UTIL)&&!typeName.startsWith(PACKAGE_NAME_MATH)){
            if (typeName.startsWith(PACKAGE_NAME_CONVERTERS)){
                typeName = typeName.substring(PACKAGE_NAME_CONVERTERS.length());
            }
        }else{
            typeName = typeName.substring(PACKAGE_NAME_LANG.length());
        }
        return typeName;
    }

    public boolean isUseDefault() {
        return useDefault;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }
}