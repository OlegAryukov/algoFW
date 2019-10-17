package leetcode.explore.array;

import java.util.Stack;

public class AnotheInsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<Integer> integerStack = new Stack<>();
        int leftBorder = newInterval[0];
        int rightBorder = newInterval[1];
        if (intervals.length > 0) {
            if (intervals.length > 1) {
                for (int i = 0; i < intervals.length; i++) {
                    if(intervals[i][0] <= newInterval[0]){
                        integerStack.push(intervals[i][0]);
                    }
                    if(intervals[i][1]<=newInterval[0]){
                        integerStack.push(intervals[i][1]);
                    }
                    if(intervals[i][0] >= newInterval[0]){
                        integerStack.push(intervals[i][0]);
                    }
                    if(intervals[i][1]>=newInterval[0]){
                        integerStack.push(intervals[i][1]);
                    }
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        AnotheInsertInterval insertInterval = new AnotheInsertInterval();
        int[][] test = new int[7][2];
        test[0] = new int[]{1, 2};
        test[1] = new int[]{3, 5};
        test[2] = new int[]{6, 7};
        test[3] = new int[]{8, 10};
        test[4] = new int[]{12, 16};
        test[5] = new int[]{17, 20};
        test[6] = new int[]{21, 25};
        int[] newInt = new int[]{4, 8};

        int[][] test2 = new int[2][2];
        test2[0] = new int[]{1, 3};
        test2[1] = new int[]{6, 9};
        int[] newInt2 = new int[]{2, 5};

        int[][] test3 = new int[1][];
        int[] input = new int[]{1,5};
        test3[0] = input;
        int[] newInt3 = new int[]{0, 6};

        int[][] res = insertInterval.insert(test, newInt);
        for (int i = 0; i < res.length; i++) {
            System.out.println("[" + res[i][0] + "," + res[i][1] + "]");

        }
    }
}
