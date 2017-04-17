package com.renqpku;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer.
 * 
 * Example:
 * 
 * Input: "cbbd"
 * 
 * Output: "bb"
 * 
 * @author renqiang
 *
 */

public class LongestPalindromicSubstring_5 {

	public boolean isPalindrome(String s, int startIndex, int endIndex) {
		for (int i = startIndex, j = endIndex; i <= j; i++, j--)
			if (s.charAt(i) != s.charAt(j))
				return false;
		return true;
	}

	public String longestPalindrome(String s) {
		int n = s.length();
		int longestLen = 0;
		int longestIndex = 0;

		for (int currentIndex = 0; currentIndex < n; currentIndex++) {
			if (isPalindrome(s, currentIndex - longestLen, currentIndex)) {
				longestLen += 1;
				longestIndex = currentIndex;
			} else if (currentIndex - longestLen - 1 >= 0
					&& isPalindrome(s, currentIndex - longestLen - 1, currentIndex)) {
				longestLen += 2;
				longestIndex = currentIndex;
			}
		}
		longestIndex++;
		return s.substring(longestIndex - longestLen, longestIndex);
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring_5 c = new LongestPalindromicSubstring_5();
		String test = "babad";
		String test1 = "cbbd";
		System.out.println(c.longestPalindrome(test));
		System.out.println(c.longestPalindrome(test1));

	}

}
