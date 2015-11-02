package com.tyh.code;

import com.tyh.util.ArrayTools;

public class Merge_Sorted_Array {

	public static void main(String[] args) {
		int[] nums1 = {1,3,5,7,9,0,0,0,0,0,0,0,0};
		int[] nums2 = {2,4,6,8,10};
		new Merge_Sorted_Array().merge(nums1, 5, nums2, 5);
		ArrayTools.printIntArray(nums1);
	}

    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int index = m + n - 1;
    	m--;
    	n--;
    	while(m >= 0 && n >= 0){
    		if(nums1[m] >= nums2[n]){
    			nums1[index--] = nums1[m--];
    		}
    		else{
    			nums1[index--] = nums2[n--];
    		}
    	}
    	if(m >= 0){
    		while(m >= 0){
    			nums1[index--] = nums1[m--];
    		}
    	}
    	else{
    		while(n >= 0){
    			nums1[index--] = nums2[n--];
    		}
    	}
    }
}
