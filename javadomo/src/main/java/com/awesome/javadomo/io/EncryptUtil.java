package com.awesome.javadomo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2020/11/17 9:22
 * Description:加解密工具类
 */
public class EncryptUtil {
    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 9:33
     * Description:加密计算
     *
     * @param bytes     待计算的数据
     * @param algorithm 加密算法
     * @return 计算后的值
     * @throws NoSuchAlgorithmException
     */
    private static String encrypt(byte[] bytes, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : digest) {
            int i = b;
            if (i < 0) {
                // 负数转换成正数,等价于 i += 256;
                i = i & 0xFF;
            }
            if (i < 16) {
                // 让十六进制全部都是两位数
                stringBuilder.append("0");
            }
            // 把十进制的数转换成十六进制的数
            stringBuilder.append(Integer.toHexString(i));
        }
        // 32 位加密
        return stringBuilder.toString();
        // 16 位加密
//            return stringBuffer.substring(8, 24);
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 14:50
     * Description:生成加密算法的密钥
     *
     * @param algorithm 加密算法,DES/AES 等
     * @param keySize   密钥长度,DES 必须为 64 bits
     * @return 随机生成的密钥
     * @throws NoSuchAlgorithmException
     */
    private static String generateSecret(String algorithm, int keySize) throws NoSuchAlgorithmException {
        // SHA1PRNG 强随机种子算法
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        keyGenerator.init(keySize, secureRandom);
        // 生成密钥
        Key key = keyGenerator.generateKey();
        byte[] bytes = key.getEncoded();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            int i = b;
            if (i < 0) {
                // 负数转换成正数,等价于 i += 256;
                i = i & 0xFF;
            }
            if (i < 16) {
                // 让十六进制全部都是两位数
                stringBuilder.append("0");
            }
            // 把十进制的数转换成十六进制的数
            stringBuilder.append(Integer.toHexString(i));
        }
        return stringBuilder.toString();
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 13:45
     * Description:处理 DES 密钥
     *
     * @param secret 密钥
     * @return 密钥处理后返回的 key 对象
     * @throws GeneralSecurityException
     */
    private static Key getDesKey(String secret) throws GeneralSecurityException {
        DESKeySpec desKeySpec = new DESKeySpec(secret.getBytes());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        return secretKeyFactory.generateSecret(desKeySpec);
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 14:08
     * Description:处理 AES 密钥
     */
    private static Key getAesKey(String key) {
        return new SecretKeySpec(key.getBytes(), "AES");
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 9:33
     * Description:字符串 MD5 计算
     *
     * @param bytes 待计算的数据
     * @return 计算后的值
     */
    public static String md5Encrypt(byte[] bytes) {
        try {
            return encrypt(bytes, "MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 12:51
     * Description:字符串 SHA-1 计算
     *
     * @param bytes 待计算的数据
     * @return 计算后的值
     */
    public static String sha1Encrypt(byte[] bytes) {
        try {
            return encrypt(bytes, "SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 12:51
     * Description:字符串 SHA-224 计算
     *
     * @param bytes 待计算的数据
     * @return 计算后的值
     */
    public static String sha224Encrypt(byte[] bytes) {
        try {
            return encrypt(bytes, "SHA-224");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 12:51
     * Description:字符串 SHA-256 计算
     *
     * @param bytes 待计算的数据
     * @return 计算后的值
     */
    public static String sha256Encrypt(byte[] bytes) {
        try {
            return encrypt(bytes, "SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 12:51
     * Description:字符串 SHA-384 计算
     *
     * @param bytes 待计算的数据
     * @return 计算后的值
     */
    public static String sha384Encrypt(byte[] bytes) {
        try {
            return encrypt(bytes, "SHA-384");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 12:51
     * Description:字符串 SHA-512 计算
     *
     * @param bytes 待计算的数据
     * @return 计算后的值
     */
    public static String sha512Encrypt(byte[] bytes) {
        try {
            return encrypt(bytes, "SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 14:50
     * Description:生成 DES 加密算法的密钥
     *
     * @return 随机生成的密钥
     */
    public static String generateDesSecret() {
        try {
            return generateSecret("DES", 64);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 14:50
     * Description:生成 AES 加密算法的密钥
     *
     * @return 随机生成的密钥
     */
    public static String generateAesSecret() {
        try {
            return generateSecret("AES", 128);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 13:28
     * Description:DES 对称加密
     *
     * @param secret  密钥
     * @param encrypt 待加密的数据
     * @return 加密后的 byte 数组,方便查看的话可自行进行 base64 转换
     */
    public static byte[] desEncrypt(String secret, byte[] encrypt) {
        // DES 是加密方式 CBC 是工作模式 PKCS5Padding 是填充模式
        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5PADDING");
            // 初始化向量参数,AES 为 16 位,DES 为 8 位
            cipher.init(Cipher.ENCRYPT_MODE, getDesKey(secret), new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return cipher.doFinal(encrypt);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 13:28
     * Description:DES 对称解密
     *
     * @param secret  密钥
     * @param decrypt 待解密的数据
     * @return 解密后的 byte 数组,可通过 new String() 转换后方便查看
     */
    public static byte[] desDecrypt(String secret, byte[] decrypt) {
        try {
            // DES 是加密方式 CBC 是工作模式 PKCS5Padding 是填充模式
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5PADDING");
            // 初始化向量参数,AES 为 16 位,DES 为 8 位
            cipher.init(Cipher.DECRYPT_MODE, getDesKey(secret), new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return cipher.doFinal(decrypt);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 14:06
     * Description:AES 对称加密
     *
     * @param secret  密钥
     * @param encrypt 待加密的数据
     * @return 加密后的 byte 数组,方便查看的话可自行进行 base64 转换
     */
    public static byte[] aesEncrypt(String secret, byte[] encrypt) {
        // AES 是加密方式 CBC 是工作模式 PKCS5Padding 是填充模式
        try {
            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            // 初始化加密器
            cipher.init(Cipher.ENCRYPT_MODE, getAesKey(secret), new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return cipher.doFinal(encrypt);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/17 14:06
     * Description:AES 对称解密
     *
     * @param secret  密钥
     * @param decrypt 待解密的数据
     * @return 解密后的 byte 数组,可通过 new String() 转换后方便查看
     */
    public static byte[] aesDecrypt(String secret, byte[] decrypt) {
        try {
            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            // 初始化解密器
            cipher.init(Cipher.DECRYPT_MODE, getAesKey(secret), new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return cipher.doFinal(decrypt);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/18 9:17
     * Description:RSA 加密
     *
     * @param isPublicKey true 为公钥,false 为私钥
     * @param secret      密钥,通常传递的密钥为方便查看,通常为 base64 转码后的字符串,所以通常需要进行 base64 解码,
     *                    -----BEGIN PUBLIC KEY----- 与 -----END PUBLIC KEY----- 或
     *                    -----BEGIN PRIVATE KEY----- 与 -----END PRIVATE KEY----- 之间的字符串为 base64 编码后的密钥,
     *                    注意 base64 不能带有换行符和空格
     *                    eg:
     *                    公钥:
     *                    MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrsFwBUPGFEp/dVLlAEbvmJXoM5bP3foggPMXj1N4mXBaVUfsrf0vI0VNGNW6P+cPm+t5VDlr7hazZknxR26dBvxzR+Qt31NMKuCpe13HTl+ee+3wPeIOgobQC2v9AI7Y9JrOz/2qnhwnNJIHcDi9tQmV9uZL0JcGlt6GR9BIOsQIDAQAB
     *                    私钥:
     *                    MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKuwXAFQ8YUSn91UuUARu+Ylegzls/d+iCA8xePU3iZcFpVR+yt/S8jRU0Y1bo/5w+b63lUOWvuFrNmSfFHbp0G/HNH5C3fU0wq4Kl7XcdOX5577fA94g6ChtALa/0Ajtj0ms7P/aqeHCc0kgdwOL21CZX25kvQlwaW3oZH0Eg6xAgMBAAECgYEAlkckATLsdGI88+p4zA+5vFUJY8ibogJq/Gy1ehqU6FaqncDIbOZbW0d98HJMeFFSnBbyDNkn4gi7pyWFE9GDr6RLwrAinn/IBVXF/Hsz/TvxAHAG8XJdKvSFu6H9RCqryLPKMuNT7rXVc4WAI72qDnGA+sxcEc00CKDylkRVTRECQQDkh94UtgM4yAAw/u0thNHBLJas/EYh4C0xJL2gkaRN+3WDuaZhyoLhlgxHqg/w4QI/k+mtlEBapd+sTgoIaZEjAkEAwFNonpowCJDB4nZarzCSKex6UNu2TbOL7HEjK4AzI7hxtEd6f9+Tgq2H3o7jfbqcqAgO1lukdCqU6gUdiK1AGwJAcjKGwli1wXEHz3QENyPQ4TQT0zt5HEJ2ssEGVS+SKDnI3lsuDl3xCyM83a7Yqmj2A6k5MzkK84FCBUs17kA6ewJBALU7pCGY0Fyx9FJwDyJ5VbL16YlakZ8E630CXA74/rfRbixhEvl++KUy2w8JfSwUdt0MwtaSgxUIr00bRuptwDMCQHXpZEhYAzIFlzHm7q2ZA1SG0UVA5WE+TEp7UY8BEEVkiMw8sf8eTNgK3UPdBPcyRIs7esEvf8EnOonrpcxYZAc=
     * @param encrypt     待加密的数据
     * @return 加密后的 byte 数组,方便查看的话可自行进行 base64 转换
     */
    public static byte[] rsaEncrypt(boolean isPublicKey, byte[] secret, byte[] encrypt) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Key key;
            if (isPublicKey) {
                key = keyFactory.generatePublic(new X509EncodedKeySpec(secret));
            } else {
                key = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(secret));
            }
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(encrypt);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020/11/18 9:17
     * Description:RSA 解密
     *
     * @param isPublicKey true 为公钥,false 为私钥
     * @param secret      密钥,通常传递的密钥为方便查看,通常为 base64 转码后的字符串,所以通常需要进行 base64 解码,
     *                    -----BEGIN PUBLIC KEY----- 与 -----END PUBLIC KEY----- 或
     *                    -----BEGIN PRIVATE KEY----- 与 -----END PRIVATE KEY----- 之间的字符串为 base64 编码后的密钥,
     *                    注意 base64 不能带有换行符和空格
     *                    eg:
     *                    公钥:
     *                    MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrsFwBUPGFEp/dVLlAEbvmJXoM5bP3foggPMXj1N4mXBaVUfsrf0vI0VNGNW6P+cPm+t5VDlr7hazZknxR26dBvxzR+Qt31NMKuCpe13HTl+ee+3wPeIOgobQC2v9AI7Y9JrOz/2qnhwnNJIHcDi9tQmV9uZL0JcGlt6GR9BIOsQIDAQAB
     *                    私钥:
     *                    MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKuwXAFQ8YUSn91UuUARu+Ylegzls/d+iCA8xePU3iZcFpVR+yt/S8jRU0Y1bo/5w+b63lUOWvuFrNmSfFHbp0G/HNH5C3fU0wq4Kl7XcdOX5577fA94g6ChtALa/0Ajtj0ms7P/aqeHCc0kgdwOL21CZX25kvQlwaW3oZH0Eg6xAgMBAAECgYEAlkckATLsdGI88+p4zA+5vFUJY8ibogJq/Gy1ehqU6FaqncDIbOZbW0d98HJMeFFSnBbyDNkn4gi7pyWFE9GDr6RLwrAinn/IBVXF/Hsz/TvxAHAG8XJdKvSFu6H9RCqryLPKMuNT7rXVc4WAI72qDnGA+sxcEc00CKDylkRVTRECQQDkh94UtgM4yAAw/u0thNHBLJas/EYh4C0xJL2gkaRN+3WDuaZhyoLhlgxHqg/w4QI/k+mtlEBapd+sTgoIaZEjAkEAwFNonpowCJDB4nZarzCSKex6UNu2TbOL7HEjK4AzI7hxtEd6f9+Tgq2H3o7jfbqcqAgO1lukdCqU6gUdiK1AGwJAcjKGwli1wXEHz3QENyPQ4TQT0zt5HEJ2ssEGVS+SKDnI3lsuDl3xCyM83a7Yqmj2A6k5MzkK84FCBUs17kA6ewJBALU7pCGY0Fyx9FJwDyJ5VbL16YlakZ8E630CXA74/rfRbixhEvl++KUy2w8JfSwUdt0MwtaSgxUIr00bRuptwDMCQHXpZEhYAzIFlzHm7q2ZA1SG0UVA5WE+TEp7UY8BEEVkiMw8sf8eTNgK3UPdBPcyRIs7esEvf8EnOonrpcxYZAc=
     * @param decrypt     待解密的数据
     * @return 解密后的 byte 数组,可通过 new String() 转换后方便查看
     */
    public static byte[] rsaDecrypt(boolean isPublicKey, byte[] secret, byte[] decrypt) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Key key;
            if (isPublicKey) {
                key = keyFactory.generatePublic(new X509EncodedKeySpec(secret));
            } else {
                key = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(secret));
            }
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(decrypt);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 加密
     *
     * @param originalFile
     * @param encryptFile
     * @param aesSecret
     */
    public static void encryptFile(File originalFile, File encryptFile, String aesSecret) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            if (!encryptFile.exists()) {
                encryptFile.getParentFile().mkdirs();
            }
            encryptFile.createNewFile();
            in = new FileInputStream(originalFile);
            byte[] original = new byte[in.available()];
            in.read(original);
            byte[] head = ByteArrayUtil.int2ByteArray((int) originalFile.length());
            byte[] encrypt = com.future.message.util.EncryptUtil.aesEncrypt(aesSecret, original);
            out = new FileOutputStream(encryptFile);
            out.write(head);
            out.flush();
            out.write(encrypt);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 解密
     *
     * @param encryptFile
     * @param aesSecret
     */
    public static void decryptFile(File encryptFile,String aesSecret) {
        // 解密文件
        File decryptFile = new File(FilePathUtil.getMediaRecorderDecryptLocalPath());
        ShowLogUtil.info("desSecret--->start");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            if (!decryptFile.exists()) {
                decryptFile.getParentFile().mkdirs();
            }
            decryptFile.createNewFile();
            fileInputStream = new FileInputStream(encryptFile);
            byte[] head = new byte[4];
            fileInputStream.read(head);
            ShowLogUtil.info("head.length--->" + head.length);
            byte[] original = new byte[fileInputStream.available()];
            ShowLogUtil.info("original.length--->" + original.length);
            fileInputStream.read(original);
            byte[] decrypt = com.future.message.util.EncryptUtil.aesDecrypt(aesSecret, original);
            ShowLogUtil.info("decrypt.length--->" + decrypt.length);
            fileOutputStream = new FileOutputStream(decryptFile);
            fileOutputStream.write(decrypt);
            fileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ShowLogUtil.info("decryptFile.length()--->" + decryptFile.length());
    }

}
