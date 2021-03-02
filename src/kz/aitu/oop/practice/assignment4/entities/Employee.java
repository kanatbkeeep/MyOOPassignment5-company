package kz.aitu.oop.practice.assignment4.entities;

import java.time.LocalDate;

public class Employee { //just entities
    private int id;
    private String name;
    private String surname;
    private String position;
    private String address;
    private LocalDate dateOfBirthday;
    private LocalDate dateOfHiring;
    private String department;

    public Employee() {
    }

    public Employee(String name, String surname, String position, String address, LocalDate dateOfBirthday, LocalDate dateOfHiring, String department) {
        setName(name);
        setSurname(surname);
        setPosition(position);
        setAddress(address);
        setDateOfBirthday(dateOfBirthday);
        setDateOfHiring(dateOfHiring);
        setDepartment(department);
    }

    public Employee(int id, String name, String surname, String position, String address, LocalDate dateOfBirthday, LocalDate dateOfHiring, String department) {
        setId(id);
        setName(name);
        setSurname(surname);
        setPosition(position);
        setAddress(address);
        setDateOfBirthday(dateOfBirthday);
        setDateOfHiring(dateOfHiring);
        setDepartment(department);
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public LocalDate getDateOfHiring() {
        return dateOfHiring;
    }

    public void setDateOfHiring(LocalDate dateOfHiring) {
        this.dateOfHiring = dateOfHiring;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return  "id = " + id + " | " +
                "name = " + name + " | " +
                "surname = " + surname + " | " +
                "position = " + position + " | " +
                "address = " + address + " | " +
                "dateOfBirthday = " + dateOfBirthday + " | " +
                "dateOfHiring = " + dateOfHiring + " | " +
                "department = " + department + "\n";
    }
}


