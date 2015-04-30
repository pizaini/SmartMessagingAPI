/*
 * My little Java source code
 * Pizaini
 * pizaini.wordpress.com
 */
package com.wordpress.pizaini.smartmessagingapi;

import com.wordpress.pizaini.smartmessagingapi.utils.SMUtils;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Pizaini
 */
public class SmartMessagingAPI {
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        String message = "selamat datang di blog pizaini.wordpress.com";
        String key = "secretKey";
        String compress = SMUtils.compressMessage(message);
        System.out.println("Message: "+message);
        System.out.println("Compressed: "+compress);
        System.out.println("Decompressed: "+SMUtils.decompressMessage(compress));
        byte[] cipher = SMUtils.encryptMessage(message.getBytes(), key);
        System.out.println("Cipher: "+DatatypeConverter.printHexBinary(cipher));
        byte[] plain = SMUtils.decryptMessage(cipher, key);
        System.out.println("Plain: "+new String(plain));
    }
    
}
