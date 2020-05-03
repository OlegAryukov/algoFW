package hackerrank.interview.arrays;

public class MinSwap {
    static int minimumSwaps(int[] arr) {
        int length = arr.length;
        int countOfSwap = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0 && (arr[j] < arr[j - 1]); j--) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                countOfSwap++;
            }
        }
        return countOfSwap;
    }


    public static void main(String[] args) {
        int[] input = {7, 1, 3, 2, 4, 5, 6};
        int[] inputT1 = {2, 3, 4, 1, 5};
        int[] inputT2 = {1, 3, 5, 2, 4, 6, 7};
        int[] inputT3 = {4, 3, 1, 2};
//        System.out.println(MinSwap.minimumSwaps(input));
//        System.out.println(MinSwap.minimumSwaps(inputT1));
//        System.out.println(MinSwap.minimumSwaps(inputT2));
//        System.out.println(MinSwap.minimumSwaps(inputT3));

//        System.out.println("Shell " + MinSwap.minimumSwapShell(inputT1));
//        System.out.println("Shell " + MinSwap.minimumSwapShell(inputT2));
//        System.out.println("Shell " + MinSwap.minimumSwapShell(inputT3));
    }
}
