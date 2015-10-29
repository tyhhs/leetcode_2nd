package com.tyh.util;

public class ArrayTools {
	
	public static void printMatrix(int[][] matrix){
		for(int[] row : matrix){
			System.out.print("[");
			for(int ele : row){
				System.out.print(ele + " ");
			}
			System.out.println("]");
		}
	}
	
	public static void printMatrix(char[][] matrix){
		for(char[] row : matrix){
			System.out.print("[");
			for(char ele : row){
				System.out.print(ele + " ");
			}
			System.out.println("]");
		}
	}
	
	public static int[][] createMatrix(int[] nums, int m, int n){
		int[][] matrix = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = nums[i*n+j];
			}
		}
		return matrix;
	}
	
	public static void printIntArray(int[] nums){
		System.out.print("[");
		for(int i : nums){
			System.out.print(i + " ");
		}
		System.out.print("]");
	}
}
