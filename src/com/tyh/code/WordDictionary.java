package com.tyh.code;

public class WordDictionary {
	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("a");
		wordDictionary.addWord("a");
		System.out.println(wordDictionary.search("."));
		System.out.println(wordDictionary.search("a"));
		System.out.println(wordDictionary.search("aa"));
		System.out.println(wordDictionary.search("a"));
		System.out.println(wordDictionary.search(".a"));
		System.out.println(wordDictionary.search("a."));
	}
	class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
    
    private TrieNode root;
    public WordDictionary(){
        this.root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode parent = root;
        for(char c : word.toCharArray()){
            if(parent.children[c - 'a'] == null){
                parent.children[c - 'a'] = new TrieNode();
            }
            parent = parent.children[c - 'a'];
        }
        parent.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(root, word);
    }
    private boolean searchHelper(TrieNode root, String word){
        TrieNode parent = root;
        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '.'){
                for(TrieNode node : parent.children){
                    if(node != null){
                        if(searchHelper(node, word.substring(i+1))){
                        	return true;
                        }
                    }
                }
                return false;
            }
            else if(parent.children[chars[i] - 'a'] == null){
                return false;
            }
            parent = parent.children[chars[i] - 'a'];
        }
        if(parent.isEnd) return true;
        return false;
    }
}
