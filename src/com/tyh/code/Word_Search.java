package com.tyh.code;

public class Word_Search {

	public static void main(String[] args) {
		char[][] board={
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		System.out.println(new Word_Search().exist(board, "ABCESCFSADEW"));
	}

    public boolean exist(char[][] board, String word) {
    	char[] chars = word.toCharArray();
    	int m = board.length;
    	int n = board[0].length;
    	// find the first char to start search	
    	for(int i = 0; i < m; i++){
    		for(int j = 0; j < n; j++){
    			if(board[i][j] == chars[0]){
    				board[i][j] = '*';
    				if(search(board, chars, 1, i, j)){
    					return true;
    				}
    				board[i][j]	= chars[0];
    			}
    		}
    	}
    	return false;
    }
    
    public boolean search(char[][] board, char[] chars, int index, int row, int col){
    	//found
    	if(index == chars.length){
    		return true;
    	}
    	//up
    	if(row - 1 >= 0 && board[row-1][col] == chars[index]){
    		board[row-1][col] = '*';
    		if(search(board, chars, index+1, row-1, col)){
    			return true;
    		}
    		board[row-1][col] = chars[index];
    	}
    	//down
    	if(row + 1 < board.length && board[row+1][col] == chars[index]){
    		board[row+1][col] = '*';
    		if(search(board, chars, index+1, row+1, col)){
    			return true;
    		}
    		board[row+1][col] = chars[index];
    	}
    	//left
    	if(col - 1 >= 0 && board[row][col-1] == chars[index]){
    		board[row][col-1] = '*';
    		if(search(board, chars, index+1, row, col-1)){
    			return true;
    		}
    		board[row][col-1] = chars[index];
    	}
    	//down
    	if(col + 1 < board[0].length && board[row][col+1] == chars[index]){
    		board[row][col+1] = '*';
    		if(search(board, chars, index+1, row, col+1)){
    			return true;
    		}
    		board[row][col+1] = chars[index];
    	}
    	
    	return false;
    }
}
