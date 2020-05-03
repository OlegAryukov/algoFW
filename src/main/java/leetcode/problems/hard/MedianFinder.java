package leetcode.problems.hard;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MedianFinder {
    int count = 0;
    boolean isBiggerThanIntMax = false;
    int sum = 0;
    List<Integer> store = new ArrayList<>();
    double median = 0.0;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
    }

    public void addNum(int num) {
        count++;
        sum += num;
    }

    public double findMedian() {
        BigDecimal bd = BigDecimal.valueOf((double) sum/count);
        bd.setScale(1, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(6);
        mf.addNum(10);
        mf.addNum(2);
        mf.addNum(6);
        mf.addNum(5);
        System.out.println(mf.findMedian());
    }
}
