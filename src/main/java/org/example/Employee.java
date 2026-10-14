
package org.example;

public class Employee {
    int id;
    String name;
    String department;
    double salary;
    int attendanceDays;

    public Employee(int id, String name, String department,
                    double salary, int attendanceDays) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.attendanceDays = attendanceDays;
    }
}
