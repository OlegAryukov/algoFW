package hackerrank.thertydays;

import java.util.Scanner;

public class SecondDay {

    public static void main(String[] args) {
        int i;
        double d;
        String s;

        Scanner scan = new Scanner(System.in);
        String nextLine = scan.nextLine();
        i = Integer.parseInt(nextLine);
        nextLine = scan.nextLine();
        d = Double.parseDouble(nextLine);
        s = scan.nextLine();
        scan.close();

        System.out.println(i);
        System.out.println(d);
        System.out.println("HackerRank " + s);
    }

}
