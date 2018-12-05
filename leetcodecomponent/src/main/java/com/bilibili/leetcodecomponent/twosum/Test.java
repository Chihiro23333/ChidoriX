package com.bilibili.leetcodecomponent.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

public class Test {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] ints = twoSum(nums, target);
        System.out.println(ints[0] + "," + ints[1] );

        int[] ints01 = twoSum01(nums, target);
        System.out.println(ints01[0] + "," + ints01[1]);

        int[] ints1 = twoSum1(nums, target);
        System.out.println(ints1[0] + "," + ints1[1]);


        int[] ints2 = twoSum2(nums, target);
        System.out.println(ints2[0] + "," + ints2[1]);
    }

    private static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static int[] twoSum01(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            if (map.containsKey(gap) && map.get(gap) != i) {
                return new int[]{i, map.get(gap)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            if (map.containsKey(gap)) {
                return new int[]{map.get(gap), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

