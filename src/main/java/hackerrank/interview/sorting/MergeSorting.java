package hackerrank.interview.sorting;

public class MergeSorting {

    static long countInversions(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length-1);
        return 0;
    }

    static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {

        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(arr, temp, leftStart, middle);
        mergeSort(arr, temp, middle + 1, rightEnd);
        mergeHalves(arr, temp, leftStart, rightEnd);
    }

    public static void mergeHalves(int[] array, int[] tmp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                tmp[index] = array[left];
                left++;
            } else {
                tmp[index] = array[right];
            }
            index++;
        }
        System.arraycopy(array, left, tmp, index, leftEnd - left + 1);
        System.arraycopy(array, right, tmp, index, rightEnd - right + 1);
        System.arraycopy(tmp, leftStart, array, leftStart, size);
    }

    public static void main(String[] args) {
        MergeSorting.countInversions(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5});
    }
}
