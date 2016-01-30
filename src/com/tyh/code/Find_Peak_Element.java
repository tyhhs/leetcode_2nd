package com.tyh.code;

public class Find_Peak_Element {

	public static void main(String[] args) {
		int[] nums = {1,3,2,1};
		System.out.println(new Find_Peak_Element().findPeakElement(nums));

	}
	//binary search method
	public int findPeakElement(int[] nums) {		
		int len = nums.length;
		//boundary conditions
		if(len == 1) return 0;
    	if(nums[0] > nums[1]) return 0;
    	if(nums[len-1] > nums[len-2]) return len-1;
    	//binary search
    	int left = 1;
		int right = len - 1;
    	while(left < right){
    		int mid = left + (right - left) / 2;
    		if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
    			return mid;
    		}
    		else if(nums[mid] < nums[mid+1]){
    			left = mid + 1;
    		}
    		else{
    			right = mid - 1;
    		}
    	}
    	return left;
	}
	
	//straightforward method O(n) complexity 
    public int findPeakElement2(int[] nums) {
    	if(nums.length == 1) return 0;
    	if(nums[0] > nums[1]) return 0;
    	int pre = nums[0];
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i] > pre && nums[i] > nums[i+1]){
                return i;
            }
            pre = nums[i];
        }
        if(nums[nums.length-1] > pre) return nums.length-1;
        return -1;
    }
}
