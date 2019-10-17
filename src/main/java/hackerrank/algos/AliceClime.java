package hackerrank.algos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//Not worked correctly :(
public class AliceClime {
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] res = new int[alice.length];
        Integer rank = 1;
        Map<Integer, Integer> rankCache = new HashMap<>();
        int currScore = 0;
        int currAlice = alice.length - 1;
        int scoreLength = scores.length - 1;
        int date = 0;
        int tmpDate = 0;
        while (true) {
            if (scores[currScore] > alice[currAlice]) {
                date = scores[currScore];
                rank = addInRankCache(rankCache, date, rank) ? rank + 1 : rank;
                currScore++;
            } else {
                date = alice[currAlice];
                res[currAlice] = rank;
                if (scores[currScore] == alice[currAlice]) {
                    if(addInRankCache(rankCache, date, rank)){
                        rank = rank + 1;
                    }
                }
                currAlice--;
                if (currScore == scoreLength) {
                    tmpDate = scores[currScore];
                }
            }
            if (currScore == scoreLength + 1) {
                if (currAlice != -1) {
                    while (currAlice != -1) {
//                        if (tmpDate > alice[currAlice]) {
//                            rank = rank + 1;
//                        }
                        res[currAlice] = rank;
                        //rank++;
                        currAlice--;
                    }
                }
                break;
            }

            if (currAlice == -1) {
                if (currScore != scoreLength) {
                    while (currScore != scoreLength) {

                        rank++;
                        currScore++;
                    }
                }
                break;
            }
        }
        return res;
    }

    private static boolean addInRankCache(Map rankCache, int date, Integer rank) {
        if (rankCache.isEmpty()) {
            rankCache.put(date, rank);
            return true;
        } else if (!rankCache.containsKey(date)) {
            rankCache.put(date, rank);
            return true;
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
