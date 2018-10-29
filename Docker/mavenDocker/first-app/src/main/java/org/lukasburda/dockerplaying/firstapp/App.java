package org.lukasburda.dockerplaying.firstapp;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee("Foo", 35));
        employees.add(new Employee("Bar", 28));
        employees.add(new Employee("Octocat", 32));

        for (Employee employee : employees) {
            System.out.println(employee.toString() + "\n");
        }
    }
}