package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

import com.tyh.util.ListTools;

public class N_Queens {

	public static void main(String[] args) {
		List<List<String>> lists = new N_Queens().solveNQueens(8);
		System.out.println(lists.size());
		ListTools.printStringListInList(lists);
	}

    public List<List<String>> solveNQueens(int n) {
    	int[] board = new int[n];
    	List<List<String>> lists = new ArrayList<List<String>>();
    	helper(board, 0, n, lists);
    	return lists;
    }
    public void helper(int[] board, int row, int n, List<List<String>> lists){
    	if(row < n){
    		for(int i = 0; i < n; i++){
    			board[row]=i;
    			if(isValid(board, row)){
    				helper(board, row + 1, n, lists);
    			}
    		}
    	}
    	else{//row==n means a valid combination
    		List<String> list = new ArrayList<String>();
    		for(int i = 0; i < n; i++){
    			StringBuilder sb = new StringBuilder();
    			for(int j = 0; j < n; j++){
    				if(board[i] == j){
    					sb.append("Q");
    				}
    				else{
    					sb.append(".");
    				}
    			}
    			list.add(sb.toString());
    		}
    		lists.add(list);
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
