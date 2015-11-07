package com.tyh.code;

import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) return 0;
        for(int i = triangle.size()-1; i > 0; i--){//from the second lower level to the top level
        	List<Integer> lowerLevel = triangle.get(i);
        	List<Integer> upperLevel = triangle.get(i-1);
        	for(int j = 0; j < upperLevel.size(); j++){
        		int curVal = upperLevel.get(j);
        		upperLevel.set(j, Math.min(lowerLevel.get(j),lowerLevel.get(j+1))+curVal);
        	}
        }
        return triangle.get(0).get(0);
    }
}
