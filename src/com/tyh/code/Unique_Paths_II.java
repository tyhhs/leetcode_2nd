package com.tyh.code;

import com.tyh.util.ArrayTools;

public class Unique_Paths_II {

	public static void main(String[] args) {
		int[] nums = {0,0,1,0,1,0,0,0,0};
		int[][] matrix = ArrayTools.createMatrix(nums, 3, 3);
		System.out.println(new Unique_Paths_II().uniquePathsWithObstacles(matrix));
	}

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	if(obstacleGrid[0][0] != 1){
        	for(int i = 0; i < n; i++){
        		if(obstacleGrid[0][i] == 1){
        			for(int j = i; j < n; j++){
        				obstacleGrid[0][j] = 0;
        			}
        			break;
        		}
        		obstacleGrid[0][i] = 1;
        	}
        	for(int i = 1; i < m; i++){
        		if(obstacleGrid[i][0] == 1){
        			for(int j = i; j < m; j++){
        				obstacleGrid[j][0] = 0;
        			}
        			break;
        		}
        		obstacleGrid[i][0] = 1;
        	}
    	}
    	else{
    		return 0;
    	}
    	for(int i = 1; i < m; i++){
    		for(int j = 1; j < n; j++){
    			if(obstacleGrid[i][j] ==1){
    				obstacleGrid[i][j] = 0;
    			}
    			else{
    				obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
    			}
    		}
    	}
    	return obstacleGrid[m-1][n-1];
    }
}
