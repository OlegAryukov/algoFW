package leetcode.explore.array.explore;

import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
