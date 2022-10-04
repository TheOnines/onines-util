package com.onines.core.codec.digest;

import java.security.SecureRandom;
import java.util.Random;

public class B64 {

    /**
     * 用于Base64转换的字符
     */
    static final String B64T_STRING = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    /**
     * 用于Base64转换的字符
     */
    static final char[] B64T_ARRAY = B64T_STRING.toCharArray();


    /**
     * 从 B64T 集中生成一串随机字符。
     * 盐是使用提供的 Random 生成的。
     * @param num 盐值长度
     * @return 随机盐值
     */
    static String getRandomSalt(final int num){return getRandomSalt(num,new SecureRandom());}

    /**
     * 从 B64T 集中生成一串随机字符。
     * 盐是使用提供的 Random 生成的。
     * @param num 盐值长度
     * @param random 随机数 {@link Random}
     * @return 盐值
     */
    static String getRandomSalt(final int num, final Random random){
        StringBuilder saltString = new StringBuilder();
        for (int i = 0; i < num; i++) {
            saltString.append(B64T_STRING.charAt(random.nextInt(B64T_STRING.length())));
        }
        return saltString.toString();
    }

    /**
     * 将字节转换为 ASCII 字符
     * @param b2 结果中的一个字节
     * @param b1 结果中的一个字节
     * @param b0 结果中的一个字节
     * @param outLen 输出长度
     * @param buffer 追加字符的地方
     */
    static void b64from24bit(final byte b2, final byte b1, final byte b0, final int outLen,
                             final StringBuilder buffer) {
        // 位掩码是必要的，因为 JVM 字节类型是有符号的
        int w = ((b2 << 16) & 0x00ffffff) | ((b1 << 8) & 0x00ffff) | (b0 & 0xff);

        int n = outLen;
        while (n-- > 0) {
            buffer.append(B64T_ARRAY[w & 0x3f]);
            w >>= 6;
        }
    }
}