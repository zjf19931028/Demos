package com.awesome.algorithm.bean;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/17 09:25
 * Description: 哈希集合
 * 时间复杂度O(n/b):n哈希表的元素数量，b为链表的数量?
 * 空间复杂度O(n+b)
 * //        MyHashSet myHashSet = new MyHashSet();
 * //        myHashSet.add(1);// set = [1]
 * //        myHashSet.add(2);// set = [1, 2]
 * //        boolean contains1 = myHashSet.contains(1);// 返回 True
 * //        boolean contains2 = myHashSet.contains(3);// 返回 False ，（未找到）
 * //        ShowLogUtil.info("contains1="+contains1);
 * //        ShowLogUtil.info("contains3="+contains2);
 * //        myHashSet.add(2);// set = [1, 2]
 * //        boolean contains3 = myHashSet.contains(2);// 返回 True
 * //        ShowLogUtil.info("contains2="+contains3);
 * //        myHashSet.remove(2);// set = [1]
 * //        boolean contains4 = myHashSet.contains(2);// 返回 False ，（已移除）
 * //        ShowLogUtil.info("contains2="+contains4);
 */
public class MyHashSet {
    public static final int BASE = 700;
    LinkedList[] data;

    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList();
        }
    }

    public void add(int key) {
        int hash = hash(key);
        LinkedList linkedList = data[hash];
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            int element = (int) it.next();
            if (element == key) {
                return;
            }
        }
        data[hash].addLast(key);
    }

    public boolean contains(int key) {
        int hash = hash(key);
        LinkedList linkedList = data[hash];
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            int element = (int) it.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    public void remove(int key) {
        int hash = hash(key);
        Iterator<Integer> it = data[hash].iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            if (element == key) {
                data[hash].remove(element);
                return;
            }
        }
    }

    public int hash(int key) {
        return key % BASE;
    }
}
