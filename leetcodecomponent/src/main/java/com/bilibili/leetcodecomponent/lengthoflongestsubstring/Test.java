package com.bilibili.leetcodecomponent.lengthoflongestsubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class Test {
    public static void main(String[] args) {
        int length = lengthOfLongestSubstring2("dvdf");
        System.out.println(length);
    }

    private static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (isAllNotEqual(s, i, j)) {
                    max = Math.max(max, j - i);
                } else {
                    break;
                }
            }
        }
        return max;
    }

    private static boolean isAllNotEqual(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    private static int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int length = s.length();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (set.contains(s.charAt(j - 1))) {
                    set.clear();
                    break;
                } else {
                    max = Math.max(max, j - i);
                    set.add(s.charAt(j - 1));
                }
            }
        }
        return max;
    }

    private static int lengthOfLongestSubstring3(String s) {
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, max = 0;

        while (i < length && j < length) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            }
        }

        return max;
    }

    private static int lengthOfLongestSubstring4(String s) {
        int max = 0;
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < length; j++) {
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)) ,i);
            }
            max = Math.max(max ,j-i);
            map.put(s.charAt(j),j);
        }
        return max;
    }
}
