package com.tyh.code;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int [] res = new Two_Sum().twoSum(nums, target);
		for(int i : res){
			System.out.println(i);
		}
	}
    public int[] twoSum(int[] nums, int target) {
        //invalid case
    	if(nums.length < 2){
    		return null;
    	}
    	//create result array
    	int[] res = new int[2];
    	//hash map <key=nums[index], value=index>
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i < nums.length; i++){
    		int rest = target - nums[i];
    		if(map.containsKey(rest)){
    			res[0] = map.get(rest) + 1;//not zero-based
    			res[1] = i + 1;
    			break;
    		}
    		else if(map.containsKey(nums[i])){
    			continue;
    		}
    		else{
    			map.put(nums[i], i);//put this value
    		}
    		
    	}
    	return res;
    }
}
