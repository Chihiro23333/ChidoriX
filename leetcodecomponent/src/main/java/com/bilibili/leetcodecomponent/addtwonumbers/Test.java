package com.bilibili.leetcodecomponent.addtwonumbers;

/**
 *   给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     示例：
     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807
 */

public class Test {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);

        ListNode l2 = new ListNode(1);

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    public static ListNode addTwoNumbers(ListNode n1, ListNode n2) {
        ListNode base = new ListNode(0);
        ListNode p = n1, q = n2, curr = base;
        int carry = 0;
        while (p != null || q != null) {
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);

            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return base.next;
    }

}
