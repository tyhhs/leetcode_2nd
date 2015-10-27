package com.tyh.code;

import com.tyh.util.ArrayTools;

public class Set_Matrix_Zeroes {

	public static void main(String[] args) {
		int[] nums = 
			{1, 2, 3, 4,
			 2, 0, 4, 5,
			 3, 2, 0, 6,
			 4, 3, 2, 1};
		int[][] matrix = ArrayTools.createMatrix(nums, 4, 4);
		ArrayTools.printMatrix(matrix);
		new Set_Matrix_Zeroes().setZeroes(matrix);
		ArrayTools.printMatrix(matrix);
	}

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
    	//use first row and column to record if this column or row should be set as all zeros
        //because 0,0 is confused, so make it represents row0, and use an independent variable col0 representing column 0
        int col0 = 1;
        for(int i = 0; i < m; i++){
    		if(matrix[i][0] == 0){
    			col0 = 0;
    		}
        	for(int j = 1; j < n; j++){
    			if(matrix[i][j] == 0){
    				matrix[i][0] = 0;
    				matrix[0][j] = 0;
    			}
    		}
    	}
        //bottom up way
        for(int i = m - 1; i >= 0; i--){
        	for(int j = n - 1; j > 0; j--){
        		if(matrix[i][0] == 0 || matrix[0][j] == 0){
        			matrix[i][j] = 0;
        		}
        	}
        	if(col0 == 0){
        		matrix[i][0] = 0;
        	}
        }
    }
}
