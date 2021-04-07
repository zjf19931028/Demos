package com.future.message.algorithm;

import com.future.message.algorithm.bean.ListNode;
import com.future.message.util.ShowLogUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/16 15:31
 * Description:
 */
public class SolutionLinkedList {
    // 删除链表中的节点
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // 删除链表的倒数第N个节点
    // 计算链表长度
    // 时间复杂的O(n)
    // 空间复杂的O(1)
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 增加伪头
        ListNode newHead = new ListNode(0, head);
        // 计算链表长度
        int size = getLength(head);
        // 前驱节点
        ListNode pred = newHead;
        // 前驱节点
        for (int i = 0; i < size - n; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
        // 去掉伪头
        return newHead.next;

//        ListNode dummy = new ListNode(0, head);
//        Deque<ListNode> stack = new LinkedList<>();
//        ListNode cur = dummy;
//        while (cur != null) {
//            stack.push(cur);
//            cur = cur.next;
//        }
//        for (int i = 0; i < n; i++) {
//            stack.pop();
//        }
//        ListNode prev = stack.peek();
//        prev.next = prev.next.next;
//        ListNode ans = dummy.next;
//        ergodic(ans);
    }

    public static int getLength(ListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public static int ergodic(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            ShowLogUtil.info("node.val=" + node.val);
            node = node.next;
        }
        return length;
    }

    // 快慢指针
    // 时间复杂的O(n)
    // 空间复杂的O(1)
    //        ListNode l1 = new ListNode(1);
    //        ListNode l2 = new ListNode(1);
    //        ListNode l3 = new ListNode(1);
    //        ListNode l4 = new ListNode(1);
    //        ListNode l5 = new ListNode(1);
    //        ListNode l6 = new ListNode(1);
    //        l1.next = l2;
    //        l2.next = l3;
    //        l3.next = l4;
    //        l4.next = l5;
    //        l5.next = l6;
    //        l6.next = null;
    //        boolean hasCycle = SolutionLinkedList.hasCycle(l1);
    //        ShowLogUtil.info("hasCycle=" + hasCycle);
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    // 翻转链表
    // 双指针迭代
    // 时间复杂的O(n)
    // 空间复杂的O(1)
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
