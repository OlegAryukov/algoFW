package leetcode;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {

    private LinkedList[] store;

    public MyHashMap() {
        store = new LinkedList[1000];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int keyInner = key;
        if (key > 1000) {
            keyInner = getKey(key);
        }
        LinkedList exist = store[keyInner];
        if (exist != null) {
            exist.add(new Pair(key, value));
        } else {
            exist = new LinkedList();
            exist.add(new Pair(key, value));
            store[keyInner] = exist;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int value = -1;
        int keyInner = key;
        if (key > 1000) {
            keyInner = getKey(key);
        }
        if (store[keyInner] == null || store[keyInner].isEmpty()) {
            return value;
        } else {
            Iterator<Pair> iter = store[keyInner].iterator();
            while (iter.hasNext()) {
                Pair p = iter.next();
                if (p.key == key) {
                    value = p.value;
                }
            }
        }
        return value;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int keyInner = key;
        if (key > 1000) {
            keyInner = getKey(key);
        }
        if (store[keyInner]!=null && !store[keyInner].isEmpty()) {
            Iterator<Pair> iter = store[keyInner].iterator();
            while (iter.hasNext()) {
                Pair p = iter.next();
                if (p.key == key) {
                    store[keyInner].remove(p);
                }
            }
        }
    }

    private int getKey(int key) {
        if (key > 1000) {
            return key / 1000;
        }
        return key;
    }

    class Pair {
        private int key;
        private int value;

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
    public static void main(String[] args) {
        MyHashMap myMap = new MyHashMap();
        myMap.remove(14);
        myMap.put(1, 2);
        myMap.put(2, 2);
        System.out.println(myMap.get(1));
        System.out.println(myMap.get(3));

        myMap.put(2, 1);
    }
}
