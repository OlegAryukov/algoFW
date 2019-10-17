package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class WeightSort {
    public static String orderWeight(String strng) {
        String[] src = strng.split(" ");

        ArrayList<Pair> res = new ArrayList<>();
        Arrays.stream(src).forEach(
                s -> {
                    char[] chr = s.toCharArray();
                    int num = 0;
                    for (int i = 0; i < chr.length; i++) {
                        num = num + Integer.valueOf(String.valueOf(chr[i]));
                    }
                    res.add(new Pair(s, num));
                }
        );

        StringBuilder stb = new StringBuilder();
        res.stream()
                .sorted(innerComporatot)
                .map(stringIntegerPair -> stringIntegerPair.getKey())
                .forEach(s -> {
                    stb.append(s);
                    stb.append(" ");
                });
        return stb.toString().trim();


    }
    public static class Pair{
        String key;
        Integer value;

        public Pair(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }

    public static Comparator<Pair> innerComporatot = new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            if(o1.getValue() > o2.getValue()){
                return 1;
            } else if(o1.getValue() < o2.getValue()){
                return -1;
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        }
    };
    public static void main(String[] args) {
        System.out.println(WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }
}
