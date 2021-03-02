package kz.aitu.oop.practice.assignment4.repositories;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDBManager;
import kz.aitu.oop.practice.assignment4.entities.Employee;
import kz.aitu.oop.practice.assignment4.entities.Position;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IPositionRepositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PositionRepositories implements IPositionRepositories {
    private final IDBManager dbManager;

    public PositionRepositories (IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public ArrayList<Position> showAllPosition() {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM position");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Position> positions = new ArrayList<>();

            while (resultSet.next()) {
                Position position = new Position(resultSet.getString("positionname"),
                        resultSet.getInt("salary"));
                positions.add(position);
            }

            return positions;

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addNewPosition(Position position) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO position(positionname, salary) VALUES (?, ?)");
            preparedStatement.setString(1, position.getName());
            preparedStatement.setInt(2, position.getSalary());

            preparedStatement.execute();
            return true;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removePosition(String position) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM position WHERE positionname =?");
            preparedStatement.setString(1, position);
            preparedStatement.execute();
            return true;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
