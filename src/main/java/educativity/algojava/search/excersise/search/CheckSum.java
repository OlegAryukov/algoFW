package educativity.algojava.search.excersise.search;

import java.util.HashMap;
import java.util.Map;

public class CheckSum {
    public static int[] findSum(int[] arr, int n) {
        int size = arr.length;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        for (int i = 1; i < size; i++) {
            int a = n - arr[i];
            if(map.containsKey(a)){
                result[0] = arr[map.get(a)];
                result[1] = arr[i];
                break;
            }
            map.put(arr[i], i);
        }
        return result; // return the elements in the array whose sum is equal to the value passed as parameter
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,-4,6,7,-8,9};
        CheckSum.findSum(input, 16);
    }
}
