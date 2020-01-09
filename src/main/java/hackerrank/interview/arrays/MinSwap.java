package hackerrank.interview.arrays;

public class MinSwap {
    static int minimumSwaps(int[] arr) {
        int countOfSwap = 0;
        boolean isCount = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int j = i+1;
                while (j != arr.length - 1) {
                    if (arr[j+1] < arr[j]) {
                        int tmp = arr[i];
                        arr[i] = arr[j + 1];
                        arr[j + 1] = tmp;
                        i--;
                        countOfSwap++;
                        isCount = true;
                        break;
                    }
                    j++;
                }
                if(!isCount){
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    countOfSwap++;
                    continue;
                }
            }


//            if (arr[i] > arr[i + 1] && arr[i] > arr[i + 2]) {
//                for (int j = i + 1; j < arr.length - 1; j++) {
//                    if (arr[j + 1] < arr[j]) {
//                        int tmp = arr[i];
//                        arr[i] = arr[j + 1];
//                        arr[j + 1] = tmp;
//                        i--;
//                        countOfSwap++;
//                        break;
//                    }
//                }
//                if (i != -1 && arr[i + 1] < arr[i]) {
//                    int tmp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = tmp;
//                    countOfSwap++;
//                    continue;
//                }
//            } else if (arr[i + 1] < arr[i]) {
//                int tmp = arr[i];
//                arr[i] = arr[i + 1];
//                arr[i + 1] = tmp;
//                countOfSwap++;
//                continue;
//            }
//
        }
        return countOfSwap;
    }

    public static void main(String[] args) {
        int[] input = {7, 1, 3, 2, 4, 5, 6};
        System.out.println(MinSwap.minimumSwaps(input));
    }
}
