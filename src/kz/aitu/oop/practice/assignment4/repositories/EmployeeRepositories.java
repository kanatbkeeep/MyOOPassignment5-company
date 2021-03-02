package kz.aitu.oop.practice.assignment4.repositories;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDBManager;
import kz.aitu.oop.practice.assignment4.entities.Employee;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeRepositories implements IEmployeeRepositories {
    private final IDBManager dbManager;

    public EmployeeRepositories (IDBManager dbManager) {
        this.dbManager = dbManager;
    }


    @Override
    public ArrayList<Employee> showAllEmployee() {   //show all table of employee
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Employee> employees = new ArrayList<>();

            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("positionName"),
                        resultSet.getString("address"),
                        resultSet.getDate("dateOfBirthday").toLocalDate(),
                        resultSet.getDate("dateOfHiring").toLocalDate(),
                        resultSet.getString("department"));

                employees.add(employee);
            }

            return employees;

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Employee> searchEmployeeByName(String name) {     //search employee by name
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE name =?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Employee> employees = new ArrayList<>();

            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("positionName"),
                        resultSet.getString("address"),
                        resultSet.getDate("dateOfBirthday").toLocalDate(),
                        resultSet.getDate("dateOfHiring").toLocalDate(),
                        resultSet.getString("department"));

                employees.add(employee);
            }

            return employees;

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public Employee getEmployeeById(int id) {   //search/get employee by id
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("positionName"),
                        resultSet.getString("address"),
                        resultSet.getDate("dateOfBirthday").toLocalDate(),
                        resultSet.getDate("dateOfHiring").toLocalDate(),
                        resultSet.getString("department"));

                return employee;
            }

            return null;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean removeEmployeeById(int id) {  //delete employee from db by id
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE id =?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addNewEmployee(Employee employee) {  //add new employee to db
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee(name, surname, positionname, address, dateofbirthday, dateofhiring, department) VALUES (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getPosition());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setDate(5, Date.valueOf(employee.getDateOfBirthday()));
            preparedStatement.setDate(6, Date.valueOf(employee.getDateOfHiring()));
            preparedStatement.setString(7,employee.getDepartment());

            preparedStatement.execute();
            return true;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public int showSumOfAllSalary() {   //to search total cost of project I just sum all employee salary
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(salary) FROM employee INNER JOIN position ON employee.positionname = position.positionname;");
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {}
            return resultSet.getInt("sum");
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }

        return 0;
    }
}
