package com.tpadsz.servlet.utils.mao;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;

/**
 * AES解密示例代码
 *
 * @date    Sep 26, 2016 4:12:56 PM <br/>
 * @version
 * @since   JDK 1.7
 */
public class AESDecryptor {

    public static void main(String[] args) throws Exception {
        String encryptMsg = "deb38a82c98127121cf663daa8d7df0975b894c6ead6e0bc57c53228ed225dda"; // 已加密的字符串
        String key = "dd2a5427c052e798faf790b4900f723c"; // 密钥
        String msg = ""; // 具体业务数据, json字符串

        msg = decrypt(encryptMsg, key);

        System.out.println(">> AES解密前: " + encryptMsg);
        System.out.println(">> AES解密后: " + msg);
    }

    public static String decrypt(String msg, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(hex2Byte(key.getBytes(Charset.forName("UTF-8"))), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        return new String(cipher.doFinal(hex2Byte(msg.getBytes(Charset.forName("UTF-8")))), Charset.forName("UTF-8"));
    }

    public static byte[] hex2Byte(byte[] b) {
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n/2] = (byte) Integer.parseInt(item, 16);

        }

        return b2;
    }

}