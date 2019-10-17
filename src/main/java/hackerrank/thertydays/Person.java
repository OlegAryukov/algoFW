package hackerrank.thertydays;

import java.util.Scanner;

public class Person {
    private int age;

    public Person(int initialAge) {
        if (initialAge > 0) {
            this.age = initialAge;
        } else {
            System.out.println("Age is not valid, setting age to 0..");
            this.age = 0;
        }
    }

    public void amIOld() {
        // Write code determining if this person's age is old and print the correct statement:
        String result;
        if (age < 13) {
            result = "You are young..";
        } else if(age>=13 && age <= 18){
            result = "You are a teenager..";
        } else {
            result = "You are old..";
        }
        System.out.println(result);
    }

    public void yearPasses() {
        age = age + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int age = sc.nextInt();
            Person p = new Person(age);
            p.amIOld();
            for (int j = 0; j < 3; j++) {
                p.yearPasses();
            }
            p.amIOld();
            System.out.println();
        }
        sc.close();
    }
}
