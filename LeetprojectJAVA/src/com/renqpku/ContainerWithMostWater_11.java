package com.renqpku;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * @author renqiang
 *
 */
public class ContainerWithMostWater_11 {

	public int maxArea(int[] height) {
		int maxArea = 0, l = 0, r = height.length - 1;

		while (l < r) {
			maxArea = Math.max(maxArea, Math.abs((r - l) * Math.min(height[l], height[r])));

			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainerWithMostWater_11 cwmw = new ContainerWithMostWater_11();
		int[] test = { 1, 4, 56, 6, 2, 5 };
		System.out.println(cwmw.maxArea(test));
	}

}
