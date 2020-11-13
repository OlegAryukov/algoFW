package leetcode.explore.array.explore;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempNum1 = Arrays.copyOfRange(nums1, 0, m);
        int tempM = 0;
        int tempN = 0;
        int i = 0;
        while (tempM < m && tempN < n){
            if(tempNum1[tempM] <= nums2[tempN]){
                nums1[i] = tempNum1[tempM];
                i++;
                tempM++;
                continue;
            }
            nums1[i] = nums2[tempN];
            tempN++;
            i++;
        }
        if(tempM >= m) {
            for (int j = tempN; j < nums2.length; j++) {
                nums1[i] = nums2[j];
                i++;
            }
        }
        if (tempN >= n){
            for (int j = tempM; j < tempNum1.length; j++) {
                nums1[i] = tempNum1[j];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        for (int i = 0; i < nums1.length; i++) {

            System.out.print(nums1[i] + " : ");
        }

        int[] nums12 = new int[]{2,0};
        int[] nums22 = new int[]{1};
        merge(nums12, 1, nums22, 1);
        System.out.println("\n");
        for (int i = 0; i < nums12.length; i++) {
            System.out.print(nums12[i] + " : ");
        }
    }
}
