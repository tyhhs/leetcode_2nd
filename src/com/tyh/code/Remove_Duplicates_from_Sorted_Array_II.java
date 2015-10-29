package com.tyh.code;

import com.tyh.util.ArrayTools;

public class Remove_Duplicates_from_Sorted_Array_II {

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5};
		System.out.println(new Remove_Duplicates_from_Sorted_Array_II().removeDuplicates(nums));
		ArrayTools.printIntArray(nums);
	}
	
	public int removeDuplicates(int[] nums) {
		if(nums.length < 3){
			return nums.length;
		}
		int insert = 1;
		int cur = 1;
		int count = 1;
		while(cur < nums.length){
			if(nums[cur] != nums[cur-1]){
				count = 1;
				nums[insert++] = nums[cur];
			}
			else{				
				if(++count <= 2){
					nums[insert++] = nums[cur];
				}
			}
			cur++;
		}
		return insert;
	}

	//general solution for remove duplicates from sorted array which can have at most k duplicates
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        int k=2;
    	if (n <= k) return n;
        int i = 1, j = 1;
        int cnt = 1;
        while (j < n) {
            if (nums[j] != nums[j-1]) {
                cnt = 1;
                nums[i++] = nums[j];
            }
            else {
                if (cnt < k) {
                	nums[i++] = nums[j];
                    cnt++;
                }
            }
            ++j;
        }
        return i;
    }
}
