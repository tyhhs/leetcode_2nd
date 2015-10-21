package com.tyh.code;

import java.util.HashSet;
import java.util.Set;


public class Valid_Sudoku {

	public static void main(String[] args) {
		char[][] board={
				{'8','4','5','2','1','9','7','6','3'},
				{'3','8','9','6','7','5','4','2','1'},
				{'7','6','1','4','2','3','9','8','5'},
				{'2','5','8','1','4','7','3','9','6'},
				{'6','9','4','5','3','8','1','7','2'},
				{'1','3','7','9','6','2','8','5','4'},
				{'9','2','6','3','8','4','5',',','7'},
				{'5','1','3','7','9','6','2','4','8'},
				{'4','7','2','8','5','1','6','3','9'}};
		System.out.println(new Valid_Sudoku().isValidSudoku(board));

	}

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
        	Set<Character> checkRow = new HashSet<Character>();
        	Set<Character> checkCol = new HashSet<Character>();
        	Set<Character> checkSubBoard = new HashSet<Character>();
        	for(int j = 0; j < board[0].length; j++){
        			int subRow=3*(i/3)+j/3;
            		int subCol=3*(i%3)+j%3;
        			if ((board[i][j] != '.' && !checkRow.add(board[i][j]))
        					|| (board[j][i] != '.' && !checkCol.add(board[j][i]))
        					|| (board[subRow][subCol] != '.' && !checkSubBoard.add(board[subRow][subCol])))  {
						return false;
					}
        	}
        }
        return true;
    }
}
