package com.renqpku;

import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * Example 1: nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0
 * 
 * Example 2: nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * @author renqiang
 *
 */

public class MedianOfTwoSortedArrays_4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int[] c = new int[nums1.length + nums2.length];
		System.arraycopy(nums1, 0, c, 0, nums1.length);
		System.arraycopy(nums2, 0, c, nums1.length, nums2.length);

		Arrays.sort(c);

		int i = 0, j = c.length - 1;
		for (;; i++, j--) {
			if (i >= j)
				break;
		}

		double t1 = c[i];
		double t2 = c[j];
		double result = (t1 + t2) / 2;

		return result;
	}

	public static void main(String[] args) {
		MedianOfTwoSortedArrays_4 m4 = new MedianOfTwoSortedArrays_4();
		int nums1[] = { 1, 3 };
		int nums2[] = { 2, 4 };
		m4.findMedianSortedArrays(nums1, nums2);

	}

	// best solution
	public static int findKthSmallest(int[] a, int m, int begin1, int[] b, int n, int begin2, int k) {

		if (m > n)
			return findKthSmallest(b, n, begin2, a, m, begin1, k);
		if (m == 0)
			return b[begin2 + k - 1];
		if (k == 1)
			return Math.min(a[begin1], b[begin2]);
		int partA = Math.min(k / 2, m), partB = k - partA;
		if (a[begin1 + partA - 1] == b[begin2 + partB - 1])
			return a[begin1 + partA - 1];
		else if (a[begin1 + partA - 1] > b[begin2 + partB - 1])
			return findKthSmallest(a, m, begin1, b, n - partB, begin2 + partB, k - partB);
		else
			return findKthSmallest(a, m - partA, begin1 + partA, b, n, begin2, k - partA);

	}

	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length, sumLen = len1 + len2;
		if (sumLen % 2 != 0) {
			return findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2 + 1);
		} else {
			return (findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2)
					+ findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2 + 1)) / 2.0;
		}

	}

}
