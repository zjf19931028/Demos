package com.awesome.algorithm;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: JfangZ
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/2/22 18:51
 * Description:
 */
public class SolutionArray {
    // 删除排序数组中的重复项
    // 双指针
    // 时间复杂的O(N)
    // 空间复杂的O(1)
    public static int removeDuplicates(int[] nums) {
        // 定义双指针，第一个指针代表不重复的下标，即index，第二个指针代表每次循环向后推进的下标，即i
        // 比较两个指针的值，如果相等，什么操作都不用做，继续向后循环。
        // 如果不相等，需要把第一个指针向后对进一个，然后赋值为第二个指针的值
        // 直到循环结束，第一个指针的数值增加1，这跟下标是从0开始有关。
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return ++index;
    }

    // 旋转数组
    // 使用额外的数组
    // 时间复杂的O(N)
    // 空间复杂的O(N)
    // 数组翻转
    // 时间复杂的O(2N)
    // 空间复杂的O(1)
    public static void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        int n = nums.length;
//        int[] newArr = new int[n];
//        for (int i = 0; i < n; ++i) {
//            newArr[(i + k) % n] = nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            ShowLogUtil.info("newArr[" + i + "]=" + newArr[i]);
//        }

//        k = k % nums.length;
//        reverse(nums, 0, nums.length - 1);
//        reverse(nums, 0, k - 1);
//        reverse(nums, k, nums.length - 1);
//        for (int i = 0; i < nums.length; i++) {
//            ShowLogUtil.info("nums[" + i + "]=" + nums[i]);
//        }

        // 时间复杂的O(N平方)
        // 空间复杂的O(1)
        //        k = k % nums.length;
//        int temp = 0;
//        for (int j = 0; j < k; j++) {
//            temp = nums[nums.length - 1];
//            for (int i = (nums.length - 1); i > 0; i--) {
//                nums[i] = nums[i - 1];
//            }
//            nums[0] = temp;
//        }
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //  存在重复元素
    // 排序
    // 时间复杂的O(NlogN)
    // 空间复杂的O(logN)
    // 哈希表
    // 时间复杂的O(N)
    // 空间复杂的O(1)
    //  int[] a = new int[]{0, 1, 2, 3, 4, 5, 6};
    //  boolean containsDuplicate = Solution.containsDuplicate(a);
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;

//        Set<Integer> hashSet = new HashSet<>();
//        for (int n : nums) {
//            if (!hashSet.add(n))
//                return true;
//        }
//        return false;
    }

//    // 两个数组的交集
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public static int[] intersect(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length) {
//            return intersect(nums2, nums1);
//        }
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        // 遍历第一个数组放入到哈希表
//        for (int num : nums1) {
//            int count = map.getOrDefault(num, 0) + 1;
//            map.put(num, count);
//        }
//        for (int i = 0; i < intersection.length; i++) {
//            ShowLogUtil.info("[" + i + "]=" + intersection[i]);
//        }
//
//        // 创建一个等比例数组
//        int[] intersection = new int[nums1.length];
//        int index = 0;
//        for (int num : nums2) {
//            int count = map.getOrDefault(num, 0);
//            if (count > 0) {
//                intersection[index++] = num;
//                count--;
//                if (count > 0) {
//                    map.put(num, count);
//                } else {
//                    map.remove(num);
//                }
//            }
//        }
//        for (int i = 0; i < intersection.length; i++) {
//            ShowLogUtil.info("[" + i + "]=" + intersection[i]);
//        }
//        ShowLogUtil.info("=============");
//        return Arrays.copyOfRange(intersection, 0, index);
//    }


    // 两个数组的交集
    //
    // 时间复杂度O(m+n)
    // 空间复杂度O(min(m,n))
    // 排序+双指针
    // 时间复杂度
    // 空间复杂度min(m,n)
    public static int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums1) {
            int count = hashMap.getOrDefault(num, 0) + 1;
            hashMap.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = hashMap.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    hashMap.put(num, count);
                } else {
                    hashMap.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);


//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int length1 = nums1.length;
//        int length2 = nums2.length;
//        int[] intersection = new int[Math.min(length1, length2)];
//        int index1 = 0;
//        int index2 = 0;
//        int index = 0;
//        while (index1 < length1 && index2 < length2) {
//            if (nums1[index1] < nums2[index2]) {
//                index1++;
//            }
//            if (nums1[index1] > nums2[index2]) {
//                index2++;
//            }
//            if (nums1[index1] == nums2[index2]) {
//                intersection[index] = nums1[index1];
//                ShowLogUtil.info("intersection[" + index + "]=" + intersection[index]);
//                index1++;
//                index2++;
//                index++;
//            }
//        }
//        return Arrays.copyOfRange(intersection, 0, index);
    }

    // 加一
    // 数学算法
    // 时间复杂度O(n)
    // 空间复杂度O(1)
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
//            ShowLogUtil.info("[" + i + "]=" + digits[i]);
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    // 移动零
    // 双指针
    // 时间复杂度O(n)
    // 空间复杂度O(1)
    public static int[] moveZeroes(int[] nums) {
        int zeroSum = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroSum++;
            } else {
                nums[index++] = nums[i];
            }
        }
        while (zeroSum > 0) {
            nums[nums.length - zeroSum] = 0;
            zeroSum--;
        }
        return nums;
    }

    // 两数之和
    // 双指针
    // 时间复杂度O(n平方)
    // 空间复杂度O(1)
    // 哈希表
    // 时间复杂度O(n)
    // 空间复杂度O(n)
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) return null;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target)
//                    return new int[]{i, j};
//            }
//        }

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i]))
                return new int[]{hashMap.get(target - nums[i]), i};
            hashMap.put(nums[i], i);
        }
        return null;
    }

    // 有效的数独
    // 哈希表
    // 时间复杂度O(1)
    // 空间复杂度O(1)
    //        String[][] a = new String[][]{
    //                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
    //                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
    //                {".", "9", "8", ".", ".", ".", ".", "6", "."},
    //                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
    //                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
    //                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
    //                {".", "6", ".", ".", ".", ".", "2", "8", "."},
    //                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
    //                {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
    public static boolean isValidSudoku(String[][] board) {
        // key值，value出现次数
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] columns = new HashMap[9];
        Map<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (!TextUtils.equals(board[i][j], ".")) {
//                    int n = Integer.valueOf(board[i][j]);
//                    int box_index = i / 3 * 3 + j / 3;
//                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
//                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
//                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);
//                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
//                        return false;
//                }
//            }
//        }
        return true;
    }


    // 旋转图像
    // 使用辅佐数组
    // 时间复杂度O(n平方)
    // 空间复杂度O(n平方)
    // 原地旋转
    // 用翻转代替旋转
    // int[][] matrix = {{1,2,3,4},{4,5,6,5},{7,8,9,1}{4,4,6,5}};
    //   SolutionArray.rotate(matrix);
    //        for (int i = 0; i < matrix.length; i++) {
    //            for (int j = 0; j < matrix.length; j++) {
    //                ShowLogUtil.info(matrix[i][j]);
    //            }
    //        }
    public static void rotate(int[][] matrix) {
//        int n = matrix.length;
//        int[][] new_matrix = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                new_matrix[j][n - 1 - i] = matrix[i][j];
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = new_matrix[i][j];
//            }
//        }

        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < (length + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = temp;
            }
        }
    }
}


/**
 *     private void doQueue() {
 *
 * //        MyQueue q = new MyQueue();
 * //        q.enQueue(5);
 * //        q.enQueue(3);
 * //        if (q.isEmpty() == false) {
 * //            ShowLogUtil.info(q.Front());
 * //        }
 * //        q.deQueue();
 * //        if (q.isEmpty() == false) {
 * //            ShowLogUtil.info(q.Front());
 * //        }
 * //        q.deQueue();
 * //        if (q.isEmpty() == false) {
 * //            ShowLogUtil.info(q.Front());
 * //        }
 * //        // 1. Initialize a queue.
 * //        Queue<Integer> q = new LinkedList();
 * //        // 2. Get the first element - return null if queue is empty.
 * //        ShowLogUtil.info("The first element is: " + q.peek());
 * //        // 3. Push new element.
 * //        q.offer(5);
 * //        q.offer(13);
 * //        q.offer(8);
 * //        q.offer(6);
 * //        // 4. Pop an element.
 * //        q.poll();
 * //        // 5. Get the first element.
 * //        ShowLogUtil.info("The first element is: " + q.peek());
 * //        // 7. Get the size of the queue.
 * //        ShowLogUtil.info("The size is: " + q.size());
 * //        MyCircularQueue obj = new MyCircularQueue(5);
 * //        boolean param_1 = obj.enQueue(1);
 * //        boolean param_7 = obj.enQueue(1);
 * //        boolean param_8 = obj.enQueue(1);
 * //        boolean param_9 = obj.enQueue(1);
 * //        boolean param_10 = obj.enQueue(1);
 * //        boolean param_11 = obj.enQueue(1);
 * //        ShowLogUtil.info("param_1="+param_1);
 * //        ShowLogUtil.info("param_7="+param_7);
 * //        ShowLogUtil.info("param_8="+param_8);
 * //        ShowLogUtil.info("param_9="+param_9);
 * //        ShowLogUtil.info("param_10="+param_10);
 * //        ShowLogUtil.info("param_11="+param_11);
 * //        boolean param_2 = obj.deQueue();
 * //        ShowLogUtil.info("param_2="+param_2);
 * //        int param_3 = obj.Front();
 * //        ShowLogUtil.info("param_3="+param_3);
 * //        int param_4 = obj.Rear();
 * //        ShowLogUtil.info("param_4="+param_4);
 * //        boolean param_5 = obj.isEmpty();
 * //        ShowLogUtil.info("param_5="+param_5);
 * //        boolean param_6 = obj.isFull();
 * //        ShowLogUtil.info("param_6="+param_6);
 *     }
 */
