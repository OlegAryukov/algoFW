package leetcode.yandex.medium;

public class Onece {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt1 = 0;
        int cnt2 = 0;
        int maxOne = 0;
        for (int num : nums) {
            if (num == 1) {
                ++cnt2;
            } else {
                cnt1 = cnt2 + 1;
                cnt2 = 0;
            }
            maxOne = Math.max(maxOne, cnt1 + cnt2);
        }
        return maxOne;
    }
}
