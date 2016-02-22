package com.tyh.code;

public class Number_of_Islands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    //DFS the new island
                    DFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    //DFS a island and all 1s in this island to 0
    private void DFS(char[][] grid, int row, int col){
        //several coner cases make the function exit
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1') return;
        //else change the value to '0'
        grid[row][col] = '0';
        //DFS the island recursively
        DFS(grid, row + 1, col);
        DFS(grid, row, col + 1);
        DFS(grid, row - 1, col);
        DFS(grid, row, col - 1);
    }
}
