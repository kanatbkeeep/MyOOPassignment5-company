package kz.aitu.oop.practice.assignment4.data.interfaces;

import java.sql.Connection;

public interface IDBManager {
    Connection getConnection();
}
