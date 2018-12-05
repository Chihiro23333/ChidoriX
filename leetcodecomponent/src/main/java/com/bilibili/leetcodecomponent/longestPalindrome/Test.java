package com.bilibili.leetcodecomponent.longestPalindrome;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 *   给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

     示例 1：
     输入: "babad"
     输出: "bab"
     注意: "aba" 也是一个有效答案。

     示例 2：
     输入: "cbbd"
     输出: "bb"
 */
public class Test {

    public static void main(String[] args) {
        String babad = longestPalindrome2("abadefg");
        System.out.println(babad);
    }

    public static String longestPalindrome(String s) {

        int length = s.length();
        if (length <= 1) {
            return s;
        }

        String max = "";
        for (int i = length; i >= 0; i--) {
            for (int j = 0; j <= length - i; j++) {
                String substring = s.substring(i, i + j);
                System.out.println(substring);
                int count = 0;
                for (int k = 0; k < substring.length() / 2; k++) {
                    if (substring.charAt(k) == substring.charAt(substring.length() - 1 - k)) {
                        count++;
                    }
                }
                if (count == substring.length() / 2) {
                    max = substring;
                }
            }
        }
        return max;
    }


    public static String longestPalindrome2(String s) {

        int length = s.length();
        if (length <= 1) {
            return s;
        }

        String max = "";
        for (int i = 0; i < length; i++) {
            String s1 = find(s, i, i);
            String s2 = find(s, i, i + 1);
            String s3 = s1.length() > s2.length() ? s1 : s2;
            max = max.length() > s3.length()?max:s3;
        }
        return max;
    }

    private static String find(String s, int start, int end) {
        String jiString = "";
        while (start >= 0 &&
                end <= s.length() - 1 &&
                s.charAt(start) == s.charAt(end)) {
            jiString = s.substring(start, end+1);
            start--;
            end++;
        }
        return jiString;
    }

}
