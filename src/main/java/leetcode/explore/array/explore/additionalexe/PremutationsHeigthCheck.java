package leetcode.explore.array.explore.additionalexe;

import java.util.Arrays;

public class PremutationsHeigthCheck {
    public int heightChecker(int[] heights) {
        if (heights.length==1){
            return 0;
        }
        int[] sort = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sort);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i]!=sort[i]){
                res++;
            }
        }
        return res;
    }
    public int heightCheckerWithMergSort(int[] heights) {
        return mergeSort(heights, heights.length);
    }

    public int mergeSort(int[] a, int n) {
        if (n < 2) {
            return 0;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        return merge(a, l, r, mid, n - mid);
    }

    public static int merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }

        return 0;
    }

}
