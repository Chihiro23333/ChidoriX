package com.bilibili.leetcodecomponent.palindromenum;

public class Test {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x !=0)) {
            return false;
        }

        int result = 0;
        while (x > result) {
            int i = x % 10;
            result = result * 10 + i;
            x /= 10;
        }

        return result == x || x == result / 10;
    }
}
