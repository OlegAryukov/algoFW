package udemy.buchalka.concurrencyChalange;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Challenge8 {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Tutor tutor = new Tutor(lock);
        Student student = new Student(tutor,lock);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                tutor.studyTime();
            }
        });

        Thread studentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                student.handInAssignment();
            }
        });

        tutorThread.start();
        studentThread.start();
    }
}

class Tutor {
    private Student student;
    private Lock lock;

    public Tutor(Lock lock) {
        this.lock = lock;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void studyTime() {
        System.out.println("Tutor has arrived");
        try {
            Thread.sleep(300);
            if(lock.tryLock(300, TimeUnit.MILLISECONDS)){
                student.startStudy();
            } else {
                System.out.println("Student is busy");
            }
            // wait for student to arrive and hand in assignment
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
        System.out.println("Tutor is studying with student");
    }

    public void getProgressReport() {
        try {
            if(lock.tryLock(300,TimeUnit.MILLISECONDS)){
                System.out.println("Tutor gave progress report");
            } else {
                System.out.println("Tutor is busy");
            }
        } catch (InterruptedException e){

        } finally {
            lock.unlock();
        }
        // get progress report
    }
}

class Student {

    private Tutor tutor;
    private Lock lock;

    Student(Tutor tutor,Lock lock) {
        this.tutor = tutor;
        this.lock = lock;
    }

    public void startStudy() {
        // study
        try {
            if(lock.tryLock(300, TimeUnit.MILLISECONDS)){
                System.out.println("Student is studying");
            } else {
                System.out.println("Student is busy");
            }
        } catch (InterruptedException e){

        } finally {
            lock.unlock();
        }
    }

    public void handInAssignment() {
        tutor.getProgressReport();
        System.out.println("Student handed in assignment");
    }
}

