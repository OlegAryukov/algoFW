package leetcode.problems.medium;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int currPosition = 0;
        if (nums.length == 1) {
            return 1;
        }
        int length = nums.length;
        int delta = 0;
        int tmp = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                tmp++;
                if (currPosition != i) {
                    delta = 0;
                }
                continue;
            }
            if (tmp >= 2) {
                if (currPosition == 0) {
                    currPosition += 2;
                } else {
                    nums[currPosition + 1] = nums[i];
                    nums[currPosition + 2] = nums[i];
                    currPosition += 2;
                }
            }
            tmp = 0;
        }
        return currPosition;
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        rd.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
    }
}
