package com.awesome.javademo.collection;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/18 16:36
 * Description:
 */
public class CollectionUtil {
    public static void function() {
        new LinkedList<>();
        new ArrayList<>();
        new Vector<>();

//        new ArraySet<>();
        new TreeSet<>();
        new HashSet<>();
        new LinkedHashSet<>();

//        new ArrayMap<>();
        new TreeMap<>();
        new HashMap<>();
        new LinkedHashMap<>();
        new Hashtable<>();
//        new SparseArray<>();
        new Properties();
        new WeakHashMap<>();


        //        Vector<Integer> vector = new Vector<>();
//        vector.add(1);
//        vector.add(3);
//        vector.add(4);
//        for (int i = 0; i < vector.size(); i++) {
//            ShowLogUtil.info(vector.get(i));
//        }
//        for (Integer i : vector) {
//            ShowLogUtil.info(i);
//        }
//        Iterator<Integer> it = vector.iterator();
//        while (it.hasNext()){
//            Integer i = it.next();
//            ShowLogUtil.info(i);
//        }

//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(3);
//        arrayList.add(4);
//        arrayList.add(2);
//        for (int i = 0; i < arrayList.size(); i++) {
//            ShowLogUtil.info(arrayList.get(i));
//        }
//        for (Integer i : arrayList) {
//            ShowLogUtil.info(i);
//        }
//        Iterator<Integer> it = arrayList.iterator();
//        while (it.hasNext()){
//            Integer i = it.next();
//            ShowLogUtil.info(i);
//        }
//
//        Collections.sort(arrayList, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (o1 < o2){
//                    return -1;
//                }else {
//                    return 1;
//                }
//            }
//        });
//        for (Integer i : arrayList) {
//            ShowLogUtil.info(i);
//        }

//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1);
//        linkedList.add(3);
//        linkedList.add(4);
//        for (int i = 0; i < linkedList.size(); i++) {
//            ShowLogUtil.info(linkedList.get(i));
//        }
//        for (Integer i : linkedList) {
//            ShowLogUtil.info(i);
//        }
//        Iterator<Integer> it = linkedList.iterator();
//        while (it.hasNext()){
//            Integer i = it.next();
//            ShowLogUtil.info(i);
//        }


//        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (o1 > o2) return 1;
//                return -1;
//            }
//        });
//        treeSet.add(1);
//        treeSet.add(3);
//        treeSet.add(4);
//        treeSet.add(1);
//        for (Integer i : treeSet) {
//            ShowLogUtil.info(i);
//        }
//        Iterator<Integer> it = treeSet.iterator();
//        while (it.hasNext()) {
//            Integer i = it.next();
//            ShowLogUtil.info(i);
//        }


//        HashSet<Integer> hashSet = new HashSet<>();
//        hashSet.add(1);
//        hashSet.add(3);
//        hashSet.add(4);
//        for (Integer i : hashSet) {
//            ShowLogUtil.info(i);
//        }
//        Iterator<Integer> it = hashSet.iterator();
//        while (it.hasNext()){
//            Integer i = it.next();
//            ShowLogUtil.info(i);
//        }

        //给TreeMap赋值
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (o1 > o2) return 1;
//                return -1;
//            }
//        });
//        treeMap.put(1, 4);
//        treeMap.put(5, 8);
//        treeMap.put(9, 12);
//        treeMap.put(13, 16);
//        treeMap.put(1, 20);

        //TreeMap键遍历
//        Set<Integer> keySet = treeMap.keySet();
        //TreeMap键的foreach遍历
//        for (Integer i : keySet) {
//            ShowLogUtil.info("key=" + i + ",value=" + treeMap.get(i));
//        }
        //TreeMap键的Iterator遍历
//        Iterator<Integer> it = keySet.iterator();
//        while (it.hasNext()) {
//            Integer i = it.next();
//            ShowLogUtil.info("key=" + i + ",value=" + treeMap.get(i));
//        }
        //TreeMap值遍历
//        Collection<Integer> values = treeMap.values();
        //TreeMap值的foreach遍历
//        for (Integer i : values) {
//            ShowLogUtil.info("value=" + i);
//        }
        //TreeMap值的Iterator遍历
//        Iterator<Integer> itValue = values.iterator();
//        while (itValue.hasNext()) {
//            Integer i = itValue.next();
//            ShowLogUtil.info("value=" + i);
//        }

        //TreeMap键值对遍历
//        Set<Map.Entry<Integer, Integer>> entries = treeMap.entrySet();
        //TreeMap键值对的foreach遍历
//        for (Map.Entry<Integer, Integer> map : entries) {
//            ShowLogUtil.info("key=" + map.getKey()+",value=" + map.getValue());
//        }
        //TreeMap键值对的Iterator遍历
//        Iterator<Map.Entry<Integer, Integer>> it = entries.iterator();
//        while (it.hasNext()){
//            Map.Entry<Integer, Integer> entry = it.next();
//            ShowLogUtil.info("key=" + entry.getKey()+",value=" + entry.getValue());
//        }

        new HashMap<>();
        new Hashtable<>();
    }
}
