package com.doc.dao;

import java.text.SimpleDateFormat;
import java.util.*;

import com.doc.beans.Employee;
import org.w3c.dom.css.CSSStyleDeclaration;

public class EmployeeDAOImplementation implements EmployeeDAO {


    Scanner ins = new Scanner(System.in);
    public static Set<Employee> emplist = new HashSet<>();

    static{
        emplist.add(new Employee(1,"Sankalp",90000,new Date(2021,11,8)));
        emplist.add(new Employee(2,"Ram",80000,new Date(2021,11,12)));
        emplist.add(new Employee(3,"Shyam",70000,new Date(2021,11,21)));
    }

    //will contain the database of all the employees



    @Override
    public boolean save(Employee emp){
        return emplist.add(emp);
    }

    @Override
    public boolean remove(Employee e) {
        return emplist.remove(e);
    }

    public boolean removeByName(String nm){
        Iterator<Employee> it = emplist.iterator();
        while(it.hasNext()){
            Employee del_this = it.next();
            if(del_this.getEname().equals(nm))
                return emplist.remove(del_this);
        }
        return false;
    }

    public void displayAll(){
        Iterator<Employee> it = emplist.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public Employee findEmployeeById(int find_id){
        Iterator<Employee> it = emplist.iterator();
        while (it.hasNext()) {
            Employee found = it.next();
            if(found.getEid()==find_id)
                return found;
        }
        return null;
    }


    public ArrayList<Employee> sortBySalary(){
        ArrayList<Employee> emp_list = new ArrayList<>();
        for(Employee move:emplist){
            emp_list.add(move);
        }
        emp_list.sort(null);
        return emp_list;
    }


    public ArrayList<Employee> allSalaryAbove(double sal){
        ArrayList<Employee> above_salary = new ArrayList<>();
        for(Employee move:emplist){
            if(move.getSalary()>sal)
                above_salary.add(move);
        }
        return above_salary;
    }

    public boolean updateSalary(Employee emp, double salary){
        for(Employee test:emplist){
            if(test.getEid()==emp.getEid()) {
                test.setSalary(salary);
                return true;
            }
        }
        return false;
    }

    public Employee findEmployeeByName(String name){
        for(Employee test:emplist){
            if(test.getEname().equals(name))
                return test;
        }
        return null;
    }
}
