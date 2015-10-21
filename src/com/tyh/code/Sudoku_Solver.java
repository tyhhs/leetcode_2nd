package com.tyh.code;

import java.util.HashSet;
import java.util.Set;

public class Sudoku_Solver {

	public static void main(String[] args) {
		char[][] board={
				{'.','.','.','2','.','.','.','6','3'},
				{'3','.','.','.','.','5','4','.','1'},
				{'.','.','1','.','.','3','9','8','.'},
				{'.','.','.','.','.','.','.','9','.'},
				{'.','.','.','5','3','8','.','.','.'},
				{'.','3','.','.','.','.','.','.','.'},
				{'.','2','6','3','.','.','5',',','.'},
				{'5','.','3','7','.','.','.','.','8'},
				{'4','7','.','.','.','1','.','.','.'}};
		new Sudoku_Solver().solveSudoku(board);
		for(char[] i:board){
			System.out.print("{");
			for(int j = 0; j < i.length; j++){
				if(j != i.length - 1){
					System.out.print("'"+i[j]+"',");
				}
				else{
					System.out.print("'"+i[j]+"'");
				}
			}
			System.out.print("},");
			System.out.println();
}
	}

    public void solveSudoku(char[][] board) {
    	if(board==null||board.length!=9||board[0].length!=9){
        	return;
        }
    	helper(board, 0, 0);
    }
    
    public boolean helper(char[][] board, int row, int col){
    	if (col == 9) {
			return helper(board, row + 1, 0);
		}
    	if (row == 9) {
			return true;
		}
    	if (board[row][col] == '.') {
			for (int i = 1; i < 10; i++) {
				board[row][col] = (char)(i + '0');
				if(checkBoard(board, row, col)){
					if(helper(board, row, col+1)){
						return true;
					}
				}
				board[row][col] = '.';
			}
		}
    	else{
    		return helper(board, row, col + 1);
    	}
    	return false;
    }
    
    public boolean checkBoard(char[][] board, int row, int col) {
    	Set<Character> checkRow = new HashSet<Character>();
    	Set checkCol = new HashSet<Character>();
    	Set checkSub = new HashSet<Character>();
    	//check row    	
    	for(int i = 0; i < board.length; i++){
    		int subRow=3*(row/3)+i/3;
    		int subCol=3*(col/3)+i%3;
    		if ((board[row][i] != '.' && !checkRow.add(board[row][i])) 
    				||(board[i][col] != '.' && !checkCol.add(board[i][col]))
    				||(board[subRow][subCol] != '.' && !checkSub.add(board[subRow][subCol]))){
				return false;
			}
    	}
    	return true;
	}
}
