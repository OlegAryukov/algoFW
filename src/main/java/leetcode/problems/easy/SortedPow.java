package leetcode.problems.easy;

import java.util.PriorityQueue;
import java.util.Queue;

public class SortedPow {
    public static int[] sortedSquares(int[] A) {
        int length = A.length;
        if(length <=2){
            if(length ==2){
                return new int[]{(int) Math.min(Math.pow(A[0], 2), Math.pow(A[1], 2)), (int) Math.max(Math.pow(A[0], 2), Math.pow(A[1], 2))};
            }
            else return new int[]{(int)Math.pow(A[0], 2)};
        }
        int[] res = new int[length];
        int firstPlusNumber = 0;
        for (int i = 0; i < length; i++) {
            if (A[i] >= 0) {
                firstPlusNumber = i;
                break;
            }
        }
        int k = firstPlusNumber - 1;
        int position = 0;
        if (A[firstPlusNumber] == 0) {
            res[position] = 0;
            position++;
            firstPlusNumber++;
        }
        for (int i = firstPlusNumber; i < length; i++) {
            if (k >=0) {
                if (Math.pow(A[k], 2) <= Math.pow(A[i], 2)) {
                    res[position] = (int) Math.pow(A[k], 2);
                    position++;
                    k--;
                    i--;
                    continue;
                }
            }
            res[position] = (int) Math.pow(A[i], 2);
            position++;
            continue;
        }
        if(k==0){
            while (k>-1){
                res[position] = (int) Math.pow(A[k], 2);
                position++;
                k--;
            }
        }
        return res;
    }
    public static int[] sortedSquaresV2(int[] A) {
        if(A.length <=2){
            if(A.length==2){
                return new int[]{(int) Math.min(Math.pow(A[0], 2), Math.pow(A[1], 2)), (int) Math.max(Math.pow(A[0], 2), Math.pow(A[1], 2))};
            }
            else return new int[]{(int)Math.pow(A[0], 2)};
        }
        int[] res = new int[A.length];
        int position = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            queue.add((int)Math.pow(A[i], 2));
        }
        while (!queue.isEmpty()){
            res[position] = queue.poll();
            position++;
        }
        return res;
    }

    public static int[] sortedSquaresV3(int[] A) {
        if(A.length <=2){
            if(A.length==2){
                return new int[]{(int) Math.min(Math.pow(A[0], 2), Math.pow(A[1], 2)), (int) Math.max(Math.pow(A[0], 2), Math.pow(A[1], 2))};
            }
            else return new int[]{(int)Math.pow(A[0], 2)};
        }
        int length =A.length;
        int[] res = new int[A.length];
        int position = 0;
        for (int i = 0; i < length; i++) {
            int pow = (int) Math.pow(A[i], 2);
            res[i] = pow;
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i : SortedPow.sortedSquaresV2(new int[]{-4,-1,0,3,10})){
            System.out.println(i);
        }
    }
}
