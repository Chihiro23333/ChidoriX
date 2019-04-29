package com.bilibili.algorithmcomponent.chapter4.quicksort;

public class Test {

    public static void main(String args[]) {

        int[] arr = {0, 6, 7, 9, 6, 5, 8};

        quickSort(arr, 0, arr.length - 1);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    private static void quickSort(int[] arr, int low, int high) {


//        {9, 6, 7, 9, 6, 5, 8}
//        i=7,j=6
//        {8, 6, 7, 9, 6, 5, 9}
//        i=5,j=6

        int i = low;
        int j = high;

        if (i >= j) {
            return;
        }

        int base = arr[low];

        while (i < j) {
            while (i <= j && arr[i] <= base) {
                i++;
            }
            while (i <= j && arr[j] > base) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            System.out.println("one=i=" + i + ";j=" + j);
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k]);
            }
        }

        arr[low] = arr[i - 1];
        arr[i - 1] = base;

        System.out.println("two");
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]);
        }
        System.out.println("low=0;high=" + (i - 2));
        quickSort(arr, 0, i - 2);
        System.out.println("low=" + i + ";high=" + high);
        quickSort(arr, i, high);
    }

    public static void sort(int[] a, int low, int height) {
        int i = low;
        int j = height;
        if (i > j) {//放在k之前，防止下标越界
            return;
        }
        int k = a[i];

        while (i < j) {
            while (i < j && a[j] > k) {//找出小的数
                j--;
            }
            while (i < j && a[i] <= k) { //找出大的数
                i++;
            }
            if (i < j) {//交换
                int swap = a[i];
                a[i] = a[j];
                a[j] = swap;
            }

        }
        //交换K
        k = a[i];
        a[i] = a[low];
        a[low] = k;

        //对左边进行排序,递归算法
        sort(a, 0, i - 1);
        //对右边进行排序
        sort(a, i + 1, height);
    }


}
