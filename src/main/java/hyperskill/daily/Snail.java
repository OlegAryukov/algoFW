package hyperskill.daily;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Snail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int days = (h-a)%(a-b)==0 ? (h-a)/(a-b)+1 : (h-a)/(a-b)+2;
        if((a-b)>=h){
            days = 1;
        }
        System.out.println(days);
    }
}
