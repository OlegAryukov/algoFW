package udemy.buchalka.concurrencyChalange;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class MyBankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock;

    public MyBankAccount(String accountNumber, double initialBalance, Lock lock) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = lock;
    }

    public void deposit(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Transaction statuc is: " +status );
    }

    public void withdraw(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Transaction status is : " + status);
    }

    public void getBalance() {
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println(balance);
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
