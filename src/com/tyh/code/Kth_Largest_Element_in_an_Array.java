package com.tyh.code;

import java.util.Arrays;

public class Kth_Largest_Element_in_an_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findKthLargest(int[] a, int k) {
	    int n = a.length;
	    int p = quickSelect(a, 0, n - 1, n - k + 1);
	    return a[p];
	  }

	  // return the index of the kth smallest number
	  int quickSelect(int[] a, int lo, int hi, int k) {
	    // use quick sort's idea
	    // put nums that are <= pivot to the left
	    // put nums that are  > pivot to the right
	    int i = lo, j = hi, pivot = a[hi];
	    while (i < j) {
	      if (a[i++] > pivot) swap(a, --i, --j);
	    }
	    swap(a, i, hi);

	    // count the nums that are <= pivot from lo
	    int m = i - lo + 1;

	    // pivot is the one!
	    if (m == k)     return i;
	    // pivot is too big, so it must be on the left
	    else if (m > k) return quickSelect(a, lo, i - 1, k);
	    // pivot is too small, so it must be on the right
	    else            return quickSelect(a, i + 1, hi, k - m);
	  }

	  void swap(int[] a, int i, int j) {
	    int tmp = a[i];
	    a[i] = a[j];
	    a[j] = tmp;
	  }
	  
	//easiest solution
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
