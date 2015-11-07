package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_II {

	public static void main(String[] args) {
		List<Integer> list = new Pascals_Triangle_II().getRow(5);

	}

    public List<Integer> getRow(int rowIndex) {
    	List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0)
            return list;

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}
