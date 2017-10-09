package com.tpadsz.servlet.utils.mao;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;

/**
 * AES加密示例代码
 *
 * @date Sep 26, 2016 3:56:29 PM <br/>
 * @since JDK 1.7
 */
public class AESEncryptor {

    public static void main(String[] args) throws Exception {
        String msg = "Hello, JiuWei!"; // 具体业务数据, json字符串
        String key = "32decfe75d701e79bbed4a757548b8ad"; // 密钥
        String encryptMsg = "";

        encryptMsg = encrypt(msg, key);

        System.out.println(">> AES加密前: " + msg);
        System.out.println(">> AES加密后: " + encryptMsg);
    }

    public static String encrypt(String msg, String key) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(hex2Byte(key.getBytes(Charset.forName("UTF-8"))), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return byte2Hex(cipher.doFinal(msg.getBytes(Charset.forName("UTF-8"))));
    }

    public static String byte2Hex(byte[] bytes) {
        StringBuilder hexs = new StringBuilder();
        String s = "";
        for (int i = 0; i < bytes.length; i++) {
            s = Integer.toHexString(bytes[i] & 0XFF);
            if (s.length() == 1) {
                hexs.append("0");
            }
            hexs.append(s);
        }
        return hexs.toString();
    }

    public static byte[] hex2Byte(byte[] b) {
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);

        }
        return b2;

    }
}
