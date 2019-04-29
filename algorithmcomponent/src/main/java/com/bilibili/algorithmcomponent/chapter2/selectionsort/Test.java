package com.bilibili.algorithmcomponent.chapter2.selectionsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String args[]) {

//        Integer[] arr = {2, 4, 5, 1, 3, 8, 6, 0};
//        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
//        System.out.println("排序后的集合:" + selectionSort(list).toString());

        int[] arr1 = {2, 4, 5, 1, 3, 8, 6, 0};
        int[] sort1 = selectionSort1(arr1);
        System.out.print("排序后的数组:");
        for (int i = 0; i < sort1.length; i++) {
            System.out.print(sort1[i]);
        }
    }

    private static int[] selectionSort1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    private static List<Integer> selectionSort(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            newList.add(Integer.valueOf(findSmallest(list)));
        }
        return newList;
    }

    private static int findSmallest(List<Integer> list) {
        int smallest = list.get(0);
        int smallIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < smallest) {
                smallest = list.get(i);
                smallIndex = i;
            }
        }
        return list.remove(smallIndex);
    }

}
