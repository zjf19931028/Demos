package com.awesome.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/15 13:51
 * Description:
 */
public class SolutionString {
    // 翻转字符串
    // 双指针
    // 时间复杂度O(n)
    // 空间复杂度O(1)
    public static char[] reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
        return s;
    }

    // 整数翻转
    // 时间复杂度O(n)
    // 空间复杂度O(1)
    // 弹出和推入数组&移除前进行检查？
    // SolutionString.reverse(-2147483648);
    public static int reverse(int x) {
        boolean isNegative = (x < 0);
        long expandX = x;
        expandX = Math.abs(expandX);
        String s = String.valueOf(expandX);
        char[] chars = s.toCharArray();
        char[] reverseString = reverseString(chars);
        long value = Long.valueOf(String.valueOf(reverseString));
        if (isNegative) value = -1 * value;
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) value;
        }
    }

    // 字符串中的第一个唯一字符
    // 使用哈希表存储频数
    // 时间复杂度O(n)
    // 空间复杂度O(∣Σ∣)
    // 使用哈希表存储索引
    // 时间复杂度O(n)
    // 空间复杂度O(∣Σ∣)
    // 队列?
    // SolutionString.firstUniqChar("loveleetcode");
    public static int firstUniqChar(String s) {
//        Map<Character, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (hashMap.get(s.charAt(i)) == 1) return i;
//
//        }
//        return -1;
        Map<Character, Integer> hashMap = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, -1);
            } else {
                hashMap.put(ch, i);
            }
        }
        int first = -1;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            Integer value = entry.getValue();
            if (value != -1 && value < length) {
                first = value;
            }
        }
        return first;


//        Map<Character, Integer> position = new HashMap<Character, Integer>();
//        int n = s.length();
//        for (int i = 0; i < n; ++i) {
//            char ch = s.charAt(i);
//            if (position.containsKey(ch)) {
//                position.put(ch, -1);
//            } else {
//                position.put(ch, i);
//            }
//        }
//        int first = n;
//        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
//            int pos = entry.getValue();
//            if (pos != -1 && pos < first) {
//                first = pos;
//            }
//        }
//        if (first == n) {
//            first = -1;
//        }
//        return first;
    }

    // 有效的字母异位词
    // 排序
    // 数组
    // 时间复杂度O(m+n)
    // 空间复杂度O(S)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] letter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            letter[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            letter[ch - 'a']--;
            if (letter[ch - 'a'] < 0) return false;
        }
        return true;
    }

    // 验证回文串
    // 筛选 + 判断
    // 时间复杂度O(∣s|)
    // 空间复杂度O(∣s|)
    // 在原字符串上直接判断
    // 时间复杂度O(∣s|)
    // 空间复杂度O(1)
    // SolutionString.isPalindrome(".,")
    public static boolean isPalindrome(String s) {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isLetterOrDigit(s.charAt(i)))
//                sb.append(s.charAt(i));
//        }
//        String newStr = sb.toString();
//        int newStrLength = sb.toString().length();
//        for (int i = 0; i < newStrLength / 2; i++) {
//            if (newStr.charAt(i) != newStr.charAt(newStrLength - i)) return false;
//        }
//        return true;
        if (s == null) return false;
        int length = s.length();
        int left = 0;
        int right = length - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left))) {
                if (left == right) return true;
                if (left > right - 1) break;
                left++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                if (right < left + 1) break;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }

    // 字符串转换整数
    //
//    public static boolean myAtoi(String s) {
//
//    }

    // 实现strStr()
    //
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;
        if (needle.length() == 0)
            return 0;
        char firstLitter = needle.charAt(0);
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            if (firstLitter == haystack.charAt(i)) {
                if (haystackLength >= i + needleLength) {
                    if (haystack.substring(i, i + needleLength).equals(needle))
                        return i;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    // 外观数列
//    public static String countAndSay(int n) {
//    }

    // 最长公共前缀
    // SolutionString.longestCommonPrefix(new String[]{"dog","racecar","car"});
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0)
                return "";
        }
        return prefix;
    }


    public static String longestCommonPrefix(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length());
        int index = 0;
        while (length > 0 && (s1.charAt(index) == s2.charAt(index))) {
            index++;
            length--;
        }
        return s1.substring(0, index);
    }
}
