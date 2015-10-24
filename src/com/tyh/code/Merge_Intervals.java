package com.tyh.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.tyh.structure.Interval;
import com.tyh.util.IntervalTools;

public class Merge_Intervals {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		IntervalTools.printIntervals(intervals);
		List<Interval> res = new Merge_Intervals().merge(intervals);
		IntervalTools.printIntervals(res);
	}

    public List<Interval> merge(List<Interval> intervals) {
    	if(intervals.size() <= 1){
    		return intervals;
    	}
    	Comparator comparator = new Comparator<Interval>(){
					public int compare(Interval i1, Interval i2) {
						return Integer.compare(i1.start, i2.start);
					}};
		Collections.sort(intervals, comparator);			
    	List<Interval> res = new ArrayList<Interval>();
    	int start = intervals.get(0).start;
    	int end = intervals.get(0).end;
    	for(int i = 1; i < intervals.size(); i++){
    		Interval temp = intervals.get(i);
    		if(end >= temp.start){
    			end = Math.max(end, temp.end);
    		}
    		else{
    			res.add(new Interval(start, end));
    			start = temp.start;
    			end = temp.end;
    		}
    	}
    	res.add(new Interval(start, end));
    	return res;
    }
}
