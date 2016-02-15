package com.tyh.code;

public class Maximum_Gap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,1,1,1};
		System.out.println(new Maximum_Gap().maximumGap(num));
	}

	public int maximumGap(int[] num) {
    	if(num.length<2){
    		return 0;
    	}
        int max=num[0];
        int min=num[0];
        for(int i:num){
        	max=max>i?max:i;
        	min=min<i?min:i;
        }
        if(num.length==2){
        	return max-min;
        }
        //the range of bucket
        int range=(int) Math.ceil((0.0+max-min)/(num.length-1));
        if(range == 0) return 0;
        //number of buckets
        int numOfBuckets=(max-min)/range+1;
        //create two arrays of buckets to hold max and min of each bucket
        int[] maxBuckets=new int[numOfBuckets];
        int[] minBuckets=new int[numOfBuckets];
        for(int i:num){
        	int indexOfBucket=(i-min)/range;
        	if(maxBuckets[indexOfBucket]==0&&minBuckets[indexOfBucket]==0){
        		maxBuckets[indexOfBucket]=i;
        		minBuckets[indexOfBucket]=i;
        	}
        	else{
        		if(i<minBuckets[indexOfBucket]){
        			minBuckets[indexOfBucket]=i;
        		}
        		if(i>maxBuckets[indexOfBucket]){
        			maxBuckets[indexOfBucket]=i;
        		}
        	}
        }
        int pre=0;
        int gap=0;
        for(int i=0;i<minBuckets.length;i++){
        	if(minBuckets[i]==0){
        		continue;
        	}
        	gap=Math.max(gap,minBuckets[i]-maxBuckets[pre]);
        	pre=i;
        }
        return gap;
    }
}
