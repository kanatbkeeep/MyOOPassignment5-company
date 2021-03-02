package kz.aitu.oop.practice.assignment4.entities;

public class Position {
    private String name;
    private int salary;

    public Position(String positionname) {
    }

    public Position(String name, int salary) {
        setName(name);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "name = " + name + " | " +
                "salary = " + salary + "\n";
    }
}
