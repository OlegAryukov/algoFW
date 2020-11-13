package educativity.algojava.search.excersise.dynamic;

import java.util.HashMap;
import java.util.Map;

public class ShortestCommonSubstring {
    public static int findSCSLength(String str1, String str2)
    {
        Map<Character, Boolean> map = new HashMap<>();

        for (Character character : str1.toCharArray()){
            if(map.containsKey(character)){
                continue;
            }
            map.put(character, true);
        }

        for (Character character : str2.toCharArray()){
            if(map.containsKey(character)){
                continue;
            }
            map.put(character,true);
        }
        // write your code here
        return map.entrySet().size();
    }

    public static void main(String[] args) {
        System.out.println(ShortestCommonSubstring.findSCSLength("www.educative.io/explore", "educative.io/edpresso"));
    }
}
