package hackerrank.interview.sorting;

import java.util.Arrays;

public class ToysProblem {
    static int maximumToys(int[] prices, int k) {
        int sum = 0;
        int i = 0;
        Arrays.sort(prices);
        while (sum <= k) {
            if (prices[i] < (k - sum)) {
                sum+=prices[i];
                i++;
                continue;
            }
            break;
        }
        return i;
    }
}
