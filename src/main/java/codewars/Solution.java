package codewars;

import java.util.StringTokenizer;

public class Solution {

    public static String camelCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer streamTokenizer = new StringTokenizer(str);
        while (streamTokenizer.hasMoreTokens()) {
            String nexToken = streamTokenizer.nextToken();
            String firstChar = nexToken.substring(0, 1);
            String otherString = nexToken.substring(1);
            stringBuilder.append(firstChar.toUpperCase()).append(otherString);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(Solution.camelCase("test case"));
    }

}

