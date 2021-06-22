package com.awesome.javademo.algorithm;

/**
 * Author: zhangjingfang
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/6/22 1:35 下午
 * Description:类描述
 */
public class SolutionSort {
    // 合并两个有序数组
    // 双指针
    // 时间复杂的O(N)
    // 空间复杂的O(1)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexM = m - 1;
        int indexN = n - 1;
        for (int i = nums1.length - 1; i > 0; i--) {
            if (nums1[indexM] > nums2[indexN]) {
                nums1[i] = nums1[indexM];
                indexM--;
            } else {
                nums1[i] = nums2[indexN];
                indexN--;
            }
        }
    }
}