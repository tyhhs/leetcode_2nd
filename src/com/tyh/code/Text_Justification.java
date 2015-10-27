package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

public class Text_Justification {

	public static void main(String[] args) {
		String[] words = {"a","b","c","d","e"};
		List<String> res = new Text_Justification().fullJustify(words, 1);
		for(String s : res){
			System.out.println(s);
		}
	}

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        List<String> cur = new ArrayList<String>();
        int curLength = 0;
        int length = words.length;
        int i = 0;
        while(i < length){
        	if(curLength + words[i].length() > maxWidth){
        			addNewLine(res, cur, maxWidth);
        			cur = new ArrayList<String>();
        			curLength = 0;        			
        	}
        	else{
        		cur.add(words[i]);
        		curLength += (words[i].length() + 1);
        		i++;
        	}
        }
        if(!cur.isEmpty()){
        	addLastLine(res, cur, maxWidth);
        }
        return res;
    }
    
    public void addNewLine(List<String> res, List<String> cur, int maxWidth){
    	if(cur.size() == 1){
    		StringBuilder sb = new StringBuilder();
    		sb.append(cur.get(0));
    		sb.append(generateSpaceString(maxWidth - cur.get(0).length()));
    		res.add(sb.toString());
    	}
    	else{
    		int stringLength = 0;
        	for(String s : cur){
        		stringLength += s.length();
        	}
        	int numOfSpace = cur.size() - 1;
        	int sizeOfSpace = maxWidth - stringLength;
        	int base = sizeOfSpace / numOfSpace;
        	int offset = sizeOfSpace % numOfSpace;
        	StringBuilder sb = new StringBuilder();
        	for(int i = 0; i < cur.size()-1; i++){
        		sb.append(cur.get(i));
        		if(i < offset){
        			sb.append(generateSpaceString(base + 1));
        		}
        		else{
        			sb.append(generateSpaceString(base));
        		}
        	}
        	sb.append(cur.get(cur.size()-1));
        	res.add(sb.toString());
    	}    	
    }
    
    public void addLastLine(List<String> res, List<String> cur, int maxWidth){
    	int length = 0;
    	StringBuilder sb = new StringBuilder();
    	for(String s : cur){
    		sb.append(s);
    		length += s.length();
    		if(length < maxWidth){
    			sb.append(' ');
    			length++;
    		}
    	}
    	sb.append(generateSpaceString(maxWidth - length));
    	res.add(sb.toString());
    }
    
    public String generateSpaceString(int length){
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < length; i++){
    		sb.append(' ');
    	}
    	return sb.toString();
    }
}
