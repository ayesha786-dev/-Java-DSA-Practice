package com;

import java.util.HashSet;
import java.util.Set;

public class MaxUniqueSubstringsSplitter {

	public int helper(String sub, Set<String> set) {
		int max = 0;
		for (int i = 1; i <= sub.length(); i++) {

			String subStr = sub.substring(0, i);
			if (!set.contains(subStr)) {
				set.add(subStr);
				max = Math.max(max, 1 + helper(sub.substring(i), set));
				set.remove(subStr);
			}
		}
		return max;
	}

	public int maxUniqueSplit(String s) {

		return helper(s, new HashSet<>());
	}

	public static void main(String[] args) {

		MaxUniqueSubstringsSplitter splitter = new MaxUniqueSubstringsSplitter();
		System.out.println(splitter.maxUniqueSplit("ababccc"));
	}
}
