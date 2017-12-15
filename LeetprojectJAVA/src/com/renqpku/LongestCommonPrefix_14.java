package com.renqpku;

import java.util.Arrays;

public class LongestCommonPrefix_14 {

	public String longestCommonPrefix(String[] strs) {
		StringBuilder sb = new StringBuilder("");
		if (strs == null || strs.length == 0)
			return "";

		Arrays.sort(strs);

		char[] cs = strs[0].toCharArray();
		boolean flag = true;
		for (int i = 0; i < cs.length; i++) {
			flag = true;
			for (int j = 1; j < strs.length; j++) {
				if(strs[j].charAt(i) != cs[i]) 
					flag = false;
			}
			if(!flag) break;
			sb.append(cs[i]);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefix_14 lc = new LongestCommonPrefix_14();
		String[] testData = { "abc", "ab", "ac", "abce", "ad" };

		Arrays.sort(testData);

		for (String s : testData) {
			System.out.println(s);
		}
		
		System.out.println("result: " + lc.longestCommonPrefix(testData));

	}

}
