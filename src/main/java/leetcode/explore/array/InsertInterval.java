package leetcode.explore.array;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = null;
        if (intervals.length > 0) {
            if (intervals.length > 1) {
                int leftBorder = 0;
                int rightBorder = 0;
                int length = intervals.length;
                int start = intervals.length % 2 == 0 ? intervals.length / 2 : (intervals.length + 1) / 2;
                while (rightBorder == 0) {
                    if ((intervals[start][0] >= newInterval[1] || intervals[start][1] >= newInterval[1])
                            && intervals[start - 1][0] < newInterval[1]) {
                        rightBorder = start;
                        break;
                    } else {
                        if (intervals[start - 1][0] > newInterval[0]) {
                            start = start % 2 == 0 ? start / 2 : (start + 1) / 2;
                        } else {
                            start = start % 2 == 0 ? start + (start / 2) : start + ((start + 1) / 2);
                        }
                    }
                }

                for (int i = rightBorder - 1; i > -1; i--) {
                    if (intervals[i][1] < newInterval[0] || intervals[i][0] < newInterval[0]) {
                        leftBorder = i;
                        break;
                    }
                }

                if (intervals[leftBorder][1] > newInterval[0] && intervals[rightBorder][0] == newInterval[1]) {
                    int[] merger = new int[]{intervals[leftBorder][0], intervals[rightBorder][1]};
                    int gap = rightBorder - leftBorder;
                    res = new int[intervals.length - gap][2];
                    insertNewInterval(intervals, res, leftBorder, rightBorder, merger, gap);
                    return res;
                }

                if (intervals[leftBorder][1] >= newInterval[0] && intervals[rightBorder][0] >= newInterval[1]) {
                    int gap = rightBorder - leftBorder;
                    if (gap > 2) {
                        res = new int[intervals.length - gap][2];
                        int[] merger = new int[]{intervals[leftBorder][0], newInterval[1]};
                        insertNewInterval(intervals, res, leftBorder, rightBorder, merger, gap);
                    } else {
                        intervals[leftBorder][1] = newInterval[1];
                        res = intervals;
                    }
                    return res;
                }else {
                    int[][] calcRes = new int[1][];
                    calcRes[0] = newInterval;
                    return calcRes;
                }
            } else {
                if(intervals[0][1] >= newInterval[0]){
                    if(intervals[0][0] > newInterval[0] && intervals[0][0] > newInterval[1]){
                        res = new int[2][];
                        res[0] = newInterval;
                        res[1] = intervals[0];
                        return res;
                    }
                    intervals[0][0] = Math.min(intervals[0][0], newInterval[0]);
                    intervals[0][1] = Math.max(intervals[0][1], newInterval[1]);
                    return intervals;
                } else if(intervals[0][1] >= newInterval[0]) {
                    res = new int[1][];
                    res[0] = new int[]{intervals[0][0], newInterval[1]};
                    return res;
                }else {
                    res = new int[2][];
                    res[0] = intervals[0];
                    res[1] = newInterval;
                    return res;
                }
            }
        } else {
            if(newInterval.length>1){
                res = new int[1][2];
                res[0] = newInterval;
            }
        }
        return res;
}

    private void insertNewInterval(int[][] intervals, int[][] res, int leftBorder, int rightBorder, int[] merger,
                                   int gap) {
        for (int i = 0; i < intervals.length; i++) {
            if (i == leftBorder) {
                res[i] = merger;
            }
            if (i < leftBorder) {
                res[i] = intervals[i];
            }
            if (i > rightBorder) {
                res[i - gap] = intervals[i];
            }
        }
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] test = new int[2][2];
        test[0] = new int[]{1, 5};
        test[1] = new int[]{6, 8};
//        test[2] = new int[]{6, 7};
//        test[3] = new int[]{8, 10};
//        test[4] = new int[]{12, 16};
//        test[5] = new int[]{17, 20};
//        test[6] = new int[]{21, 25};
        int[] newInt = new int[]{5, 6};

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
