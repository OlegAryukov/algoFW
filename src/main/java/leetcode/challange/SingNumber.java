package leetcode.challange;

import java.util.HashMap;

public class SingNumber {
    public static int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int possibleRes = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(!map.containsKey(nums[i])){
//               map.put(nums[i],1);
//               possibleRes += nums[i];
//            } else {
//                possibleRes -= nums[i];
//            }
//        }
        int possibleRes = 0;
        for (int i = 0; i < nums.length; i++) {
            possibleRes = possibleRes + i%2==0 ? nums[i] : -nums[i];
        }
        return -1 * possibleRes;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,2,1}; //[4,1,2,1,2]
        System.out.println(SingNumber.singleNumber(input));
    }
}
