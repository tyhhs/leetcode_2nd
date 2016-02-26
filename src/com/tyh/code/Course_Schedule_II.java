package com.tyh.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Course_Schedule_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) adj.add(i, new ArrayList<Integer>());
        for (int i = 0; i < prerequisites.length; i++) adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!topologicalSort(adj, i, stack, visited, new boolean[numCourses])) return new int[0];
        }
        int i = 0;
        int[] result = new int[numCourses];
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    private boolean topologicalSort(List<List<Integer>> adj, int v, Stack<Integer> stack, boolean[] visited, boolean[] isLoop) {
        if (visited[v]) return true;
        if (isLoop[v]) return false;
        isLoop[v] = true;
        for (Integer u : adj.get(v)) {
            if (!topologicalSort(adj, u, stack, visited, isLoop)) return false;
        }
        visited[v] = true;
        stack.push(v);
        return true;
    }
}
