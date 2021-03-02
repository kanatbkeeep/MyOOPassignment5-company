package kz.aitu.oop.practice.assignment4.data;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDBManager;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager implements IDBManager {
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/assignment5", "postgres", "postgre");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }
}
