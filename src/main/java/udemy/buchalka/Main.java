package udemy.buchalka;

import static udemy.buchalka.ThredColor.ANSI_GREEN;
import static udemy.buchalka.ThredColor.ANSI_PURPLE;
import static udemy.buchalka.ThredColor.ANSI_RED;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from maint hread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("==ANOTHER THREAD==");
        anotherThread.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println(ANSI_GREEN+"Hello from anonymos class");
            }
        }.start();
        Thread myRunnable = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Haello form anonymos imple of run()");
                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED+ " AnotherThread terminated");
                }catch (InterruptedException e){
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was Interuppted ");
                }
            }
        });

        myRunnable.start();


        System.out.println(ANSI_PURPLE + "Hello from main thread again");
    }
}
