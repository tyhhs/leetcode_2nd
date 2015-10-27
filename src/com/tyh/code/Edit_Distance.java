package com.tyh.code;

public class Edit_Distance {

	public static void main(String[] args) {
		String word1 = "";
		String word2 = "efgh";
		System.out.println(new Edit_Distance().minDistance(word1, word2));
	}

    public int minDistance(String word1, String word2) {
    	int l1 = word1.length();
    	int l2 = word2.length();
    	int[][] distance = new int[l1+1][l2+1];
    	//distance[i][j] means the edit distance from word1.substring(0,i) to word2.subString(0, j)
    	for(int i = 0; i <= l2; i++){//word1 is a empty string
    		distance[0][i] = i;//word1 add i characters to reach word2 
    	}
    	for(int i = 0; i <= l1; i++){//word2 is a empty string
    		distance[i][0] = i;//word1 delete i characters to reach word2
    	}
    	//dynamic programming 
    	for(int i = 1; i <= l1; i++){
    		for(int j = 1; j <= l2; j++){
    			if(word1.charAt(i-1) == word2.charAt(j-1)){
    				distance[i][j] = distance[i-1][j-1];//same distance
    			}
    			else{
    				distance[i][j] = distance[i-1][j-1] + 1;//substitution
    			}
    			distance[i][j] = Math.min(distance[i][j], Math.min(distance[i-1][j] + 1, distance[i][j-1] + 1));
    			//choose minimum value from replace, delete, insert
    		}
    	}
    	return distance[l1][l2];
    }
}
