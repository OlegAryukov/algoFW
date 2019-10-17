package leetcode.explore.array;

public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int fullSum = getImputSum(nums);
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(leftSum == (fullSum - leftSum - nums[i])){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    private int getImputSum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        PivotIndex pi = new PivotIndex();
        System.out.println(pi.pivotIndex(new int[]{1,7,3,6,5,6}));
    }
}
