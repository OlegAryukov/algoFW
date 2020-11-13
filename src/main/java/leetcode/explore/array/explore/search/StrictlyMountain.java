package leetcode.explore.array.explore.search;

import java.util.Arrays;

public class StrictlyMountain {
    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int[] forSort = Arrays.copyOf(A, A.length);
        Arrays.sort(forSort);
        int max = forSort[A.length - 1];
        int curVal = A[0];
        boolean afterMiddle = false;
        int countAfterMid = 0;
        for (int i = 1; i < A.length; i++) {
            if (afterMiddle) {
                countAfterMid++;
            }
            if (A[i] == max && !afterMiddle) {
                afterMiddle = true;
                curVal = max;
                continue;
            }
            if (!afterMiddle && A[i] <= curVal) {
                return false;
            } else if (afterMiddle && A[i] >= curVal) {
                return false;
            }
            curVal = A[i];
        }
        return afterMiddle && countAfterMid > 0;
    }

    public static boolean validMountainArray2(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int curVal = A[0];
        int i = 1;
        while (i < A.length && A[i] > curVal) {
            if (curVal >= A[i]) {
                return false;
            }
            curVal = A[i];
            i++;
        }
        if (i == A.length || i == 1) {
            return false;
        }
        while (i < A.length && A[i] < curVal) {
            if (A[i] >= curVal) {
                return false;
            }
            curVal = A[i];
            i++;
        }
        if (i <= A.length - 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] inp2 = new int[]{0, 3, 2, 1};
        int[] inp3 = new int[]{9,8,7,6,5,4,3,2,1,0};
        System.out.println(StrictlyMountain.validMountainArray2(input));
        System.out.println(StrictlyMountain.validMountainArray2(inp2));
        System.out.println(StrictlyMountain.validMountainArray2(inp3));
    }
}
