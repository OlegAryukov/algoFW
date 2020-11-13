package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexPointer {
    public static List<List<Integer>> threeSum(int[] nums) {
//        List<Integer> src = new ArrayList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        int length = nums.length;
//        Map<Integer, List<Integer>> table = new HashMap<>();
//        for (int i = 0; i < length; i++) {
//            src.add(nums[i]);
//            if (table.containsKey(nums[i])) {
//                table.get(nums[i]).add(i);
//                continue;
//            }
//            List<Integer> list = new ArrayList<>();
//            list.add(i);
//            table.put(nums[i], list);
//        }
//
//        for (int i = 0; i < length; i++) {
//            if (src.get(i) != null) {
//                for (int j = i + 1; j < length; j++) {
//                    if (src.get(j) != null) {
//                        int diff = 0 - src.get(i) - src.get(j);
//                        if (table.containsKey(diff)) {
//                            List<Integer> list1 = table.get(diff);
//                            if(!list1.isEmpty()){
//                                List<Integer> list = new ArrayList<>();
//                                list.add(nums[i]);
//                                list.add(nums[j]);
//                                list.add(nums[list1.]);
//                                res.add(list);
//
//                            }
//                            if (index != i && index != j) {
//
//
//                                table.remove(nums[i]);
//                                table.remove(nums[j]);
//                                table.remove(nums[index]);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return res;
        return null;
    }

    public static void main(String[] args) {
        for (List<Integer> list : IndexPointer.threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6})) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println("");
            System.out.println("----");
        }
    }
}
