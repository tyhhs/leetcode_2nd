package com.tyh.code;

public class Remove_Element {

	public static void main(String[] args) {
		int nums[] = {1,3,2,3,4,5,5};
		System.out.println(new Remove_Element().removeElement(nums, 3));
	}

    public int removeElement(int[] nums, int val) {
        int curr = 0;
        int next = 0;
        int count = 0;
        while(curr < nums.length){
        	while(curr < nums.length && nums[curr] != val){
        		curr++;
        		count++;
        	}
        	//curr is the place we want to replace
        	if (curr == nums.length) {
				return count;
			}
        	next = curr;
        	while(next < nums.length && nums[next] == val){
        		next++;
        	}
        	if (next != nums.length) {
				//swap curr and next
        		nums[curr] ^= nums[next];
        		nums[next] ^= nums[curr];
        		nums[curr] ^= nums[next];
        		count++;
        		curr++;
			}
        	else{
        		return count;
        	}
        }
        return count;
    }
}
