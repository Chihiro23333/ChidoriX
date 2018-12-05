package com.bilibili.leetcodecomponent.zconvert;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(convert1("AB", 1));
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        int length = s.length();
        int min = Math.min(length, numRows);

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < min; i++) {
            list.add(new StringBuilder());
        }

        int row = 0;
        boolean isEnd = true;
        for (int i = 0; i < length; i++) {
            list.get(row).append(s.charAt(i));
            if (row == 0 || row == numRows - 1) isEnd = !isEnd;
            row += isEnd ? -1 : 1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder :
                list) {
            result.append(stringBuilder);
        }

        return result.toString();
    }

    public static String convert1(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }
        int gap = 2 * numRows - 2;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i+j<s.length(); j+=gap) {
                result.append(s.charAt(i+j));
                if(i != 0 && i != numRows - 1 && j+gap-i <s.length()){
                    result.append(s.charAt(j+gap-i));
                }
            }
        }

        return result.toString();
    }
}
