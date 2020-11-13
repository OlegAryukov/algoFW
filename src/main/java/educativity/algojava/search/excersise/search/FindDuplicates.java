package educativity.algojava.search.excersise.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindDuplicates {
    public static ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> duplicates = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                if(map.get(arr[i]) == 1){
                    duplicates.add(arr[i]);
                }
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        return duplicates;
    }
}
