package udemy.buchalka.concurrencyChalange;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        MyBankAccount myBankAccount = new MyBankAccount("12345-678", 1000, lock);
        Thread t1 = new Thread(() -> {
            try {
                //lock.lock();
                myBankAccount.deposit(300);
                System.out.println("first is deposit : " + 300);
                myBankAccount.withdraw(50);
                System.out.println("first is withdraw : " + 50);
            } finally {
                myBankAccount.getBalance();
                //lock.unlock();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                //lock.lock();
                myBankAccount.deposit(203.75);
                System.out.println("second is deposit : " + 203.75);
                myBankAccount.withdraw(100);
                System.out.println("second is withdraw : " + 100);
            } finally {
                myBankAccount.getBalance();
                //lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }
}
