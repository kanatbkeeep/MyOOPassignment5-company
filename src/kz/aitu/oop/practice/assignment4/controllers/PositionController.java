package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.Position;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IPositionRepositories;

public class PositionController {
    private final IPositionRepositories positionRepositories;

    public PositionController(IPositionRepositories positionRepositories) {
        this.positionRepositories = positionRepositories;
    }

    public String showAllPosition() {
        return positionRepositories.showAllPosition().toString();
    }

    public String addNewPosition(Position position) {
        boolean checkAdded = positionRepositories.addNewPosition((position));

        if (checkAdded) return "****Position was added to DB****";

        return "****Position was NOT added to DB****";
    }

    public String removePosition(String position) {
        boolean checkRemoved = positionRepositories.removePosition(position);

        if(checkRemoved) return "****Position was removed from DB****";
        return "****Position was NOT removed from DB****";
    }
}
