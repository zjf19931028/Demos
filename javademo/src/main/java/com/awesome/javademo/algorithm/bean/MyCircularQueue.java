package com.awesome.javademo.algorithm.bean;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/16 17:17
 * Description:
 */
public class MyCircularQueue {
    // store elements
    private int[] data;
    // a pointer to indicate the start position
    private int head;
    private int tail;
    private int size;
    private int index;

    public MyCircularQueue(int length) {
        data = new int[length];
        head = -1;
        tail = -1;
        size = length;
    }

    public boolean enQueue(int x) {
        if (isFull() == true) {
            return false;
        }
        if (isEmpty() == true) {
            head = 0;
        }
        tail = (tail + 1) % size;
        data[tail] = x;
        return true;
    }


    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    public int Front() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[head];
    }
    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[tail];
    }
    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }
}
