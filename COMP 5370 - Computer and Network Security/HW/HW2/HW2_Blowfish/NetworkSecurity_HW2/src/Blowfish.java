import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;import java.lang.Exception;import java.lang.String;import java.lang.StringBuilder;import java.lang.System;

public class Blowfish {

    public static final String BLOWFISH = "Blowfish";
    public static String x;
    public static String encryptedResult;
    public static String decryptedResult;


    public static String encrypt(String username, String password) throws Exception {
        x = new StringBuilder(username).append(password).toString();
        byte[] keyData = (x).getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, BLOWFISH);
        Cipher cipher = Cipher.getInstance(BLOWFISH);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] result = cipher.doFinal(password.getBytes());
        encryptedResult = new BASE64Encoder().encode(result);
        System.out.println("Encrypted into " + encryptedResult);

        return encryptedResult;
    }
    public static String decrypt(String param) throws Exception {
        byte[] keyData = (x).getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, BLOWFISH);
        Cipher cipher = Cipher.getInstance(BLOWFISH);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] result = cipher.doFinal(new BASE64Decoder().decodeBuffer(param));
        decryptedResult = new String(result);
        System.out.println("Decrypted into " + decryptedResult);

        return decryptedResult;
    }

        public static void main(String[] args) throws Exception {
        encrypt("Key123", "Password");
        decrypt("b6HQ5OIpDkllskLr1kTVZw==");
    }
//
//    public static void encrypt(String username, String password) throws Exception {
//        x = new StringBuilder(username).append(password).toString();
//        byte[] keyData = (x).getBytes();
//        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, BLOWFISH);
//        Cipher cipher = Cipher.getInstance(BLOWFISH);
//        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
//        byte[] result = cipher.doFinal(password.getBytes());
//        System.out.println("Encrypted into " + new BASE64Encoder().encode(result));
//    }
//    public static void decrypt(String param) throws Exception {
//        byte[] keyData = (x).getBytes(); SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, BLOWFISH);
//        Cipher cipher = Cipher.getInstance(BLOWFISH);
//        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
//        byte[] result = cipher.doFinal(new BASE64Decoder().decodeBuffer(param));
//        System.out.println("Decrypted into " + new String(result));
//    }
}

