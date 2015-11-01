package com.tyh.code;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {

	public static void main(String[] args) {
		int[] height = {2,1,5,6,2,3};
		System.out.println(new Largest_Rectangle_in_Histogram().largestRectangleArea2(height));
	}

    public int largestRectangleArea(int[] height) {
        int length = height.length;
    	if(length == 0){
    		return 0;
    	}
    	Stack<Integer> stack = new Stack<Integer>();
    	int i = 0;
    	int max = 0;
    	while (i != length){
    		if(stack.isEmpty() || height[stack.peek()] <= height[i]){
    			stack.push(i);
    			i++;
    		}
    		else{
    			int temp = stack.pop();
    			int width = stack.empty() ? i : i - stack.peek() - 1;
    			max = Math.max(max, height[temp] * width);
    		}
    	}
    	
    	while(!stack.isEmpty()){
    		int temp = stack.pop();
    		int width = stack.isEmpty() ? length : length - stack.peek() - 1;
    		max = Math.max(max, height[temp] * width);
    	}
    	return max;
    }
    
    public int largestRectangleArea2(int[] height) {
        if (height==null) return 0;//Should throw exception
        if (height.length==0) return 0;

        Stack<Integer> index= new Stack<Integer>();
        index.push(-1);
        int max=0;

        for  (int i=0;i<height.length;i++){
                //Start calculate the max value
            while (index.peek()>-1)
                if (height[index.peek()]>height[i]){
                    int top=index.pop();                    
                    max=Math.max(max,height[top]*(i-1-index.peek()));  
                }else break;

            index.push(i);
        }
        while(index.peek()!=-1){
            int top=index.pop();
            max=Math.max(max,height[top]*(height.length-1-index.peek()));
        }        
        return max;
    }
}
