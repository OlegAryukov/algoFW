package hyperskill.daily;

import java.util.Scanner;

/**
 * Implement a method that returns a letter in the UNICODE table after the '\' character at the distance of the value shift.
 */
public class UnicodeLetter {
    public static char charExpression(int shift) {
        char start = '\\';
        int startVal = start;
        startVal+=shift;
        return (char)startVal; // wrong implementation
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int charA = scanner.nextInt();
        System.out.println(charExpression(charA));
    }
}
