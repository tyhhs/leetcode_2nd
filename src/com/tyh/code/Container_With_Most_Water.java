package com.tyh.code;

public class Container_With_Most_Water {

	public static void main(String[] args) {
		int height[] = {1, 1};
		System.out.println(new Container_With_Most_Water().maxArea(height));
	}
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int max = 0;
        int h = 0;
        while(left < right){
        	h = Math.min(height[left], height[right]);
        	max = Math.max(max, h * (right - left));
        	if (height[left] < height[right]) {
				left ++;
			}
        	else {
				right --;
			}
        }
        return max;
    }
}
