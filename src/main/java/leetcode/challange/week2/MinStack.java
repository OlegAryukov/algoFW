package leetcode.challange.week2;

import java.util.Arrays;


public class MinStack {
    private int[] store = new int[100];
    private int min = 0;
    int topIdx = -1;
    private boolean isFirstPush = true;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int x) {
        if (topIdx == store.length - 1) {
            int[] tmp = store;
            store = Arrays.copyOf(tmp, tmp.length * 2);
        }
        topIdx++;
        store[topIdx] = x;
        min = isFirstPush ? x : Math.min(min, x);
        isFirstPush = false;
    }

    public void pop() {
        if(store[topIdx] == min){
           min = store[topIdx-1];
        }
       store[topIdx] = 0;
       topIdx--;
       if(topIdx == 0){
           min = store[0];
       } else {
           int[] tmp = Arrays.copyOf(store, topIdx);
           Arrays.sort(tmp, 0, topIdx);
           min = Math.min(min, tmp[0]);
       }
    }

    public int top() {
        return store[topIdx];
    }

    public int getMin() {
        return min;
    }
}
