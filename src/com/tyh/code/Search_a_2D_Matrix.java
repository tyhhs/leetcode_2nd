package com.tyh.code;

import com.tyh.util.ArrayTools;

public class Search_a_2D_Matrix {

	public static void main(String[] args) {
		//int[] nums = {1, 3, 5, 7, 10, 11, 16, 20, 23, 30, 34, 50};
		//int[][] matrix = ArrayTools.createMatrix(nums, 3, 4);
		int[] nums = {1};
		int[][] matrix = ArrayTools.createMatrix(nums, 1, 1);
		System.out.println(new Search_a_2D_Matrix().searchMatrix(matrix, 1));
	}

    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length == 0){
    		return false;
    	}
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int rowLow = 0, colLow = 0, rowHigh = m - 1, colHigh = n - 1;
    	while(rowLow <= rowHigh && colLow <= colHigh){
    		int rowMid = rowLow + (rowHigh - rowLow) / 2;
    		int colMid = colLow + (colHigh - colLow) / 2;
    		if(matrix[rowMid][colMid] == target){
    			return true;
    		}
    		else if(matrix[rowMid][colMid] < target){
    			if(colMid != n-1){
    				colLow++;
    			}
    			else{
    				colLow = 0;
    				rowLow++;
    			}
    		}
    		else{
    			if(colMid != 0){
    				colHigh--;
    			}
    			else{
    				colHigh = n-1;
    				rowHigh--;
    			}
    		}
    	}
    	return false;
    }
}
