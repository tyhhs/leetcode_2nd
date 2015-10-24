package com.tyh.util;

import java.util.List;

import com.tyh.structure.Interval;

public class IntervalTools {

	public static void printIntervals(List<Interval> intervals){
		for(Interval interval : intervals){
			System.out.print("["+interval.start+","+interval.end+"]");
		}
		System.out.println();
	}
}
