package com.example.kailashlab3;

public class emloyeetable {
    private int EN;
    private String EmployeeName;
    private int PhoneNumber;

    public emloyeetable(int EN, String employeeName, int phoneNumber, int salary) {
        this.EN = EN;
        EmployeeName = employeeName;
        PhoneNumber = phoneNumber;
        Salary = salary;
    }

    private int Salary;

    public int getEN() {
        return EN;
    }

    public void setEN(int EN) {
        this.EN = EN;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}
