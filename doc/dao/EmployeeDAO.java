package com.doc.dao;

import com.doc.beans.Employee;

import java.util.ArrayList;

public interface EmployeeDAO {
    public boolean save(Employee e);
    public boolean remove(Employee e);
    public boolean removeByName(String name);

    public void displayAll();

    public Employee findEmployeeById(int find_id);
    public ArrayList<Employee> sortBySalary();

    public ArrayList<Employee> allSalaryAbove(double sal);

    public boolean updateSalary(Employee obj, double new_sal);

    public Employee findEmployeeByName(String name);
}
