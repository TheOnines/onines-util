package com.onines.core.util;

import com.onines.core.text.CharPool;

public class CharUtil implements CharPool {

    /**
     * 是否是字符类型
     * @param value 需要判断的类型
     * @return 是否是字符类型
     */
    public static boolean isChar(Object value){
        return value instanceof Character;
    }

    /**
     * 是否为空白字符<br>
     * 空白符包括空格、制表符、全角空格和不间断空格<br>
     * @param c 字符
     * @return 是否空白字符
     * @see Character#isWhitespace(char)
     * @see Character#isSpaceChar(char)
     */
    public static boolean isBlankChar(char c){
        return isBlankChar((int) c);
    }

    /**
     * 是否为空白字符<br>
     * 空白符包括空格、制表符、全角空格和不间断空格<br>
     * @param c 字符
     * @return 是否空白字符
     * @see Character#isWhitespace(char)
     * @see Character#isSpaceChar(char)
     */
    public static boolean isBlankChar(int c) {
        return Character.isWhitespace(c)
                || Character.isSpaceChar(c)
                || c == '\ufeff'
                || c == '\u202a'
                || c == '\u0000';
    }
}