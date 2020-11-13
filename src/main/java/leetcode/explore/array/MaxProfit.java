package leetcode.explore.array;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] res = new int[length][prices.length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            res[0][i] = prices[i] - prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = i; j < length; j++) {
                res[i][j] = Math.max(prices[j] - prices[i], res[i-1][j]);
//                max+
            }
        }
        return 0;
    }
}
