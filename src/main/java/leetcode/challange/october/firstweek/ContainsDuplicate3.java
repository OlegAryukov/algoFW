package leetcode.challange.october.firstweek;

public class ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+k; j < nums.length; j++) {
                if(Math.abs(nums[i]-nums[j])<=t && Math.abs(i-j)<=k){
                    return true;
                }
            }
        }
        return false;
    }
}
