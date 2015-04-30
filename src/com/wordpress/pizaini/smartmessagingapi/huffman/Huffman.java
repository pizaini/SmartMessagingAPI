/*
 * Blog : http://pizaini.wordpress.com
 * Email : zheiner.taurus@gmail.com
 * Huffman class for GSM 0338 char set
 * Covering the Huffman functions
 * @author Pizaini
 * (c) 2015
 */
package com.wordpress.pizaini.smartmessagingapi.huffman;

import java.util.ArrayList;
import java.util.List;

public class Huffman {
	private static final String TAG = "Huffman";
	private final HuffmanTable table;
	private String deCompressed;
	private String compressed;
	
	public Huffman() {
                    table = new HuffmanTable();
	}
	
	/**
	 * Get compressed message as binary data. This method must call after compress() method
	 * @return string binary compressed message
	 */
	public String getCompressed() {
		return compressed;
	}

	/**
	 * Get decompressed message
	 * @return String Decompressed message
	 */
	public String getDeCompressed() {
		return deCompressed;
	}

	/**
	 * Do compress message
	 * @param unCompressString String message
	 */
	public void compress(String unCompressString){
		/* Converting the character to GSM charset (external library) */
		byte[] msgByte = unCompressString.getBytes();
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < msgByte.length; i++){
			byte current = msgByte[i];
			str.append(table.getEncode(current));	
		}
		compressed = str.toString();
	}

	/**
	 * Do decompress message
	 * @param compressedBinary String compressed message
	 */
	public void deCompress(String compressedBinary){
		char[] a = compressedBinary.toCharArray();
		StringBuilder current = new StringBuilder();
		
		List<Byte> listByte = new ArrayList<>();
		for(int i = 0; i < a.length; i++){
			current.append(a[i]);
			int index = getDecode(current.toString());
			if(index != 0 ){
				listByte.add((byte) index);
//				Debugging.showLog(TAG, "");
				current.delete(0, current.length());
			}
		}
		byte[] decByte = new byte[listByte.size()];
		for(int i = 0; i < listByte.size(); i++){
			decByte[i] = listByte.get(i);
		}
		deCompressed = new String(decByte);
	}
	/**
	 * Get string character from binary string
	 * @param cur String binary massage
	 * @return String charecter
	 */
	private byte getDecode(String cur){
		byte ch = 0;
		for(byte i = 32; i < 127; i++){
			if(table.getDecode(cur, i) == i){
				ch = i;
			}
		}
		return ch;
	}
	
}