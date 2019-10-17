package carreer.parts.ix;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class StringsQuest {

//    public boolean isPalindrom(String str){
//
//    }

    boolean isValid(String str) {
        if (str.length() > 128) {
            return false;
        }
        HashSet<Character> set = new HashSet<Character>();

        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        if (str.length() == set.size() || str.length() - 1 == set.size()) {
            return true;
        } else if (str.length() % 2 == 0 && str.length() / 2 == set.size()) {
            return true;
        } else if ((str.length() - 1) % 2 == 0 && (str.length() - 1) / 2 == set.size()) {
            return true;
        }

        return false;
    }

    boolean isValidSecond(String str) {
        if (str.length() > 100000) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(str.length());
        int countOnce = 0;
        int countPair = 0;
        int countTherd = 0;
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int val = map.get(str.charAt(i));
                if (val >= 2) {
                    countTherd++;
                }
                map.put(str.charAt(i), val + 1);
                if (val == 1) {
                    countPair++;
                }
            } else {
                map.put(str.charAt(i), 1);
                countOnce++;
            }
        }
        Set<Character> keySet = map.keySet();
        Collection<Integer> valueSet = map.values();
        valueSet.stream().count();


        if (countTherd > 3) {
            return false;
        }

        if ((countOnce == 1 || countPair == 1) && countTherd == 0) {
            return true;
        }
        if (countTherd == 1 && countPair % countOnce == 0) {
            return true;
        }
        return false;
    }

    public String shortString(String str) {
        HashMap<Character, Integer> resultMap = new HashMap<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            if (resultMap.containsKey(str.charAt(i))) {
                int val = resultMap.get(str.charAt(i)) + 1;
                resultMap.put(str.charAt(i), val);
            } else {
                resultMap.put(str.charAt(i), 1);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : resultMap.entrySet()) {
            if (entry.getValue() > 1) {
                builder.append(entry.getKey());
                builder.append(entry.getValue());
            } else {
                builder.append(entry.getKey());
            }
        }
        return builder.toString();
    }

    public String anotherShort(String str) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder builder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(str.charAt(i));
            } else {
                if (stack.peek() == str.charAt(i)) {
                    count++;
                } else {
                    stack.push(Character.forDigit(count, 10));
                    count = 1;
                    stack.push(str.charAt(i));
                }
            }
        }
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        StringsQuest stringsQuest = new StringsQuest();
        System.out.println(stringsQuest.shortString("aabcccccaaa"));
        System.out.println(stringsQuest.anotherShort("aabcccccaaa"));
        System.out.println(stringsQuest.isValidSecond("abcdefghhgfedecba"));
    }
}
