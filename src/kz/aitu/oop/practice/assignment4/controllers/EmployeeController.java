package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.Employee;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepositories;

public class EmployeeController {
    private final IEmployeeRepositories employeeRepositories;

    public EmployeeController(IEmployeeRepositories employeeRepositories) {
        this.employeeRepositories = employeeRepositories;
    }

    public String showAll() {
        return employeeRepositories.showAllEmployee().toString();
    }

    public String searchEmployeeByName(String name) {
        return employeeRepositories.searchEmployeeByName(name).toString();
    }

    public String getEmployeeById(int id) {
        return employeeRepositories.getEmployeeById(id).toString();
    }

    public String removeEmployeeById(int id) {
        boolean checkRemoved = employeeRepositories.removeEmployeeById(id);

        if(checkRemoved) return "****Employee was removed from DB****";
        return "****Employee was NOT removed from DB****";
    }

    public String addNewEmployee(Employee employee) {
        boolean checkAdded = employeeRepositories.addNewEmployee((employee));

        if (checkAdded) return "****Employee was added to DB****";

        return "****Employee was NOT added to DB****";
    }

    public String showSumOfAllSalary() {
        return Integer.toString(employeeRepositories.showSumOfAllSalary());
    }
}
