package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

import com.tyh.util.ListTools;

public class Gray_Code {

	public static void main(String[] args) {
		List<Integer> list = new Gray_Code().grayCode(3);
		ListTools.printIntList(list);
	}

    public List<Integer> grayCode(int n) {
    	List<Integer> list = new ArrayList<Integer>();
    	if(n == 0){
    		list.add(0);
    		return list;
    	}
    	List<Integer> temp = grayCode(n - 1);
    	list.addAll(temp);
    	int addNum = 1<<(n-1);
    	for(int i = list.size()-1; i >= 0; i--){
    		int num = list.get(i) + addNum;
    		list.add(num);
    	}
    	return list;
    }
}
