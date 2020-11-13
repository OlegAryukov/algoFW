package educativity.algojava.search.excersise.dynamic;

import java.util.Arrays;

public class CoinChangeProblem {
    public static int countChange(int denoms[], int amount) {
        int denomsLength = denoms.length;
        if (denomsLength <= 0 || amount <= 0)
            return 0;
        int[] lookupTable = new int[amount + 1];

        lookupTable[0] = 1;

        for (int i = 0; i < denomsLength; i++)
            for (int j = denoms[i]; j <= amount; j++)
                lookupTable[j] += lookupTable[j - denoms[i]];

        return lookupTable[amount];
    }

    public static void main(String[] args) {
        System.out.println(CoinChangeProblem.countChange(new int[]{25, 10, 5, 1}, 10));
    }
}
