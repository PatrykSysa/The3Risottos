package runner;

import employees.EmployeeQueryRunner;
import logging.LoggerConfig;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;

public class Runner {


    public static void run() {
        LoggerConfig.setLevelForConsole(Level.OFF);
        EmployeeQueryRunner queryRunner = new EmployeeQueryRunner();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Employee Search App!");

        boolean replay = true;

        while (replay) {
            System.out.println("Which method would you like to call?");
            System.out.println("1. Get All Employees");
            System.out.println("2. Get Employee By ID");
            System.out.println("3. Get Employee By Last Name");
            System.out.println("4. Get Employee By Hired Date Range");
            System.out.println("5. Get Employee By Age Range");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    queryRunner.getAll();
                    break;
                case 2:
                    System.out.println("Enter employee id:");
                    int employeeId = scanner.nextInt();
                    queryRunner.getById(employeeId);
                    break;
                case 3:
                    System.out.println("Enter partial last name:");
                    String lastNamePartial = scanner.nextLine();
                    queryRunner.getByLastNamePartial(lastNamePartial);
                    break;
                case 4:
                    System.out.println("Enter start date (YYYY-MM-DD):");
                    String startDateStr = scanner.nextLine();
                    LocalDate startDate = LocalDate.parse(startDateStr);
                    System.out.println("Enter end date (YYYY-MM-DD):");
                    String endDateStr = scanner.nextLine();
                    LocalDate endDate = LocalDate.parse(endDateStr);
                    queryRunner.getByHiredDateRange(startDate, endDate);
                    break;
                case 5:
                    System.out.println("Enter lower age:");
                    int lowerAge = scanner.nextInt();
                    System.out.println("Enter upper age:");
                    int upperAge = scanner.nextInt();
                    queryRunner.getByAgeRange(lowerAge, upperAge);
                    break;
                case 6:
                    System.out.println("System exiting...");
                    replay = false;
                    break;
                default:
                    System.out.println("Invalid choice\n");
            }
        }
    }
}
