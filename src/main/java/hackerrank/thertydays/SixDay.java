package hackerrank.thertydays;

import java.util.Scanner;

public class SixDay {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String nextLine = scan.nextLine();
        int countLoop = Integer.parseInt(nextLine);
        while (countLoop!=0){
            String line = scan.nextLine();
            char[] input = line.toCharArray();
            int j = 0;
            int c = Math.round(input.length / 2) + 1;
            char[] out = new char[input.length + 1];
            for (int i = 0; i < input.length; i++) {
                if (i == 0 || i % 2 == 0) {
                    out[j] = input[i];
                    j++;
                } else {
                    out[c] = input[i];
                    c++;
                }
            }
            System.out.println(String.valueOf(out).trim());
            countLoop--;
        }
    }
}
