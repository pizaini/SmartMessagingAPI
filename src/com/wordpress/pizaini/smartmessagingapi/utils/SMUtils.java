package com.wordpress.pizaini.smartmessagingapi.utils;

import com.wordpress.pizaini.smartmessagingapi.debug.Debugging;
import com.wordpress.pizaini.smartmessagingapi.huffman.Huffman;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class SMUtils {
    private static final String TAG = "SMUtils";
    private static final String ALG = "AES";
    private static final Integer KEY_LENGTH = 128;

    /**
    * Encrypt the message
    * @param messageBytes
    * @param key The key
    * @return The chipertext byte[]
    * @throws java.lang.Exception
     */
    public static byte[] encryptMessage(byte[] messageBytes, String key) throws Exception{
        Debugging.showLog(TAG, "");
        Cipher aes = Cipher.getInstance("AES/CBC/PKCS7PADDING");
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        byte[] k = digest.digest(key.getBytes());
        //get first 128 bit (16 byte)
        k = Arrays.copyOf(k, KEY_LENGTH / 8);
        SecretKey secret = new SecretKeySpec(k, ALG);
        aes.init(Cipher.ENCRYPT_MODE, secret, new IvParameterSpec(k));
        return aes.doFinal(messageBytes);
    }

    /**
    * Decrypt the message
    * @param chiperbyte byte[] data will be decrypted
    * @param key string key
    * @return The plaintext byte[]
    * @throws java.lang.Exception
     */
    public static byte[] decryptMessage(byte[] chiperbyte, String key) throws Exception{
        Cipher aes = Cipher.getInstance("AES/CBC/PKCS7PADDING");
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        byte[] k = digest.digest(key.getBytes());
        //get first 128 bit (16 byte)
        k = Arrays.copyOf(k, KEY_LENGTH / 8);
        SecretKey secret = new SecretKeySpec(k, ALG);
        aes.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(k));
        return aes.doFinal(chiperbyte);
    }
    /**
     * Compress message
     * @param message The message will be compressed
     * @return The compressed message
     */
    public static String compressMessage(String message){
        Huffman huffman = new Huffman();
        huffman.compress(message);
        return huffman.getCompressed();
    }

    /**
     * Decompress message
     * @param binCompressed
     * @return The uncompressed message
     */
    public static String decompressMessage(String binCompressed){
        Huffman huffman = new Huffman();
        huffman.deCompress(binCompressed);
        return huffman.getDeCompressed();
    }
}