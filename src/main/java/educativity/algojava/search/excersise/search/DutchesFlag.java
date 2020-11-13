package educativity.algojava.search.excersise.search;

public class DutchesFlag {
    public static void dutchNationalFlag(int[] arr) {
        int j = 0;
        int k = 0;
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[k] = 0;
                k++;
                continue;
            }
            if (arr[i] == 1) {
                c++;
                continue;
            }
            if (arr[i] == 2) {
                j++;
                continue;
            }
        }
        for (int i = k; i < k+c; i++) {
            arr[i] = 1;
        }
        for (int i = k + c; i < k+c+j; i++) {
            arr[i] = 2;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
        DutchesFlag.dutchNationalFlag(new int[]{2, 0, 0, 1, 2, 1});
    }
}
