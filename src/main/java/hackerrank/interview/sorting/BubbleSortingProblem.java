package hackerrank.interview.sorting;

public class BubbleSortingProblem {
    static void countSwaps(int[] a) {
        int countOfSwap = 0;
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length; i++) {
                if(a[i] > a[i+1]){
                    int tmp = a[i+1];
                    a[i+1] = a[i];
                    a[i] = tmp;
                    countOfSwap++;
                }
            }
        }
        System.out.println("Array is sorted in " + countOfSwap + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length-1]);
    }
}
