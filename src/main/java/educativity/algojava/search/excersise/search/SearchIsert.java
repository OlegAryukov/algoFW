package educativity.algojava.search.excersise.search;

public class SearchIsert {
    public static int insertPosition(int arr[], int target) {
        int left = 0;
        int rigth = arr.length;
        int mid = arr.length / 2;
        if(arr[arr.length-1] < target){
            return arr.length +1;
        }
        if(arr[0] > target){
            return 0;
        }
        while (mid < rigth && mid > left) {

            if (arr[mid] == target) {
                return mid;
            }
            if((rigth-left)==2){
                for (int i = left; i <= rigth; i++) {
                    if(arr[i] == target){
                        return i;
                    }
                    if(arr[i] < target){
                        continue;
                    }
                    return i;
                }
            }
            if (arr[mid] < target) {
                left = mid;
                mid = (rigth - left) / 2 + left;
            }
            if (arr[mid] > target) {
                rigth = mid;
                mid = (rigth - left) / 2 + left;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchIsert.insertPosition(new int[]{1, 3, 5, 6}, 4));
    }
}
