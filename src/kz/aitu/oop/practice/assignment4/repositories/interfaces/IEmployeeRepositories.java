package kz.aitu.oop.practice.assignment4.repositories.interfaces;

import kz.aitu.oop.practice.assignment4.entities.Employee;

import java.util.ArrayList;

public interface IEmployeeRepositories {
    public ArrayList<Employee> showAllEmployee();
    public ArrayList<Employee> searchEmployeeByName(String name);
    public Employee getEmployeeById(int id);
    public boolean removeEmployeeById(int id);
    public boolean addNewEmployee(Employee employee);
    public int showSumOfAllSalary();
}
