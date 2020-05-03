package udemy.buchalka.lymbda.employee;

import java.util.ArrayList;
import java.util.List;

import udemy.buchalka.lymbda.employee.Employee;

public class Main {
    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red RidiginHood", 31);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        employees.stream().filter(employee -> employee.getAge() > 30).forEach(employee -> {
            System.out.println(employee.getName());
        });
    }
}
