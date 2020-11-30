package yandex.kontest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = r.readLine().trim().toCharArray();
        char[] str2 = r.readLine().trim().toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        int res = 1;
        if(str1.length==0 || str2.length==0){
            res = 0;
        }
        if(str1.length!=str2.length){
            res = 0;
        } else {
            for (int i = 0; i < str1.length; i++) {
                if(str1[i]!=str2[i]){
                    res = 0;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
