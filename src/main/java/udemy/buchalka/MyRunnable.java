package udemy.buchalka;

import static udemy.buchalka.ThredColor.ANSI_RED;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Runnable HELLO");
    }
}
