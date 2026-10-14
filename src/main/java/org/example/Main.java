
package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        int choice = 0;

        do {
            System.out.println("\n===== EMPLOYEE ANALYTICS SYSTEM =====");
            System.out.println("1. Add New Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Run Analytics");
            System.out.println("4. Show Low Attendance Warning List");
            System.out.println("5. Search Employee by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    manager.addEmployee(sc);
                    break;

                case 2:
                    manager.viewAllEmployees();
                    break;

                case 3:
                    manager.runAnalytics();
                    break;

                case 4:
                    manager.showLowAttendance();
                    break;

                case 5:
                    manager.searchEmployee(sc);
                    break;

                case 6:
                    System.out.println("Thank you for using Employee Analytics!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
