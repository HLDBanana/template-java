package com.hanergy.out.utils;


import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version V1.0
 * @desc AES 加密工具类
 */
public class AESUtil {

    private static final String KEY_ALGORITHM = "AES";
    /**
     * 默认的加密算法
     */
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    public static final String ECRYPT_PASSWORD = "ESOURCING";

    /**
     * AES 加密操作
     *
     * @param content  待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String password) {
        try {
            // 创建密码器
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            //通过Base64转码返回
            return Base64.encodeBase64String(result);
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @param password
     * @return
     */
    public static String decrypt(String content, String password) {

        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));

            //执行操作
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));

            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKey getSecretKey(final String password) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            //AES 要求密钥长度为 128
            kg.init(128, new SecureRandom(password.getBytes()));

            //生成一个密钥
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
            secureRandom.setSeed(password.getBytes());
            // 转换为AES专用密钥
            return kg.generateKey();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {

        try {
//            String encrypt = RSAUtils.encryptByPublicKey("12345", RSAUtils.ESOURCING_PUBLIC_KEY);
//            System.out.println(encrypt);
//            String test = AESUtil.encrypt(encrypt, AESUtil.ECRYPT_PASSWORD);
//            System.out.println(test);
//
//            System.out.println("************************");

            String test = "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";
            String decrypt = AESUtil.decrypt(test, AESUtil.ECRYPT_PASSWORD);
            System.out.println(decrypt);

            String key = RSAUtils.decryptByPrivateKey(decrypt, RSAUtils.ESOURCING_PRIVATE_KEY);

            System.out.println(key);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}