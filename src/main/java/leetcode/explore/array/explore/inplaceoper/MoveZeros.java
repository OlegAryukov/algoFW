package leetcode.explore.array.explore.inplaceoper;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int j = 0;
        int f = 0;
        while (f < nums.length && nums[f] == 0) {
            f++;
        }
        if(f == nums.length){
            return;
        }
        for (int i = f + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if(j!=i){
                    nums[j] = 0;
                }
                j++;
            }
        }
    }
}
