package educativity.algojava.search;

public class BinarySearch {
    static int binarySearch(int arr[], int left, int right, int n) {

        int leftBorder = 0;
        int rightBorder = arr.length-1;
        int mid = (rightBorder - leftBorder) / 2;
        while (leftBorder<=rightBorder) {
            if (n < arr[mid]) {
                rightBorder = mid;
                mid = (mid - leftBorder)/2;
                continue;
            }
            if(n > arr[mid]){
                leftBorder = mid;
                mid = (rightBorder - mid)/2;
                continue;
            }
            return mid;
        }
        return -1;
    }



    // Driver code to test the function
    public static void main(String args[]) {
        int arr[] = {7, 8, 9, 0, 3, 5, 6};
        int arrSize = 10;
        int key = 1;
        int index = binarySearch( arr, 0, 6, 3);
        Helper obj = new Helper();
        obj.printArray(arr, arrSize);
        if (index != -1)
            System.out.println("Your Key \"" + key + "\" is found at index \"" + index + "\"");
        else
            System.out.println("Your Key \"" + key + "\" not found in the array: ");

    }
}
