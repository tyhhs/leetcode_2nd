package com.tyh.code;

import com.tyh.util.ArrayTools;

public class Minimum_Path_Sum {

	public static void main(String[] args) {
		int[] nums = {1,2,5,3,2,1};
		int[][] grid = ArrayTools.createMatrix(nums, 2, 3);
		System.out.println(new Minimum_Path_Sum().minPathSum(grid));
	}

    public int minPathSum(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
    	for(int i = 1; i < n; i++){
    		grid[0][i] +=grid[0][i-1];
    	}
    	for(int i = 1; i < m; i++){
    		grid[i][0] += grid[i-1][0];
    	}
    	
    	for(int i = 1; i < m; i++){
    		for(int j = 1; j < n; j++){
    			grid[i][j] += grid[i-1][j] < grid[i][j-1] ? grid[i-1][j] : grid[i][j-1];
    		}
    	}
    	return grid[m-1][n-1];
    }
}
