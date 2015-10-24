package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

import com.tyh.util.ArrayTools;

public class Spiral_Matrix {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9};
		int[][] matrix = ArrayTools.createMatrix(nums, 3, 3);
		List<Integer> list = new Spiral_Matrix().spiralOrder(matrix);
		for(int i : list){
			System.out.println(i);
		}
	}

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
    	if(matrix.length == 0){
        	return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int xUp = 0;
        int xDown = m -1;
        int yLeft = 0;
        int yRight = n - 1;
    	while(yLeft <= yRight){
    		for(int i = yLeft; i <= yRight; i++){
    			list.add(matrix[xUp][i]);
    		}
    		if(++xUp > xDown) break;
    		for(int i = xUp; i<= xDown; i++){
    			list.add(matrix[i][yRight]);
    		}
    		if(--yRight < yLeft) break;
    		for(int i = yRight; i >= yLeft; i--){
    			list.add(matrix[xDown][i]);
    		}
    		if(--xDown < xUp) break;
    		for(int i = xDown; i >= xUp; i--){
    			list.add(matrix[i][yLeft]);
    		}
    		yLeft++;
    	}
    	return list;
    }
}
