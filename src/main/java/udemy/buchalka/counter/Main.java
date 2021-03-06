package udemy.buchalka.counter;

public class Main {
    public static void main(String[] args) {
        Countdown countdown1 = new Countdown();
        //Countdown countdown2 = new Countdown();

        CountDownThread t1 = new CountDownThread(countdown1);
        t1.setName("Thread 1");
        CountDownThread t2 = new CountDownThread(countdown1);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

class Countdown{
    public void doCountDown(){
        String color;
        switch (Thread.currentThread().getName()){
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        synchronized (color){
            for (int i = 10; i > 0 ; i--) {
                System.out.println(color + Thread.currentThread().getName() +" : i=" + i);
            }
        }
    }
}

class CountDownThread extends Thread {
    private  Countdown countdown;
    public CountDownThread(Countdown countdown){
        this.countdown = countdown;
    }

    @Override
    public void run() {
        countdown.doCountDown();
    }
}
