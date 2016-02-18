package com.tyh.code;

public class Dungeon_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int res = Math.max(1, 1 - dungeon[rows-1][cols-1]);
        dungeon[rows-1][cols-1] = res;
        for(int i = rows-2; i >= 0; i--){
            dungeon[i][cols-1] = Math.max(1, dungeon[i+1][cols-1]-dungeon[i][cols-1]);
        }
        for(int i = cols-2; i>= 0; i--){
            dungeon[rows-1][i] = Math.max(1, dungeon[rows-1][i+1]-dungeon[rows-1][i]);
        }
        for(int i = rows-2; i >= 0; i--){
            for(int j = cols-2; j >= 0; j--){
                dungeon[i][j] = Math.max(1, Math.min(dungeon[i+1][j],dungeon[i][j+1]) - dungeon[i][j]);
            }
        }
        return dungeon[0][0];
    }
}
