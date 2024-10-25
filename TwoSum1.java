package com.first;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			int comp = target-nums[i];
			if(map.containsKey(comp)) {
				return new int[] {map.get(comp),i};
			}
			map.put(nums[i], i);
		}
		return new int[] {0,0};
	}
public static void main(String[] args) {
	int []nums = {3,2,4};
	int target = 6;
	TwoSum1 s = new TwoSum1();
	int a[] = s.twoSum(nums, target);
	System.out.println(a[0]+"->"+a[1]);
	
}
}
