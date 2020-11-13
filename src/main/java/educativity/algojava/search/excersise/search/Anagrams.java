package educativity.algojava.search.excersise.search;

import java.util.*;

public class Anagrams {
    public static String groupAnagrams(String arr[]) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> keys = new ArrayList<>();
        int arrSize = arr.length;
        String res = "";
        for (int i = 0; i < arrSize; i++) {
            char[] chars = arr[i].trim().toLowerCase().replace(" ", "").toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                map.get(key).add(arr[i]);
                if (!keys.contains(key)) {
                    keys.add(key);
                }
                continue;
            }
            List<String> strings = new ArrayList<>();
            strings.add(arr[i]);
            map.put(key, strings);
        }
        for (String key : keys) {
            List<String> strings = map.get(key);
            String str = "[";
            for (int i = 0; i < strings.size(); i++) {
                str = str.concat(strings.get(i));
                if(i==strings.size()-1){
                    str = str.concat("]");
                } else {
                    str = str.concat(", ");
                }
            }
            res = res.concat(str);
        }
        String anagrams = "None";
        return res == null ? anagrams : res;
    }

    public static void main(String[] args) {
        String[] src = new String[]{"cat", "dog", "tac", "god", "act",  "tom marvolo riddle ","abc", "def",  "cab", "fed", "clint eastwood ", "i am lord voldemort", "elvis", "old west action",  "lives" };

        System.out.println(Anagrams.groupAnagrams(src));
    }
}
