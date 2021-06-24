package com.awesome.javademo.algorithm;

import java.util.Arrays;

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
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int indexM = m - 1;
//        int indexN = n - 1;
//        for (int i = nums1.length - 1; i > 0; i--) {
//            if (nums1[indexM] > nums2[indexN]) {
//                nums1[i] = nums1[indexM];
//                indexM--;
//            } else {
//                nums1[i] = nums2[indexN];
//                indexN--;
//            }
//        }
//    }

    // 合并两个有序数组
    // 合并+排序
    // 时间复杂的O(NlogN)
    // 空间复杂的O(1)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }

//    // 第一个错误的版本
//    public static int firstBadVersion(int n) {
//
//    }

    // 二分法查找-非递归
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (int) Math.floor((low + high) / 2);
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // 二分法查找-递归
    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high) return -1;
        int mid = (int) Math.floor((low + high) / 2);
        if (key == arr[mid]) {
            return mid;
        } else if (key > arr[mid]) {
            low = mid + 1;
            return binarySearch(arr, low, high, key);
        } else {
            high = mid - 1;
            return binarySearch(arr, low, high, key);
        }
    }
}