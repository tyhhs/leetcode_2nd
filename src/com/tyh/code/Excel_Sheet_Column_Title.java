package com.tyh.code;

public class Excel_Sheet_Column_Title {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Excel_Sheet_Column_Title().convertToTitle(0));
	}
	
    public String convertToTitle(int n) {
    	StringBuilder res = new StringBuilder();
        while(n != 0){
            --n;
            res.insert(0, (char)('A' + n % 26));
            n = n / 26;
        }
        return res.toString();
    }
}
