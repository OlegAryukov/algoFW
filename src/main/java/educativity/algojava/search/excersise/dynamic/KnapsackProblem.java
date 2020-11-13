package educativity.algojava.search.excersise.dynamic;

public class KnapsackProblem {
    static int knapsack(int profits[], int profitsLength, int weights[], int weightsLength, int capacity) {

        int[][] knapsack = new int[profitsLength +1 ][capacity/10 + 1];
        for (int i = 1; i < profitsLength+1; i++) {
            for (int j = 1; j * 10 < capacity+1; j++) {
                if(j * 10 >= weights[i-1]){
                    if (i > 0) {
                        knapsack[i][j] = Math.max(knapsack[i-1][j], profits[i -1 ] + knapsack[i-1][j - weights[i -1 ]/10]);
                        continue;
                    }
                    knapsack[i][j] = profits[i -1];
                }
            }
        }
        return knapsack[profitsLength][capacity/10];
    }

    //educative solving
    public static int knapSack(int profits[], int profitsLength, int weights[], int weightsLength, int capacity) {
        // Basic checks
        if (capacity <= 0 || profitsLength == 0 || weightsLength != profitsLength)
            return 0;

        int i, w;
        int[][]lookupTable = new int[profitsLength + 1][capacity + 1];

        // Building the lookup table in bottom up manner
        for (i = 0; i <= profitsLength; i++) {
            for (w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    lookupTable[i][w] = 0;
                else if (weights[i - 1] <= w)
                    lookupTable[i][w] = Math.max(profits[i - 1] + lookupTable[i - 1][w - weights[i - 1]], lookupTable[i - 1][w]);
                else
                    lookupTable[i][w] = lookupTable[i - 1][w];
            }
        }

        return lookupTable[profitsLength][capacity];
    }

    public static void main(String[] args) {
        System.out.println(KnapsackProblem.knapsack(new int[]{60, 100, 120}, 3, new int[]{10, 20, 30}, 3, 10));
    }
}
