package org.home.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ReportingService {

    public static void main(String...args) {
        List<Employee> employeeList = getEmployeeList();
        Map<String, List<Employee>> values = new HashMap<>();

        for (Employee employee : employeeList) {
            List<Employee> employeesOfDepartment = null;
            if(values.containsKey(employee.getDepartment())) {
                employeesOfDepartment = values.get(employee.getDepartment());
            } else {
                employeesOfDepartment = new ArrayList<>();
            }
            employeesOfDepartment.add(employee);
            values.put(employee.getDepartment(), employeesOfDepartment);
        }

        for (Map.Entry entrySet : values.entrySet()) {
            List<Employee> employeesOfDepartment = values.get(entrySet.getKey());
            Collections.sort(employeesOfDepartment, new Comparator<Employee>() {
                @Override public int compare(Employee o1, Employee o2) {
                    return Long.compare(o2.getSalary(), o1.getSalary());
                }
            });

            System.out.println();
            System.out.println("For Department - " + entrySet.getKey());
            System.out.println("List of Employees");
            System.out.println(employeesOfDepartment);
        }

    }

    public static List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(UUID.randomUUID().toString(), "Alex", "Technology", 10000l));
        employees.add(new Employee(UUID.randomUUID().toString(), "Amit", "Technology", 8000l));
        employees.add(new Employee(UUID.randomUUID().toString(), "Sumit", "Technology", 9000l));
        employees.add(new Employee(UUID.randomUUID().toString(), "Roy", "Finance", 9000l));
        employees.add(new Employee(UUID.randomUUID().toString(), "Sam", "Finance", 12000l));
        employees.add(new Employee(UUID.randomUUID().toString(), "Arun", "Finance", 11000l));
        employees.add(new Employee(UUID.randomUUID().toString(), "Aruz", "Distribution", 9000l));
        employees.add(new Employee(UUID.randomUUID().toString(), "Aruy", "Distribution", 7000l));
        return employees;
    }

}
