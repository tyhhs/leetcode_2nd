package com.tyh.code;

public class ZigZag_Conversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A";
		int numRows = 1;
		System.out.println(new ZigZag_Conversion().convert(s, numRows));
	}

    public String convert(String s, int numRows) {
    	if(s == null || s.length() < numRows || s.length() == numRows || numRows == 1){
    		return s;
    	}
    	StringBuilder res = new StringBuilder();
    	int length = s.length();
    	int index;
    	int gap;
    	int base = (numRows-1)*2;
    	for(int i = 0; i < numRows; i++){
    		//get row i+1
    		index = i;
    		if(i == 0 || i == numRows - 1){
    			gap = base;
    		}
    		else{
    			gap = (numRows-i-1)*2;
    		}
    		while(index < length){
    			res.append(s.charAt(index));
    			index += gap;
    			gap = gap == base ? base : base - gap;
    		}
    	}
    	return res.toString();
    }
}
