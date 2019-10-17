package leetcode.explore.recursion;

public class ReversString {


    public void reverseString(char[] s) {
        if (s.length == 0) {
            System.out.println("");
        } else {

            if (s.length == 1) {
                System.out.println(s[0]);
            } else {
                int mid = s.length % 2 > 0 ? ((s.length - 1) / 2) + 1 : s.length / 2;
                if (s.length > 2) {
                    for (int i = 0; i < mid; i++) {
                        char tmp = s[i];
                        s[i] = s[s.length - 1 - i];
                        s[s.length - 1 - i] = tmp;

                    }
                } else {
                    char tmp = s[0];
                    s[0] = s[1];
                    s[1] = tmp;
                }
            }
        }
    }

}
