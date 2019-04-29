package com.bilibili.algorithmcomponent.chapter6.BFSandDFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Test {

    public static void main(String args[]) {

        /**
         *        1
         *       / \
         *      2 - 3
         *     / \  / \
         *    4  5  6  7
         */

        Map<String, List<String>> all = new HashMap<>();
        all.put("1", Arrays.asList("2", "3"));
        all.put("2", Arrays.asList("3", "4", "5"));
        all.put("3", Arrays.asList("2", "6", "7"));
        all.put("4", Arrays.asList("2", "6", "7"));
        all.put("5", null);
        all.put("6", null);
        all.put("7", null);

        System.out.println("是否包含target:" + dfs(all, "7"));
    }

    /**
     *  广度优先搜索(BFS, Breadth First Search)
     * @param all
     * @param target
     * @return
     */
    private static boolean bfs(Map<String, List<String>> all, String target) {
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> searchedElement = new HashSet<>();
        queue.add(all.get("1"));
        while (!queue.isEmpty()) {
            List<String> poll = queue.poll();
            if (poll == null || poll.size() == 0) {
                continue;
            }
            for (int i = 0; i < poll.size(); i++) {
                String s = poll.get(i);
                if (searchedElement.contains(s)) {
                    continue;
                }
                if (target.equals(s)) {
                    return true;
                } else {
                    List<String> list = all.get(s);
                    if (list != null && list.size() > 0) {
                        queue.add(list);
                    }
                }
                searchedElement.add(s);
            }
        }
        return false;
    }

    /**
     * 深度优先搜索(DFS, Depth First Search)
     * @param all
     * @param target
     * @return
     */
    private static boolean dfs(Map<String, List<String>> all, String target) {
        Stack<List<String>> stack = new Stack<>();
        Set<String> searchedElement = new HashSet<>();
        stack.push(all.get("1"));
        while (!stack.isEmpty()) {
            List<String> pop = stack.pop();
            if (pop == null || pop.size() == 0) {
                continue;
            }
            for (int i = 0; i < pop.size(); i++) {
                String s = pop.get(i);
                if (searchedElement.contains(s)) {
                    continue;
                }
                if (target.equals(s)) {
                    return true;
                } else {
                    List<String> list = all.get(s);
                    if (list != null && list.size() > 0) {
                        stack.push(list);
                    }
                }
                searchedElement.add(s);
            }
        }
        return false;
    }
}
