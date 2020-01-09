package hackerrank.algos;

import java.util.Scanner;

public class AlmostSorted {

    static void almostSorted(int[] arr) {
        boolean end = false;
        int length = arr.length;
        if (length == 1 || length == 0) {
            System.out.println("no");
            end = true;
        }
        if (length == 2) {
            if (arr[0] < arr[1] || arr[0] == arr[1]) {
                System.out.println("no");
                end = true;
            }
            System.out.println("yes");
            System.out.println("swap 1 2");
            end = true;
        }
        if (!end) {
            boolean swapPossible = true;
            int notOrderCount = 0;
            int curr = 0;
            int prevCurr = 0;
            int currInd = 0;
            int nextCurr = 0;
            int secondCurr = 0;
            int secondCurrInd = 0;
            int secondNextCurr = 0;
            int subArrStartInd = 0;
            int subArrEndInd = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    if (notOrderCount >= 2) {
                        swapPossible = false;
                        break;
                    }
                    if (arr[i + 1] > arr[i + 2] && notOrderCount == 0) {
                        int j = i;
                        subArrStartInd = i + 1;
                        while (arr[j] > arr[j + 1]) {
                            j++;
                        }
                        subArrEndInd = j + 1;
                        curr = arr[i];
                        nextCurr = arr[i + 1];
                        i = j;
                        notOrderCount += 2;
                        continue;
                    }
                    if (notOrderCount == 0) {
                        curr = arr[i];
                        if (i != 0) {
                            prevCurr = arr[i - 1];
                        }
                        nextCurr = arr[i + 1];
                        currInd = i;
                        notOrderCount++;
                    } else if (notOrderCount == 1) {
                        secondCurr = arr[i + 1];
                        secondNextCurr = arr[i + 2];
                        secondCurrInd = i + 1;
                        notOrderCount++;
                    }
                }
            }
            if (swapPossible) {
                if (secondCurr < curr && notOrderCount == 2) {
                    if (curr < secondNextCurr && (subArrEndInd - subArrStartInd) == 0) {
                        System.out.println("yes");
                        System.out.println("swap " + (secondCurrInd + 1) + " " + (currInd + 1));
                    } else {
                        System.out.println("yes");
                        System.out.println("reverse " + subArrStartInd + " " + subArrEndInd);
                    }
                } else if (notOrderCount == 1 || notOrderCount == 0) {
                    if (curr > nextCurr && arr[currInd + 1] > prevCurr && notOrderCount == 1 && length > 3) {
                        System.out.println("yes");
                        System.out.println("swap " + (currInd + 1) + " " + (currInd + 2));
                        end = true;
                    }
                    if (!end) {
                        System.out.println("no");
                    }
                }
            }
            if (!swapPossible) {
                System.out.println("no");
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}
