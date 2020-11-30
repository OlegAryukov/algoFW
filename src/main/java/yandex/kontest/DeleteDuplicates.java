package yandex.kontest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeleteDuplicates {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        if (n != 0) {
            int prev = Integer.parseInt(r.readLine());
            n--;
            System.out.println(prev);
            while (n > 0) {
                int tmp = Integer.parseInt(r.readLine());
                if (prev == tmp) {
                    continue;
                }
                System.out.println(tmp);
                prev = tmp;
            }
        }
    }
}
