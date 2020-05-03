package udemy.buchalka.lymbda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        //new Thread(() -> System.out.println("Printing from runnable")).start();

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

//        Collections.sort(employees, new Comparator<Employee>() {
////            @Override
////            public int compare(Employee o1, Employee o2) {
////                return o1.getName().compareTo(o2.getName());
////            }
////        });
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
        System.out.println(doString(uc, employees.get(0).getName(), employees.get(1).getName()));
    }

    public final static String doString(UpperConcat uc,String s1,String s2){
        return  uc.upperConcat(s1, s2);
    }
}

interface UpperConcat {
    String upperConcat(String s1, String s2);
}


class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
