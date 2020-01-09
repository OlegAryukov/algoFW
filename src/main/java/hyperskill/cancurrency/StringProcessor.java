package hyperskill.cancurrency;

import java.util.Scanner;

public class StringProcessor extends Thread {
    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        boolean isFinish = false;
        while (!isFinish){
            String str = scanner.nextLine();
            String b = new String(str);
            b.toUpperCase();
            if(str.compareTo(b)!=0){
                System.out.println(b);
                continue;
            }
            isFinish = true;
        }
        System.out.println("FINISHED");
    }
}
