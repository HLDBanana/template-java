package com.hanergy.out.utils;


import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class RSAUtils {

    public static final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJFBnk78A4CN5gBpIV/pGOGqi/CzvwjvXoj2gYXtbEIg+ZxpRrVi7Is6dwIK4+xrDr35ExaN1s4GnyF3g88z93iYpM5URhQTRJ/GGENNlozkLNARRdTJfLuJxBMZHnAGOtuNTXIcIo5/k8klllBYHTqG6xIVnjRN0vsV2UGlnW7VAgMBAAECgYBMoT9xD8aRNUrXgJ7YyFIWCzEUZN8tSYqn2tPt4ZkxMdA9UdS5sFx1/vv1meUwPjJiylnlliJyQlAFCdYBo7qzmib8+3Q8EU3MDP9bNlpxxC1go57/q/TbaymWyOk3pK2VXaX+8vQmllgRZMQRi2JFBHVoep1f1x7lSsf2TpipgQJBANJlO+UDmync9X/1YdrVaDOi4o7g3w9u1eVq9B01+WklAP3bvxIoBRI97HlDPKHx+CZXeODx1xj0xPOK3HUz5FECQQCwvdagPPtWHhHx0boPF/s4ZrTUIH04afuePUuwKTQQRijnl0eb2idBe0z2VAH1utPps/p4SpuT3HI3PJJ8MlVFAkAFypuXdj3zLQ3k89A5wd4Ybcdmv3HkbtyccBFALJgs+MPKOR5NVaSuF95GiD9HBe4awBWnu4B8Q2CYg54F6+PBAkBKNgvukGyARnQGc6eKOumTTxzSjSnHDElIsjgbqdFgm/UE+TJqMHmXNyyjqbaA9YeRc67R35HfzgpvQxHG8GN5AkEAxSKOlfACUCQ/CZJovETMmaUDas463hbrUznp71uRMk8RP7DY/lBnGGMeUeeZLIVK5X2Ngcp9nJQSKWCGtpnfLQ==";
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRQZ5O/AOAjeYAaSFf6Rjhqovws78I716I9oGF7WxCIPmcaUa1YuyLOncCCuPsaw69+RMWjdbOBp8hd4PPM/d4mKTOVEYUE0SfxhhDTZaM5CzQEUXUyXy7icQTGR5wBjrbjU1yHCKOf5PJJZZQWB06husSFZ40TdL7FdlBpZ1u1QIDAQAB";

    /**
     * Esourcing 加密KEY
     */
    public static final String ESOURCING_PUBLIC_KEY="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDJfoZHuHrwrM/unPX0rFEvoNkCTPyANXTKEYc2MaZYlcet+jo84qdy113TCP2YyOJxhqwvS49ArxYGymCFfzoq4lHfJbw6lUkRWR2cpE7nOJ7+mSPrxcbxAmRwD2AMlyX9uA6drypbyRnv8qCmf7kQNuT2540s8WOEdO1rNfUYPwIDAQAB";
    public static final String ESOURCING_PRIVATE_KEY="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMl+hke4evCsz+6c9fSsUS+g2QJM/IA1dMoRhzYxpliVx636Ojzip3LXXdMI/ZjI4nGGrC9Lj0CvFgbKYIV/OiriUd8lvDqVSRFZHZykTuc4nv6ZI+vFxvECZHAPYAyXJf24Dp2vKlvJGe/yoKZ/uRA25PbnjSzxY4R07Ws19Rg/AgMBAAECgYBgzQ071ZASoiM/El9DTamvRQochdnkykmybltUGOQ+uK52kbl62LTzgi4MHcyfoxrOyZFdI2LOA4+EcaOPXwEVD+RW8uFendD+cnkL5Qpul54dTncVg/PAbYtP0fzMT9NrHdFKImIKQ1noyBokL1krS7K+lZVsCe190+2givdtwQJBAPpfAIuO1sE2A44R05/iDB6w98i8/E5991Rs+AaOat7SDzvENNpxJpgQ74WyUzYt0L/m6PzuKpfdmalPGAgu2d8CQQDOBjbR/CMncXmxpjxo4Rj6COp9VYcERZ06tK3Xjp92dC/pn3uoE1VDvBc/rNyKT7uh13idc3ze58544h/Ryk2hAkArrHbD4V7ExU9JcQKhWSUUFXqjoZPBfWevanK5cg5iX/IYUtmFYUeCLzIY+EpboRJQ506tED6NzzIGvq1KgCGxAkEAs924/pqiFk17cR0woF/k7mXaUpHYzmH4Ysha/VYG4eON8OjLjHFUf042/eBsqlPx+9mh89RfsDuwhtjj7sQwAQJAbuZ2TEdeVQQC1RfuJwBversTB6pBnIT0N/MoKNrQ7GucA1Ay8f34dpSQJfNKoLNr7xzYoRo9KqwryHgvs7861g==";


    /** RSA max encrypt Uncoverd size */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /** RSA max decrypt size */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /** RSA */
    private static final String KEY_ALGORITHM = "RSA";

    /**
     * Generate Public Key and Private Key
     *
     * @throws Exception
     *
     */
    public static void getKeys() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        String publicKeyStr = getPublicKeyStr(publicKey);
        String privateKeyStr = getPrivateKeyStr(privateKey);

        System.out.println("公钥\r\n" + publicKeyStr);
        System.out.println("私钥\r\n" + privateKeyStr);
    }

    /**
     * 使用模和指数生成RSA公钥
     * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
     * /None/NoPadding】
     *
     * @param modulus
     *            模
     * @param exponent
     *            公钥指数
     * @return
     */
    public static RSAPublicKey getPublicKey(String modulus, String exponent) {
        try {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用模和指数生成RSA私钥
     * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
     * /None/NoPadding】
     *
     * @param modulus
     *            模
     * @param exponent
     *            指数
     * @return
     */
    public static RSAPrivateKey getPrivateKey(String modulus, String exponent) {
        try {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 公钥加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String data) throws Exception {
        byte[] dataByte = data.getBytes();
        byte[] keyBytes = Base64Utils.decode(PUBLIC_KEY);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        // Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = dataByte.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(dataByte, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(dataByte, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return Base64Utils.encode(encryptedData);
    }
    // 公钥加密
    public static String encryptByPublicKey(String data,String publicKey) throws Exception {
        byte[] dataByte = data.getBytes();
        byte[] keyBytes = Base64Utils.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        // Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = dataByte.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(dataByte, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(dataByte, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return Base64Utils.encode(encryptedData);
    }

    /**
     * 私钥解密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String data) throws Exception {
        byte[] encryptedData = Base64Utils.decode(data);
        byte[] keyBytes = Base64Utils.decode(PRIVATE_KEY);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        // Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        cipher.init(Cipher.DECRYPT_MODE, privateK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher
                        .doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher
                        .doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return new String(decryptedData);
    }

    public static String decryptByPrivateKey(String data,String privateKey) throws Exception {
        byte[] encryptedData = Base64Utils.decode(data);
        byte[] keyBytes = Base64Utils.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        // Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        cipher.init(Cipher.DECRYPT_MODE, privateK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher
                        .doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher
                        .doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return new String(decryptedData);
    }

    /**
     * 获取模数和密钥
     *
     * @return
     */
    public static Map<String, String> getModulusAndKeys() {

        Map<String, String> map = new HashMap<String, String>();

        try {
            InputStream in = RSAUtils.class
                    .getResourceAsStream("/rsa.properties");
            Properties prop = new Properties();
            prop.load(in);

            String modulus = prop.getProperty("modulus");
            String publicKey = prop.getProperty("publicKey");
            String privateKey = prop.getProperty("privateKey");

            in.close();

            map.put("modulus", modulus);
            map.put("publicKey", publicKey);
            map.put("privateKey", privateKey);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyStr
     *            公钥数据字符串
     * @throws Exception
     *             加载公钥时产生的异常
     */
    public static PublicKey loadPublicKey(String publicKeyStr) throws Exception {
        try {
            byte[] buffer = Base64Utils.decode(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("公钥非法");
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        }
    }

    /**
     * 从字符串中加载私钥<br>
     * 加载时使用的是PKCS8EncodedKeySpec（PKCS#8编码的Key指令）。
     *
     * @param privateKeyStr
     * @return
     * @throws Exception
     */
    public static PrivateKey loadPrivateKey(String privateKeyStr)
            throws Exception {
        try {
            byte[] buffer = Base64Utils.decode(privateKeyStr);
            // X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("私钥非法");
        } catch (NullPointerException e) {
            throw new Exception("私钥数据为空");
        }
    }

    public static String getPrivateKeyStr(PrivateKey privateKey)
            throws Exception {
        return new String(Base64Utils.encode(privateKey.getEncoded()));
    }

    public static String getPublicKeyStr(PublicKey publicKey) throws Exception {
        return new String(Base64Utils.encode(publicKey.getEncoded()));
    }
}