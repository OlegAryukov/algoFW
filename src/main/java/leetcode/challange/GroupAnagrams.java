package leetcode.challange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(resMap.containsKey(key)){
                resMap.get(key).add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                resMap.put(key, list);
            }
        }
       return resMap.entrySet().stream().map(integerListEntry -> integerListEntry.getValue()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"eat","tea","tan","ate","nat","bat"};
        String[] strings1 = new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        GroupAnagrams.groupAnagrams(strings);
    }
}
