package leetcode.explore.array;

import java.util.Arrays;

public class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        if (nums1.length > 0) {
            System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        }

        if (nums2.length > 0) {
            System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);
        }
        Arrays.sort(mergedArray);
        double res = 0;
        if (nums1.length > 0 && nums2.length > 0) {
            res = mergedArray.length % 2 == 0 ? mergedArray[mergedArray.length / 2] :
                    (mergedArray[(mergedArray.length - 1) / 2] + mergedArray[(mergedArray.length + 1) / 2]) / 2;
        } else {
            res = nums1.length > 2 ?
                    nums1.length % 2 == 0 ? nums1[nums1.length / 2] :
                            (nums1[(nums1.length - 1) / 2] + nums1[(nums1.length + 1) / 2]) / 2
                    :
                    nums2.length % 2 == 0 ? nums2[nums2.length / 2] :
                            (nums2[(nums2.length - 1) / 2] + nums2[(nums2.length + 1) / 2]) / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        Median median = new Median();
        System.out.println(median.findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));
    }
}
