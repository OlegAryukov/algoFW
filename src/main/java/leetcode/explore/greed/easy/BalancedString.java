package leetcode.explore.greed.easy;

public class BalancedString {
    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int r = 0;
        int l = 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == 'R') {
                r++;
            } else {
                l++;
            }
            if(r==l){
                count++;
            }
        }
        return count;
    }
}
