package com.onines.core.codec.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtil {

    /**
     * 返回给定算法的 {@link MessageDigest}
     * @param algorithm 加密算法
     * @return MessageDigest实例
     */
    public static MessageDigest getDigest(final String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (final NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static MessageDigest getMd5Digest(){
        return getDigest(MessageDigestAlgorithms.MD5);
    }
}
