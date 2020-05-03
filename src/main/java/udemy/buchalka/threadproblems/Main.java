package udemy.buchalka.threadproblems;

import udemy.buchalka.producerConusumer.ThreadColor;

public class Main {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1){
                System.out.println("Thread 1: Has lock1");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println(e.toString());
                }
                    System.out.println("Thread 1 is waiting for lock2");
                    synchronized (lock2){
                        System.out.println("Thread 1: Has lock1 and lock2");
                    }
                System.out.println("Thread 1: Released lock1. Exiting...");
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock1){
                System.out.println("Thread 2:Has lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e){

                }
                System.out.println("Thread 2:Waiting for lock2");
                synchronized (lock2){
                    System.out.println("Thread 2: Has lock2 and lock1");
                }
                System.out.println("Thread 2: released lock2");
            }
            System.out.println("Thread 2: Released lock1. Exiting");
        }
    }

}
