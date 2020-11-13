package educativity.algojava.search.excersise.dynamic;

public class PartitionProblem {
    public static Object canPartition(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        return sum % 2 == 0 ? subsetSum(num, num.length, sum / 2) : Boolean.FALSE;
    }

    public static boolean subsetSum(int[] num, int n, int sum) {
        boolean[][] loockUpTable = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            loockUpTable[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (num[i - 1] > j) {
                    loockUpTable[i][j] = loockUpTable[i - 1][j];
                } else {
                    loockUpTable[i][j] = loockUpTable[i - 1][j] || loockUpTable[i - 1][j - num[i - 1]];
                }
            }
        }
        return loockUpTable[n][sum];
    }

    public static void main(String[] args) {
        PartitionProblem.canPartition(new int[]{1, 2, 3, 4});
    }
}
