package com.tyh.code;

import com.tyh.util.ArrayTools;

public class Spiral_Matrix_II {

	public static void main(String[] args) {
		int[][] matrix = new Spiral_Matrix_II().generateMatrix(3);
		ArrayTools.printMatrix(matrix);
	}

    public int[][] generateMatrix(int n) {
    	int[][] matrix = new int[n][n];
    	int rowUp = 0;
    	int rowDown = n - 1;
    	int colLeft = 0;
    	int colRight = n - 1;
    	int num = 0;
    	int max = n * n;
    	while(true){
    		for(int i = colLeft; i <= colRight; i++){
    			num++;
    			matrix[rowUp][i] = num;
    		}
    		rowUp++;
    		if(num == max) break;
    		
    		for(int i = rowUp; i <= rowDown; i ++){
    			num++;
    			matrix[i][colRight] = num;
    		}
    		colRight--;
    		if(num == max) break;
    		
    		for(int i = colRight; i >= colLeft; i --){
    			num++;
    			matrix[rowDown][i] = num;
    		}
    		rowDown--;
    		if(num == max) break;
    		
    		for(int i = rowDown; i >= rowUp; i--){
    			num++;
    			matrix[i][colLeft] = num;
    		}
    		colLeft++;
    		if(num == max) break;
    	}
    	return matrix;
    }

}
