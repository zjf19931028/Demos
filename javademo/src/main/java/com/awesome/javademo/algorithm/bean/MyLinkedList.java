package com.awesome.javademo.algorithm.bean;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/17 13:34
 * Description:
 * 时间复杂度:addAtHead：O(1)、get、addAtIndex、deleteAtIndex：O(S)、addAtTail：O(n)
 * 空间复杂度O(1)
 *       MyLinkedList linkedList = new MyLinkedList();
 *         linkedList.addAtHead(1);
 *         linkedList.addAtTail(3);
 *         linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 *         int val1 = linkedList.get(1);//返回2
 *         ShowLogUtil.info("val1="+val1);
 *         linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 *         int val2 = linkedList.get(1);//返回3
 *         ShowLogUtil.info("val2="+val2);
 */
public class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        // 当前节点
        ListNode curr = head;
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);

    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > val) return;
        if (index < 0) index = 0;
        size++;
        // 先驱节点
        ListNode pred = head;
        // 找到先驱节点
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        // 插入的节点
        ListNode toAdd = new ListNode(val);
        // 插入节点下一个节点是前驱节点后一个节点
        toAdd.next = pred.next;
        // 前驱节点下一个节点是插入节点
        pred.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        // 先驱节点
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;

    }
}
