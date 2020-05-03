package udemy.buchalka.arrayblocking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

import udemy.buchalka.producerConusumer.ThreadColor;

public class Main {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer myProducer = new MyProducer(buffer, ThreadColor.ANSI_GREEN);
        MyConsumer myConsumer = new MyConsumer(buffer, ThreadColor.ANSI_BLUE);
        MyConsumer myConsumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        executorService.execute(myProducer);
        executorService.execute(myConsumer);
        executorService.execute(myConsumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_RED + "Print from callable class");
                return "This is callable";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Somthing went wrong");
        } catch (InterruptedException e) {
            System.out.println("Interappted");
        }
        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interpted");
            }

        }
        System.out.println(color + "AddingEOF and exiting...");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {

        }

    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer){
                if (buffer.isEmpty()) {
                    continue;
                }
                try {
                    if (buffer.peek().equals("EOF")) {
                        System.out.println(color + "exit");
                        break;
                    } else {
                        System.out.println(color + "Removed" + buffer.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
