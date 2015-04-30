/*
 * My little Java source source code
 * Pizaini
 * pizaini.wordpress.com
 */
package com.wordpress.pizaini.smartmessagingapi.debug;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pizaini
 */
public class Debugging {
    public static void showLog(String tag, String message){
        Logger.getLogger(tag).log(Level.INFO, message);
    }
}
