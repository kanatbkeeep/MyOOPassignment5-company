package kz.aitu.oop.practice.assignment4.repositories.interfaces;

import kz.aitu.oop.practice.assignment4.entities.Employee;
import kz.aitu.oop.practice.assignment4.entities.Position;

import java.util.ArrayList;

public interface IPositionRepositories {
    public ArrayList<Position> showAllPosition();
    public boolean addNewPosition(Position position);
    public boolean removePosition(String position);
}
