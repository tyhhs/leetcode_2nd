package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

import com.tyh.structure.Interval;
import com.tyh.util.IntervalTools;

public class Insert_Interval {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		IntervalTools.printIntervals(intervals);
		Interval newInterval = new Interval(4, 9);
		List<Interval> res = new Insert_Interval().insert(intervals, newInterval);
		IntervalTools.printIntervals(res);
	}

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	int i = 0;
    	while(i < intervals.size() && intervals.get(i).end < newInterval.start){
    		i++;
    	}
    	while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
    		newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
    				Math.max(intervals.get(i).end, newInterval.end));
    		intervals.remove(i);
    	}
    	intervals.add(i, newInterval);
    	return intervals;
    }
}
