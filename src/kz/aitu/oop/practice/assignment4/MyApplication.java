package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.controllers.EmployeeController;
import kz.aitu.oop.practice.assignment4.controllers.PositionController;
import kz.aitu.oop.practice.assignment4.entities.Employee;
import kz.aitu.oop.practice.assignment4.entities.Position;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class MyApplication {
    private EmployeeController employeeController;
    private PositionController positionController;
    private Scanner scanner;

    public MyApplication(EmployeeController employeeController, PositionController positionController) {
        this.employeeController = employeeController;
        this.positionController = positionController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("""
                            Choose one option:
                            1)Show all employee
                            2)Search employee by name
                            3)Search employee by ID
                            4)Remove employee by ID
                            5)Add new employee
                            6)Show money spent on the project
                            
                            7)Show all position
                            8)Add new position
                            9)Remove position
                            """
                    );
            int choice = scanner.nextInt();

            if (choice == 1) {
                showAllEmployeeMenu();
            }
            else if (choice == 2) {
                searchEmployeeByNameMenu();
            }
            else if (choice == 3) {
                searchEmployeeByIdMenu();
            }
            else if (choice == 4) {
                removeEmployeeByIdMenu();
            }
            else if (choice == 5) {
                addNewEmployeeMenu();
            }
            else if (choice == 6) {
                sumOfAllEmployeeMenu();
            }
            else if(choice == 7) {
                showAllPositionMenu();
            }
            else if(choice == 8) {
                addNewPositionMenu();
            }
            else if(choice == 9) {
                removePositionMenu();
            }
            else break;

            System.out.println("----------------------------------------------------------------");
        }
    }

    public void showAllEmployeeMenu() {
        System.out.println(employeeController.showAll());
    }

    public void searchEmployeeByNameMenu() {
        System.out.println("White employee's name to search:");
        String name = scanner.next();
        System.out.println(employeeController.searchEmployeeByName(name));
    }

    public void searchEmployeeByIdMenu() {
        System.out.println("White employee's ID to search:");
        int id = scanner.nextInt();
        System.out.println(employeeController.getEmployeeById(id));
    }

    public void removeEmployeeByIdMenu() {
        System.out.println("White employee's ID to remove:");
        int id = scanner.nextInt();
        System.out.println(employeeController.removeEmployeeById(id));
    }

    public void addNewEmployeeMenu() {
        System.out.println("White employee's name:");
        String name = scanner.next();
        System.out.println("White employee's surname:");
        String surname = scanner.next();
        System.out.println("White employee's position:");
        String position = scanner.next();
        System.out.println("White employee's address:");
        String address = scanner.next();
        System.out.println("White employee's date of birthday:");
        String dateOfBirthday = scanner.next();
        System.out.println("White employee's date of hiring:");
        String dateOfHiring = scanner.next();
        System.out.println("White employee's date of department:");
        String department = scanner.next();
        Employee employee = new Employee(name, surname, position, address, LocalDate.parse(dateOfBirthday), LocalDate.parse(dateOfHiring), department);
        System.out.println(employeeController.addNewEmployee(employee));
    }

    public void sumOfAllEmployeeMenu() {
        System.out.println(employeeController.showSumOfAllSalary());
    }

    public void showAllPositionMenu() {
        System.out.println(positionController.showAllPosition());
    }

    public void addNewPositionMenu() {
        System.out.println("White position name:");
        String name = scanner.next();
        System.out.println("White position salary:");
        int salary = scanner.nextInt();
        Position position = new Position(name, salary);
        System.out.println(positionController.addNewPosition(position));
    }

    public void removePositionMenu() {
        System.out.println("White position's name to remove:");
        String name = scanner.next();
        System.out.println(positionController.removePosition(name));
    }
}
