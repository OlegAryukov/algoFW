package udemy.buchalka.producerConusumer;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer myProducer = new MyProducer(buffer, ThreadColor.ANSI_GREEN, bufferLock);
        MyConsumer myConsumer = new MyConsumer(buffer, ThreadColor.ANSI_BLUE, bufferLock);
        MyConsumer myConsumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

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
        } catch (ExecutionException e){
            System.out.println("Somthing went wrong");
        } catch (InterruptedException e){
            System.out.println("Interappted");
        }
        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interpted");
            }

        }
        System.out.println(color + "AddingEOF and exiting...");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {

            bufferLock.unlock();
        }

    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            if (bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "The counter = " + counter);
                    counter = 0;
                    if (buffer.get(0).equals("EOF")) {
                        System.out.println(color + "exit");
                        break;
                    } else {
                        System.out.println(color + "Removed" + buffer.remove(0));
                    }
                } finally {
                    if (bufferLock.isLocked()) {
                        bufferLock.unlock();
                    }
                }
            } else {
                counter++;
            }
        }
    }
}
