package leetcode.problems.medium.slidingwindows;

import java.util.*;

public class FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        if (sLength < pLength) {
            return res;
        }
        int sumOfChars = 0;
        for (int i = 0; i < pChars.length; i++) {
            sumOfChars += pChars[i];
        }
        int firstSum = 0;
        for (int i = 0; i < pChars.length; i++) {
            firstSum += sChars[i];
        }
        if (sumOfChars == firstSum) {
            int count = 0;
            for (int j = 0; j < pLength; j++) {
                if (p.indexOf(sChars[j]) != -1) {
                    count++;
                    continue;
                }
                break;
            }
            if (count == pLength) {
                res.add(0);
            }
        }
        for (int i = pLength; i < sLength; i++) {
            firstSum = firstSum + sChars[i] - sChars[i - pLength];
            if (sumOfChars == firstSum) {
                int count = 0;
                for (int j = i - pLength + 1; j < i + 1; j++) {
                    if (p.indexOf(sChars[j]) != -1) {
                        count++;
                        continue;
                    }
                    break;
                }
                if (count == pLength) {
                    res.add(i - pLength + 1);
                }
            }
        }
        return res;
    }

    public static List<Integer> findAnagramsSecondEdition(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> mapSrc = new HashMap<>();
        Map<Character, Integer> mapWind = new HashMap<>();
        if (s.length() < p.length()) {
            return res;
        }
        for (int i = 0; i < p.length(); i++) {
            if (!mapSrc.containsKey(p.charAt(i))) {
                mapSrc.put(p.charAt(i), 1);
            } else {
                mapSrc.put(p.charAt(i), mapSrc.get(p.charAt(i)) + 1);
            }

            if (!mapWind.containsKey(s.charAt(i))) {
                mapWind.put(s.charAt(i), 1);
            } else {
                mapWind.put(s.charAt(i), mapWind.get(s.charAt(i)) + 1);
            }
        }
        if(checkEquals(mapSrc, mapWind)){
            res.add(0);
        }

            for (int i = p.length(); i < s.length(); i++) {
                char prev = s.charAt(i - p.length());
                char next = s.charAt(i);
                if(mapWind.get(prev)==1){
                    mapWind.remove(prev);
                } else {
                    mapWind.put(prev, mapWind.get(prev)-1);
                }
                if(mapWind.containsKey(next)){
                    mapWind.put(next, mapWind.get(next)+1);
                } else {
                    mapWind.put(next, 1);
                }
                if(checkEquals(mapSrc, mapWind)){
                    res.add(i-p.length()+1);
                }
            }
        return res;
    }

    public static boolean checkEquals(Map<Character, Integer> src, Map<Character, Integer> wind){
        boolean res = true;
        for (Map.Entry entry : src.entrySet()){
            if(!wind.containsKey(entry.getKey())){
                return false;
            }
            if(!entry.getValue().equals(wind.get(entry.getKey()))){
                return false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (Integer res : FindAllAnagrams.findAnagramsSecondEdition("cbaebabacd", "abc")) {
            System.out.println(res);
        }
    }
}
