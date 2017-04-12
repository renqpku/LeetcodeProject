package com.renqpku;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * @author renqiang
 *
 */

public class LongestSubstringWithoutRepeatingCharacters_3 {

	public int lengthOfLongestSubstring(String s) {

		StringBuffer tempString = new StringBuffer();
		char cs[] = s.toCharArray();
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < cs.length; i++) {
			tempString.setLength(0);
			for (int j = i; j < cs.length; j++) {
				if (tempString.toString().indexOf(cs[j]) < 0) {
					tempString.append(cs[j]);
				} else {
					break;
				}
			}
			if (result.length() < tempString.length()) {
				result.setLength(0);
				result.append(tempString.toString());
			}
		}

		System.out.println(result.toString());
		return result.length();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters_3 l = new LongestSubstringWithoutRepeatingCharacters_3();

		l.lengthOfLongestSubstring("abcabcbb");
		l.lengthOfLongestSubstring("bbbbb");
		l.lengthOfLongestSubstring("pwwkew");
		l.lengthOfLongestSubstring("c");
		l.lengthOfLongestSubstring("au");
	}

	// best solution: the basic idea is, keep a hashmap which stores the
	// characters in string as keys and their positions as values, and keep two
	// pointers which define the max substring. move the right pointer to scan
	// through the string , and meanwhile update the hashmap. If the character
	// is already in the hashmap, then move the left pointer to the right of the
	// same character last found. Note that the two pointers can only move
	// forward.

	public int lengthOfLongestSubstring2(String s) {
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}
}
