package leetcode.challange;

import java.util.Arrays;

public class CpuntElements {
    public int countElements(int[] arr) {
        Arrays.sort(arr);
        int currMax = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i+1] - arr[i] == 1){
                currMax += 0;
            }
        }
        return 0;
    }
}
