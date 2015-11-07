package com.tyh.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tyh.util.ListTools;

public class Pascals_Triangle {

	public static void main(String[] args) {
		List<List<Integer>> lists = new Pascals_Triangle().generate(5);
		ListTools.printListInList(lists);
	}

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	if(numRows < 1) return lists;
    	List<Integer> level1 = new ArrayList<Integer>(Arrays.asList(1));
    	lists.add(level1);
        for(int i = 1; i < numRows; i++){//level i+1
        	List<Integer> level = new ArrayList<Integer>();
        	level.add(1);//first node of this level
        	List upperLevel = lists.get(i-1);//get the upper level
        	for(int j = 1; j < i; j++){//build the level
        		level.add((int)upperLevel.get(j-1) + (int)upperLevel.get(j));
        	}
        	level.add(1);//last member of the level
        	lists.add(level);//insert new level
        }
        return lists;
    }
}
