package com.tyh.code;

public class Trapping_Rain_Water {

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new Trapping_Rain_Water().trap(height));
	}
	
    public int trap(int[] height) {
        int length = height.length - 1;
    	int l = 0;
        int r = height.length - 1;
        //found the left and right edges
        while(l < length && height[l] <= height[l+1]){
        	l++;
        }
        while(r > l && height[r] <= height[r-1]){
        	r--;
        }
        int volume = 0;
        while(l < r){
        	if(height[l] < height[r]){
        		int leftHeight = height[l];
        		while(leftHeight > height[++l]){
        			volume += (leftHeight - height[l]);
        		}
        	}
        	else{
        		int rightHeight = height[r];
        		while(rightHeight > height[--r]){
        			volume += (rightHeight - height[r]);
        		}
        	}
        }
        return volume;
    }

}
