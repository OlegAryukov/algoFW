package educativity.algojava.search.excersise.greedy;

import java.util.Arrays;

public class MinCostOfConnectedPipes {
    public static int minCost(int[] pipesSrc) {
        int cost = 0;
        int[] pipes = Arrays.copyOf(pipesSrc, pipesSrc.length);
        Arrays.sort(pipes);

        for (int i = 1; i < pipes.length; i++) {
            int tmpCost = pipes[i-1] + pipes[i];
            pipes[i] = tmpCost;
            cost +=tmpCost;
        }

//        int[][] table = new int[pipes.length * 2][pipes.length];
//        for (int i = 0; i < pipes.length; i++) {
//            table[0][i] = pipes[i];
//        }
//        for (int i = 1; i < pipes.length * 2; i++) {
//            if (i % 2 != 0) {
//                int min = table[i - 1][i - 1] + table[i-1][i];
//                for (int j = i; j < pipes.length-1; j++) {
//                    if ((table[i - 1][j + 1] < min)) {
//                        table[i][j] = table[i - 1][j + 1];
//                    } else {
//                        table[i][j] = min;
//                    }
//                }
//            } else {
//                for (int j = i; j < pipes.length - 1; j++) {
//                    table[i][j] = table[i - 1][j + 1];
//                }
//            }
//        }
        return cost;
    }

    public static void main(String[] args) {
        System.out.println(MinCostOfConnectedPipes.minCost(new int[]{4, 2, 3, 7}));
    }
}
