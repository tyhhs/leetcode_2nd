package com.tyh.code;

import org.omg.CORBA.IntHolder;

public class N_Queens_II {

	public static void main(String[] args) {
		System.out.println(new N_Queens_II().totalNQueens(8));

	}

    public int totalNQueens(int n) {
        IntHolder res = new IntHolder(0);
        int[] board = new int[n];
        helper(board, res, 0, n);
        return res.value;
    }
    
    public void helper(int[] board, IntHolder res, int row, int n){
    	if(row < n){
    		for(int i = 0; i < n; i++){
    			board[row] = i;
    			if(isValid(board, row)){
    				helper(board, res, row+1, n);
    			}
    		}
    	}
    	else{
    		res.value++;
    	}
    }
    
    public boolean isValid(int[] board, int row){
    	for(int i = 0; i < row; i++){
    		if(board[i] == board[row] || Math.abs(board[i] - board[row]) == (row - i)){
    			return false;
    		}
    	}
    	return true;
    }
}
