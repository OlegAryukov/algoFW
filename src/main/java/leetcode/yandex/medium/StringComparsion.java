package leetcode.yandex.medium;

import java.util.HashMap;
import java.util.Map;

public class StringComparsion {
    public static int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }
        if (chars.length == 2) {
            if(chars[0] == chars[1]){
                chars[1] = Integer.toString(2).charAt(0);
            }
            return 2;
        }
        int position = 1;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
                continue;
            }
            if (count > 1) {
                char[] countInChars = Integer.toString(count).toCharArray();
                if (countInChars.length > 1) {
                    for (int j = 0; j < countInChars.length; j++) {
                        chars[position] = countInChars[j];
                        position++;
                    }
                } else if (countInChars.length == 1) {
                    chars[position] = countInChars[0];
                    position++;
                }
                chars[position] = chars[i];
                position++;
                count = 1;
                continue;
            }
            chars[position] = chars[i];
            position++;
        }
        if (count > 1) {
            char[] countInChars = Integer.toString(count).toCharArray();
            if (countInChars.length > 1) {
                for (int j = 0; j < countInChars.length; j++) {
                    chars[position] = countInChars[j];
                    position++;
                }
            } else if (countInChars.length == 1) {
                chars[position] = countInChars[0];
                position++;
            }
            if(position != chars.length){
                chars[position] = chars[chars.length - 1];
            }
        }

        for (int i = 0; i < position; i++) {
            System.out.print(chars[i] + " : ");
        }
        return position++;

//        Map<Character, Integer> map = new HashMap<>();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < chars.length; i++) {
//            if(map.containsKey(chars[i])){
//                map.put(chars[i], map.get(chars[i])+1);
//                continue;
//            }
//            map.put(chars[i], 1);
//        }
//        int res = 0;
//        for(Map.Entry<Character, Integer> entry : map.entrySet()){
//            res++;
//            if(entry.getValue()>1){
//                res++;
//            }
//        }
//        return res;
    }

    public int compress2(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public static void main(String[] args) {
//        char[] input = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//        char[] input = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        char[] input = new char[]{'a', 'a', 'b', 'b'};
        System.out.println(StringComparsion.compress(input));
    }
}
