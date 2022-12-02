package com.doc.services;

import com.doc.beans.Employee;
import com.doc.dao.EmployeeDAOImplementation;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeServicesImplementations implements EmployeeServices{

    Scanner ins = new Scanner(System.in);
    EmployeeDAOImplementation edi = new EmployeeDAOImplementation();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    @Override
    public void addNewEmployee() {

        System.out.println("Enter the id of the employee: ");
        int eid = ins.nextInt();
        System.out.println("Enter the name of the employee: ");
        ins.nextLine();
        String ename = ins.nextLine();
        System.out.println("Enter the Salary of the employee: ");
        Double esal = ins.nextDouble();
        System.out.println("Enter the Date of Joining of the employee (dd/mm/yyyy): ");
        ins.nextLine();
        String edoj = ins.nextLine();
        Date doj = null;
        try {
            doj = sdf.parse(edoj);
            Employee emp  = new Employee(eid,ename,esal,doj);
            if(edi.save(emp))
                System.out.println("Employee added successfully");
            else
                System.out.println("Cannot add employee");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeEmployeeById(int id) {
        //here we need a employee object with only one constructor parameter e as id
        Employee del_this = new Employee(id);
        edi.remove(del_this);
    }

    @Override
    public void removeEmployeeByName(String name) {
        if(edi.removeByName(name))
            System.out.println("Deleted Successfully");
        else
            System.out.println("cannot delete");
    }

    public void displayAll(){
        edi.displayAll();
    }

    public Employee findEmployeeById(int find_id){
        return edi.findEmployeeById(find_id);
    }

    public ArrayList<Employee> sortBySalary(){
            return edi.sortBySalary();
    }

    @Override
    public ArrayList<Employee> allSalaryAbove(double sal) {
        return edi.allSalaryAbove(sal);
    }

    public boolean updateSalary(int id, double new_sal){
        Employee upd_emp = new Employee(id);
        return edi.updateSalary(upd_emp ,new_sal);
    }

    public Employee findEmployeeByName(String name){
        return edi.findEmployeeByName(name);
    }

}
