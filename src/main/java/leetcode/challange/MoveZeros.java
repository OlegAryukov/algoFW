package leetcode.challange;

public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        //int descreeseCount = nums.length-1;
        int lenght = nums.length;
        int currPos = 0;
        for (int i = 0; i < lenght; i++) {
            if(nums[i]!=0 && i < lenght){
               nums[currPos] = nums[i];
               currPos++;
            }
        }
        for (int i = currPos; i < lenght; i++) {
            nums[i] =0;
        }
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                map.put(j, nums[i]);
//                j++;
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (i < map.size()) {
//                nums[i] = map.get(i);
//            } else {
//
//                nums[i] = 0;
//            }
//        }

    }

    public static void main(String[] args) {
        int[] input = new int[]{0,1,0,3,12};
        MoveZeros.moveZeroes(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
}
