package com.doc.services;

import com.doc.beans.Employee;

import java.util.ArrayList;

public interface EmployeeServices {
    public void addNewEmployee();

    public void removeEmployeeById(int id);

    public void removeEmployeeByName(String name);

    public void displayAll();
    public Employee findEmployeeById(int id);

    public ArrayList<Employee> sortBySalary();

    public ArrayList<Employee> allSalaryAbove(double sal);

    public boolean updateSalary(int id, double new_sal);

    public Employee findEmployeeByName(String name);
}
