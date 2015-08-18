package com.tyh.code;

public class Median_of_Two_Sorted_Arrays {


	public static void main(String[] args) {
		int A[] = { 1, 3, 5, 7, 9};
		int B[] = { 2, 4, 6, 8, 10};
		double median = new Median_of_Two_Sorted_Arrays().findMedianSortedArrays2(A, B);
		System.out.println(median);

	}
	//first method, O(n+m) complexity
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0){
        	return 0;
        }
        //new array to store sorted numbers from two arrays
        int size = nums1.length + nums2.length;
        int[] total = new int[size];
        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i < size; i++){
        	//two arrays all have numbers have not in the total array 
        	if(index1 < nums1.length && index2 < nums2.length){
        		if(nums1[index1] < nums2[index2]){
        			total[i] = nums1[index1];
        			index1++;
        		}
        		else{
        			total[i] = nums2[index2];
        			index2++;
        		}
        	}
        	//if only nums1 has numbers
        	else if(index1 < nums1.length){
        		total[i] = nums1[index1];
        		index1++;
        	}
        	// only nums2 has numbers
        	else{
        		total[i] = nums2[index2];
    			index2++;
        	}
        }
        return size % 2 == 0 ? (double)(total[size/2-1]+total[size/2])/2 : (double)total[(size-1)/2];
    }
    
    //method 2， find the kth minimum number of two sorted arrays, O(log m+n)
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
    	if(nums1.length == 0 && nums2.length == 0){
        	return 0;
        }
        int size = nums1.length + nums2.length;
        if(size%2 == 0){
        	return (findKth(nums1, 0, nums1.length, nums2, 0, nums2.length, size/2)+
        			findKth(nums1, 0, nums1.length, nums2, 0, nums2.length, size/2+1))/2.0;
        }
        else{
        	return findKth(nums1, 0, nums1.length, nums2, 0, nums2.length, size/2+1);
        }
    }
    
    int findKth(int[] A, int aStart, int aEnd, 
    			int[] B, int bStart, int bEnd, int k){
    	int m = aEnd - aStart;
    	int n = bEnd - bStart;
    	//always keep array A is shorter than array B(m<n)
    	if(m > n){
    		return findKth(B, bStart, bEnd, A, aStart, aEnd, k);
    	}
    	if(m == 0){//A is empty array
    		return B[bStart+k-1];
    	}
    	if(k == 1){//k is the minimum of two
    		return Math.min(A[aStart], B[bStart]);
    	}
    	//divide arrays
    	int aPart = Math.min(k/2, m);
    	int bPart = k - aPart;
    	int a = A[aStart + aPart -1];
    	int b = B[bStart + bPart -1];
    	if(a < b){//drop A[aStart]--A[aStart+aPart]
    		return findKth(A, aStart+aPart, aEnd, B, bStart, bEnd, k - aPart);
    	}
    	else if(a > b){
    		return findKth(A, aStart, aEnd, B, bStart+bPart, bEnd, k - bPart);
    	}
    	else{//a==b, find kth
    		return a;
    	}
    } 
}
