import java.util.Scanner;

public class Tests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int counter = 0;
        boolean stopped = true;
        while (counter <= n) {
            for (int i = 1; (i < n) && stopped; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" " + i);
                    counter++;
                    if (counter == n) {
                        stopped = false;
                        break;
                    }
                }
            }
        }
        scanner.close();
    }
}
