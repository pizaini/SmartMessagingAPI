/*
 * Created by Pizaini
 * Blog : http://pizaini.wordpress.com
 * Email : zheiner.taurus@gmail.com
 * (c) 2015
 */
package com.wordpress.pizaini.smartmessagingapi.huffman;

import com.wordpress.pizaini.smartmessagingapi.debug.Debugging;


/**
 * Huffman static table based on Huffman tree on the document
 * This table base on GSM 0338 charset
 * @author Pizaini
 */
class HuffmanTable {
	private final static String TAG = "HuffmanTable";
	private final String[] TABLE = new String[128];

	public HuffmanTable() {
		Debugging.showLog(TAG, "");
		TABLE[32] = "1011";
		TABLE[33] = "1100011";
		TABLE[34] = "1100110";
		//TABLE[35] = "1100110"; //#
		//TABLE[36] = "1100110"; //$
		TABLE[37] = "1111110"; //%
		//TABLE[38] = "1100110"; //&
		//TABLE[39] = "1100100"; //'
		//TABLE[40] = "1111101"; //(
		//TABLE[41] = "1111111"; //)
		//TABLE[42] = "1111111"; //,
		//TABLE[43] = "1111111"; //+
		TABLE[44] = "1100001";
		TABLE[45] = "1100101";
		TABLE[46] = "1100000";
		TABLE[47] = "1111011";
		TABLE[48] = "1110000";
		TABLE[49] = "1110001";
		TABLE[50] = "1110010";
		TABLE[51] = "1110011";
		TABLE[52] = "1110100";
		TABLE[53] = "1110101";
		TABLE[54] = "1110110";
		TABLE[55] = "1110111";
		TABLE[56] = "1111000";
		TABLE[57] = "1111001";
		//TABLE[58] = "1111100"; //:
		//TABLE[59] = "1111100"; // ;
		//TABLE[60] = "1111100"; //<
		//TABLE[61] = "1111100"; // =
		//TABLE[62] = "1111100"; //>
		TABLE[63] = "1100010";
		TABLE[64] = "1111010";
		TABLE[65] = "1100111";
		TABLE[66] = "1101000";
		TABLE[67] = "1000000";
		TABLE[68] = "1000001";
		TABLE[69] = "1000010";
		TABLE[70] = "1000011";
		TABLE[71] = "1101001";
		TABLE[72] = "1101010";
		TABLE[73] = "1000100";
		TABLE[74] = "1101011";
		TABLE[75] = "1101100";
		TABLE[76] = "1000101";
		TABLE[77] = "1000110";
		TABLE[78] = "100111";
		TABLE[79] = "1101101";
		TABLE[80] = "1101110";
		TABLE[81] = "10011000";
		TABLE[82] = "1000111";
		TABLE[83] = "1001000";
		TABLE[84] = "1001001";
		TABLE[85] = "1001010";
		TABLE[86] = "10011001";
		TABLE[87] = "1001011";
		TABLE[88] = "10011010";
		TABLE[89] = "1101111";
		TABLE[90] = "10011011";
		TABLE[91] = "10011011"; //[
		TABLE[92] = "10011011"; //\
		TABLE[93] = "10011011"; //]
		TABLE[94] = "10011011"; //
		TABLE[95] = "10011011"; //_
		TABLE[96] = "10011011"; //`
		TABLE[97] = "1010";
		TABLE[98] = "000100";
		TABLE[99] = "00101000";
		TABLE[100] = "00000";
		TABLE[101] = "00001";
		TABLE[102] = "0110001";
		TABLE[103] = "000101";
		TABLE[104] = "001011";
		TABLE[105] = "00011";
		TABLE[106] = "010100";
		TABLE[107] = "010101";
		TABLE[108] = "00100";
		TABLE[109] = "00110";
		TABLE[110] = "0111";
		TABLE[111] = "010110";
		TABLE[112] = "010111";
		TABLE[113] = "00101001";
		TABLE[114] = "00111";
		TABLE[115] = "01000";
		TABLE[116] = "01001";
		TABLE[117] = "01101";
		TABLE[118] = "00101010";
		TABLE[119] = "00101011";
		TABLE[120] = "01100000";
		TABLE[121] = "011001";
		TABLE[122] = "01100001"; //z
		//TABLE[123] = "0110000100"; //{
		//TABLE[124] = "0110000101"; //|
		//TABLE[125] = "0110000110"; // }
		//TABLE[126] = "0110000111"; // ~
		//TABLE[127] = "111111111111"; // a with komma
	}
	/**
	 * Get binary string huffman. Processing the printable ASCII characters with decimal between 32 to 127 GSM Character
	 * @param in The decimal value of character GSM
	 * @return The binary string compressed character 
	 */
	public String getEncode(byte in){
		String bin = "";
		//ASCII Printable only
		if(in >= 32 && in < 127){
			String out = TABLE[in];
			if(out != null)
				bin = out;
		}
		return bin;
	}
	/**
	 * Get the decimal value of binary character based Huffman table
	 * @param binary String The binary string (compressed)
	 * @param i The decimal value of character
	 * @return The GSM character
	 */
	public byte getDecode(String binary, byte i){
		byte character = 0;
		if(binary.equals(TABLE[i]))
			character = i;
		return character;
	}
}