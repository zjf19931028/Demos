package com.future.message.algorithm.bean;

import com.future.message.util.ShowLogUtil;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/17 10:09
 * Description: 哈希映射
 * 时间复杂度O(n/b):n哈希表的元素数量，b为链表的数量?
 * 空间复杂度O(n+b)
 *         MyHashMap hashMap = new MyHashMap();
 *         hashMap.put(2, 3);
 *         hashMap.put(2, 4);
 *         int param_2 = hashMap.get(2);
 *         hashMap.remove(2);
 */
public class MyHashMap {
    private class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static final int BASE = 700;
    LinkedList[] data;

    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Pair>();
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Iterator it = data[hash].iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (pair.getKey() == key) {
                pair.setValue(value);
                ShowLogUtil.info("put=" + key + ",value=" + value);
                return;
            }
        }
        ShowLogUtil.info("put=" + key + ",value=" + value);
        data[hash].addLast(new Pair(key, value));
    }

    public int get(int key) {
        int hash = hash(key);
        Iterator it = data[hash].iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (pair.getKey() == key) {
                ShowLogUtil.info("get=" + key + ",value=" + pair.getValue());
                return pair.getValue();
            }
        }
        return 0;
    }

    public void remove(int key) {
        int hash = hash(key);
        Iterator it = data[hash].iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (pair.getKey() == key) {
                data[hash].remove(pair);
                ShowLogUtil.info("remove=" + key);
                return;
            }
        }
    }

    public int hash(int key) {
        return key % BASE;
    }
}
