package com.bilibili.algorithmcomponent.chapter1.binarysearch;

import java.util.List;

public class Test {

    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("选中的数字位置为:" + binarySearch(arr, 8));
    }

    private static int binarySearch(int[] arr, int i) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int midIndex = (low + high) / 2;
            int mid = arr[midIndex];
            if (mid < i) {
                low = midIndex;
            } else if (mid > i) {
                high = midIndex;
            } else {
                return midIndex;
            }
        }
        return -1;
    }

}
