package com.tyh.code;

public class Trie {
	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
	class TrieNode {
		boolean end;
        TrieNode[] children;
	    // Initialize your data structure here.
	    public TrieNode() {
	    	end = false;
	        this.children = new TrieNode[26];
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("something");
		System.out.println(trie.search("something"));
		System.out.println(trie.search("somethin"));
		System.out.println(trie.startsWith("some"));
	}
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode parent = root;
        for(char c : word.toCharArray()){
        	if(parent.children[c - 'a'] == null){
        		parent.children[c - 'a'] = new TrieNode();
        	}
        	parent = parent.children[c - 'a'];
        }
        parent.end = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode parent = root;
        for(char c : word.toCharArray()){
        	if(parent.children[c - 'a'] == null){
        		return false;
        	}
        	parent = parent.children[c - 'a'];
        }
        return parent.end ? true : false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode parent = root;
        for(char c : prefix.toCharArray()){
        	if(parent.children[c - 'a'] == null){
        		return false;
        	}
        	parent = parent.children[c - 'a'];
        }
        return true;
    }
}
