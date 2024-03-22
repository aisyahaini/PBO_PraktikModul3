/*Aisyah Nuraini (A11.2022.14161)
A11.44UG1 - Pemrograman Berbasis Objek Praktik
Jumat, 22 Maret 2024
Intellij IDEA*/

package PV.evolution.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicReference;

public class Encryptor {
    private final static String algorithm = "AES";
    private final static String transformation = "AES/ECB/PKCS5Padding";
    public static String generateKey() throws NoSuchAlgorithmException{
        KeyGenerator key = KeyGenerator.getInstance(algorithm);
        SecretKey secret = key.generateKey();
        AtomicReference<String> encodedKey = new AtomicReference<>(Base64.getEncoder().encodeToString(secret.getEncoded()));
        return encodedKey.get();
    }
    public static String encrypt(String plainText, String key) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0,
                decodedKey.length, algorithm);
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, originalKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        String encryptedText;
        encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        return encryptedText;
    }
    public static String decrypt(String encodedText, String key) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0,
                decodedKey.length, algorithm);
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.DECRYPT_MODE, originalKey);
        byte[] encryptedBytes = Base64.getDecoder().decode(encodedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText;
        decryptedText = new String(decryptedBytes,
                StandardCharsets.UTF_8);
        return decryptedText;
    }

}