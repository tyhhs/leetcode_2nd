package com.tyh.code;

public class Gas_Station {

	public static void main(String[] args) {
		int[] gas= {2,4};
		int[] cost = {3,4};
		System.out.println(new Gas_Station().canCompleteCircuit2(gas, cost));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len=gas.length;
		int[] remainder=new int[len];
		for (int i = 0; i <len; i++) {
			remainder[i]=gas[i]-cost[i];
		}
		
		//if the car cant from i to k, it also cant from any point from i+1 to k-1 to k, so we start again from k
		//Simulate a cycle by an array, such as: 0,1,2...n-1,0,1,2....n-2 total 2n-1 elements.
		int sum=0;
		int start=0;
		for(int i=0;i<2*len-1;i++){
			sum+=remainder[i%len];
			if(sum<0){
				start=i+1;
				if(start>len-1){
					return -1;
				}
				sum=0;
			}		
		}
		return start;
	}
	
	//time limit exceeded
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int num = gas.length;
    	for(int i = 0; i < num; i++){//for each gas station as the start point
        	int rest = 0;
        	for(int j = i; j < i + num; j++){
        		rest += (gas[j%num] - cost[j%num]);
        		if(rest < 0) break;
        	}
        	if(rest >= 0) return i;
        }
    	return -1;
    }
}
