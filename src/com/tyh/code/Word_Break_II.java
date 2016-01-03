package com.tyh.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.tyh.util.ListTools;

public class Word_Break_II {

	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
		List<String> list = new Word_Break_II().wordBreak1(s, wordDict);
		ListTools.printStringList(list);
	}
	
    public List<String> wordBreak1(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        for(int j = s.length() - 1; j >= 0; j--){
            if(dict.contains(s.substring(j)))
                break;
            else{
                if(j == 0)
                    return result;
            }
        }
        for(int i = 0; i < s.length()-1; i++)
        {
            if(dict.contains(s.substring(0,i+1)))
            {
                List<String> strs = wordBreak(s.substring(i+1,s.length()),dict);
                if(strs.size() != 0)
                    for(Iterator<String> it = strs.iterator();it.hasNext();)
                    {
                        result.add(s.substring(0,i+1)+" "+it.next());
                    }
            }
        }
        if(dict.contains(s)) result.add(s);
        return result;
    }
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> list = new ArrayList<String>();
        for(int j = s.length() - 1; j >= 0; j--){
            if(wordDict.contains(s.substring(j)))
                break;
            else{
                if(j == 0)
                    return list;
            }
        }
        if(s.length() == 0 || wordDict.isEmpty()) return list;
        helper(s, wordDict, list, new StringBuilder());
        return list;
    }
    
    private void helper(String s, Set<String> wordDict, List<String> list, StringBuilder sentence){
    	if(s.length() == 0 && sentence.length() != 0){
    		list.add(sentence.toString());
    	}
    	for(int i = 1; i <= s.length(); i++){
    		if(wordDict.contains(s.substring(0, i))){
    			StringBuilder newSentence = new StringBuilder(sentence);
    			if(newSentence.length() != 0)
    				newSentence.append(" ").append(s.substring(0, i));
    			else
    				newSentence.append(s.substring(0, i));
    			helper(s.substring(i), wordDict, list, newSentence);
    		}
    	}
    }
}
