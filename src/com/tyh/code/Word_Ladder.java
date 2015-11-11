package com.tyh.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder {
	int min;
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> wordList = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
		System.out.println(new Word_Ladder().ladderLength(beginWord, endWord, wordList));
	}
	
	public int ladderLength(String start, String end, Set<String> dict) {
		  // Use queue to help BFS
		  Queue<String> queue = new LinkedList<String>();
		  queue.add(start);
		  queue.add(null);

		  // Mark visited word
		  Set<String> visited = new HashSet<String>();
		  visited.add(start);

		  int level = 1;

		  while (!queue.isEmpty()) {
		    String str = queue.poll();

		    if (str != null) {
		      // Modify str's each character (so word distance is 1)
		      for (int i = 0; i < str.length(); i++) {
		        char[] chars = str.toCharArray();

		        for (char c = 'a'; c <= 'z'; c++) {
		          chars[i] = c;

		          String word = new String(chars);

		          // Found the end word
		          if (word.equals(end)) return level + 1;

		          // Put it to the queue
		          if (dict.contains(word) && !visited.contains(word)) {
		            queue.add(word);
		            visited.add(word);
		          }
		        }
		      }
		    } else {
		      level++;

		      if (!queue.isEmpty()) { 
		        queue.add(null);
		      }
		    }
		  }

		  return 0;
		}
}
