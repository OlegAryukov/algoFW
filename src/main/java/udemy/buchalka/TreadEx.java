package udemy.buchalka;

public class TreadEx {
    public static void main(String[] args) {
        System.out.println("Hello from the main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        new Thread() {
            public void run(){
                System.out.println("anonymous class");
            }
        }.start();

        Thread myRunnableThrea = new Thread(new MyRunnable());
        myRunnableThrea.start();
        System.out.println("Hello again");
    }
}
