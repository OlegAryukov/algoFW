package hyperskill.algo;

import java.util.HashMap;
import java.util.Map;

public class LinearSearch {
    public static int[] searchIndexes(int[] first, int[] second) {
        Map<Integer,Integer> store = new HashMap<>();
        int notFoundIndex = -1;
        int[] res = new int[first.length];
        for(int i = 0; i< first.length; i++){
            if(!store.isEmpty()&&store.containsKey(first[i])){
                res[i] = store.get(first[i]);
                continue;
            }
            for (int j = 0; j< second.length; j++){
                if(second[j]==first[i]){
                    store.put(first[i], j);
                    res[i] = j;
                    break;
                }
                res[i] = notFoundIndex;
            }
        }
       return res;
    }
    public static void main(String[] args) {

    }
}
