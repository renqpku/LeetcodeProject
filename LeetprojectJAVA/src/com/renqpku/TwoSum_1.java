package com.renqpku;

/**
 *
Problem: Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

@author renqiang
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
	static int result[] = new int[2];
	public static int[] twoSum(int[] nums, int target) {
		int i,j, temp;
	        for( i =0; i < nums.length; i++) {
	        	temp = target - nums[i];
	        	for( j = i+1; j < nums.length; j++)
	        	{
	        		if ( temp == nums[j] ) {
	        			result[0] = i;
	        			result[1] = j;
	        			return result;
	        		}
	        	}
	        }
	    return null; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] testcases = {2,4,6,7,9};
		twoSum(testcases, 13);
		System.out.print(result[0] + ";" + result[1]);
	}
	
	//O(n) great accepted code.
	public int[] twoSum2(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i + 1;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i + 1);
	    }
	    return result;
	}

}
