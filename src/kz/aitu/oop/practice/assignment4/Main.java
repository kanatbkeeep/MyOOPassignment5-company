package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.controllers.EmployeeController;
import kz.aitu.oop.practice.assignment4.controllers.PositionController;
import kz.aitu.oop.practice.assignment4.data.DBManager;
import kz.aitu.oop.practice.assignment4.data.interfaces.IDBManager;
import kz.aitu.oop.practice.assignment4.repositories.EmployeeRepositories;
import kz.aitu.oop.practice.assignment4.repositories.PositionRepositories;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepositories;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IPositionRepositories;

public class Main {
    public static void main(String[] args) {
        IDBManager dbManager = new DBManager(); //creating obj
        IEmployeeRepositories employeeRepositories = new EmployeeRepositories(dbManager);
        EmployeeController employeeController = new EmployeeController(employeeRepositories);
        IPositionRepositories positionRepositories = new PositionRepositories(dbManager);
        PositionController positionController = new PositionController(positionRepositories);
        MyApplication myApplication = new MyApplication(employeeController, positionController);
        myApplication.start(); //start function in MyApplication class
    }
}
