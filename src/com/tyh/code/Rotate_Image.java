package com.tyh.code;

import com.tyh.util.ArrayTools;

public class Rotate_Image {

	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		new Rotate_Image().rotate(matrix);
		ArrayTools.printMatrix(matrix);
	}

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int y = 0; y < n/2; y++){
        	for(int x = y; x < (n - y - 1); x++){
        		int temp = matrix[y][x];
        		temp = move(matrix, temp, x, n - y - 1);
        		temp = move(matrix, temp, n - y - 1, n - x - 1);
        		temp = move(matrix, temp, n - x -1, y);
        		temp = move(matrix, temp, y, x);
        	}
        }
    }
    //move temp to the target position, return a value of this position
    public int move(int[][] matrix, int temp, int y, int x){
    	int val = matrix[y][x];
    	matrix[y][x] = temp;
    	return val;
    }
}
