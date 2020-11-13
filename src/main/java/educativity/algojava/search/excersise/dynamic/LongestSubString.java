package educativity.algojava.search.excersise.dynamic;

public class LongestSubString {
    public static int LCSLength(String s1, String s2) {
        int[][] map = new int[s1.length()][s2.length()];
        int max = 0;
        int resI = 0;
        int resJ = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (i > 0 && j > 0) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        map[i][j] = map[i - 1][j - 1] + 1;
                        if(map[i][j] > max){
                            max = map[i][j];
                            resI = i;
                            resJ = j;
                        }
                        continue;
                    }
                    map[i][j] = 0;
                } else {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        map[i][j] = 1;
                        continue;
                    }
                    map[i][j] = 0;
                }
            }
        }
        return map[resI][resJ];
    }

    public static void main(String[] args) {
        String str1 = "www.educative.io/explore";
        String str2 = "educative.io/edpresso";
        System.out.println(LongestSubString.LCSLength(str1, str2));
    }
}
