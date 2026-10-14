
package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeManager {

    ArrayList<Employee> employees = new ArrayList<>();
    HashMap<Integer, Employee> employeeMap = new HashMap<>();

    public void addEmployee(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        int id = Integer.parseInt(sc.nextLine());

        if (employeeMap.containsKey(id)) {
            System.out.println("Employee ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        System.out.print("Enter Attendance Days (out of 30): ");
        int attendanceDays = Integer.parseInt(sc.nextLine());

        if (salary < 0 || attendanceDays < 0 || attendanceDays > 30) {
            System.out.println("Invalid salary or attendance!");
            return;
        }

        Employee emp = new Employee(
                id, name, department, salary, attendanceDays
        );

        employees.add(emp);
        employeeMap.put(id, emp);

        System.out.println("Employee added successfully!");
    }

    public void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee emp : employees) {
            System.out.println(
                    "ID: " + emp.id
                            + " | Name: " + emp.name
                            + " | Department: " + emp.department
                            + " | Salary: " + emp.salary
                            + " | Attendance: " + emp.attendanceDays + "/30"
            );
        }
    }

    public void runAnalytics() {
        if (employees.isEmpty()) {
            System.out.println("No employee data available.");
            return;
        }

        double totalSalary = 0;
        Employee highest = employees.get(0);
        Employee lowest = employees.get(0);

        for (Employee emp : employees) {
            totalSalary += emp.salary;

            if (emp.salary > highest.salary) {
                highest = emp;
            }

            if (emp.salary < lowest.salary) {
                lowest = emp;
            }
        }

        System.out.printf(
                "Average Salary: %.2f%n",
                totalSalary / employees.size()
        );

        System.out.println(
                "Highest Salary: " + highest.name
                        + " (Rs. " + highest.salary + ")"
        );

        System.out.println(
                "Lowest Salary: " + lowest.name
                        + " (Rs. " + lowest.salary + ")"
        );
    }

    public void showLowAttendance() {
        boolean found = false;

        for (Employee emp : employees) {
            double percentage = emp.attendanceDays / 30.0 * 100;

            if (percentage < 80) {
                System.out.printf(
                        "%s (ID: %d) - Attendance: %.2f%%%n",
                        emp.name, emp.id, percentage
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No low-attendance employees found.");
        }
    }

    public void searchEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to search: ");
        int id = Integer.parseInt(sc.nextLine());

        Employee emp = employeeMap.get(id);

        if (emp == null) {
            System.out.println("Employee not found.");
        } else {
            System.out.println("ID: " + emp.id);
            System.out.println("Name: " + emp.name);
            System.out.println("Department: " + emp.department);
            System.out.println("Salary: Rs. " + emp.salary);
            System.out.println("Attendance: " + emp.attendanceDays + "/30");
        }
    }
}
