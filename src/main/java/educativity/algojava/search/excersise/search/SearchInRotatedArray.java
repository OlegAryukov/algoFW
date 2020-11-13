package educativity.algojava.search.excersise.search;

import java.util.Random;

public class SearchInRotatedArray {
    private Integer res = null;
    public static int choosePivot(int left, int right) {
        Random rand = new Random();
        // Pick 3 random numbers within the range of the array
        int i1 = left + (rand.nextInt(right - left + 1));
        int i2 = left + (rand.nextInt(right - left + 1));
        int i3 = left + (rand.nextInt(right - left + 1));

        // Return their median
        return Math.max(Math.min(i1, i2), Math.min(Math.max(i1, i2), i3));
    }

    public static int partition(int arr[], int left, int right, int k) {
        int pivotInd = choosePivot(left, right); // Index of pivot
        //obj.swap(arr, right, pivotInd);// self created function to swap two indices of an array
        int temp = arr[right];
        arr[right] = arr[pivotInd];
        arr[pivotInd] = temp;
        int pivot = arr[right]; // Pivot
        int i = (left - 1); // All the elements less than or equal to the
        // pivot go before or at i

        for (int j = left; j <= right - 1; j++) {
            if (arr[j] <= pivot) {
                i++; // increment the index
                //obj.swap(arr, i, j);
                int tempF = arr[i];
                arr[i] = arr[j];
                arr[j] = tempF;
            }
        }
       // obj.swap(arr, i + 1, right); // Putting the pivot back in place
        int tempFf = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = tempFf;
        return (i + 1);
    }

    public static void quickSort(int arr[], int left, int right, int k) {
        if (left < right) {
            // pi is where the pivot is at
            int pi = partition(arr, left, right, k);

            // Separately sort elements before and after partition
            quickSort(arr, left, pi - 1, k);
            quickSort(arr, pi + 1, right, k);
        }
    }
}
