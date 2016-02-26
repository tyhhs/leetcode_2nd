package com.tyh.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Word_Search_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words) trie.insert(word);
        HashSet<String> res = new HashSet<String>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(trie.startsWith(board[i][j]+"")) {
                    String cur = board[i][j]+"";
                    board[i][j] ^= 256;
                    dfs(trie, res, board, i, j, cur);
                    board[i][j] ^= 256;
                }
            }
        }
        return new LinkedList<String>(res);
    }

    int[][] diff = new int[][]{{0,1,0,-1},{1,0,-1,0}};
    public void dfs(Trie trie, HashSet<String> res, char[][] board, int i, int j, String cur) {
        if(trie.search(cur)) res.add(cur);
        for(int x = 0; x < diff[0].length; x++) {
            int newR = i + diff[0][x];
            int newC = j + diff[1][x];
            if(newR < 0 || newR >= board.length || newC < 0 || newC >= board[0].length 
               || board[newR][newC] < 'a' || board[newR][newC] > 'z' || !trie.startsWith(cur + board[newR][newC]))
               continue;
            String newCur = cur + board[newR][newC];
            board[newR][newC] ^= 256;
            dfs(trie, res, board, newR, newC, newCur);
            board[newR][newC] ^= 256;
        }
    }

    class TrieNode {
        TrieNode[] branch;
        boolean isWord;
        // Initialize your data structure here.
        public TrieNode() {
             branch = new TrieNode[26];
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(cur.branch[c-'a'] == null) cur.branch[c-'a'] = new TrieNode();
                cur = cur.branch[c-'a'];
            }
            cur.isWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(cur.branch[c-'a'] == null) return false;
                cur = cur.branch[c-'a'];
            }
            return cur.isWord == true;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for(int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if(cur.branch[c-'a'] == null) return false;
                cur = cur.branch[c-'a'];
            }
            return true;
        }
    }
}
