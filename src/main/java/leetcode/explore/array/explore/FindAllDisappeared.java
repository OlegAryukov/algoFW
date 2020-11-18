package leetcode.explore.array.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllDisappeared {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
//        if (nums.length == 2) {
//            if (nums[0] == 1 && nums[1] == 1) {
//                res.add(2);
//                return res;
//            }
//            if (nums[0] == 2 && nums[1] == 2) {
//                res.add(1);
//                return res;
//            }
//        }
        int last = 1;
        int j = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (j != nums[i]) {
                res.add(j);
                j++;
                while (j != nums[i]) {
                    j++;
                    res.add(j);
                }
                continue;
            }
            j++;
        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                res.add(i + 1);
//            }
//        }
        return res;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {

        // Iterate over each of the elements in the original array
        for (int i = 0; i < nums.length; i++) {

            // Treat the value as the new index
            int newIndex = Math.abs(nums[i]) - 1;

            // Check the magnitude of value at this new index
            // If the magnitude is positive, make it negative
            // thus indicating that the number nums[i] has
            // appeared or has been visited.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<Integer>();

        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] input = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
//        int[] input = new int[]{5,4,6,7,9,3,10,9,5,6};
//        int[] input = new int[]{2,2};
//        int[] input = new int[]{1, 1};
//        int[] input = new int[]{1, 1, 2, 2};
        int[] input = new int[]{9, 9, 4, 10, 8, 5, 2, 2, 7, 7};
        FindAllDisappeared.findDisappearedNumbers(input).forEach(System.out::println);
    }
}
