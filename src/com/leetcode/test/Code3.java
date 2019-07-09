package com.leetcode.test;

public class Code3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = n - 1; i >= 0; i--) {
			if (nums1[m - 1] > nums2[i]) {
				nums1[m + n - 1] = nums1[i];
			}
		}
	}
}
