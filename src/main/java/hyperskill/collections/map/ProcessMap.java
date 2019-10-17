package hyperskill.collections.map;

import java.util.Arrays;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProcessMap {
    public static NavigableMap<Integer, String> getSubMap(NavigableMap<Integer, String> map){
        if(map.firstKey()%2!=0){
            return map.subMap(map.firstKey(),true, map.firstKey()+4, true).descendingMap();
        }
        return map.subMap(map.lastKey()-4,true, map.lastKey(),true).descendingMap();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]),pair[1]);
        });
        NavigableMap<Integer, String> res = ProcessMap.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
