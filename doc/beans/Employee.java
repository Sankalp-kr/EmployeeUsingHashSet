package com.doc.beans;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Employee implements Comparable<Employee> {

    private int eid;
    private String ename;
    private double Salary;
    private Date doj;


    //here the doj should be in converted form before assignment to the this.doj
    public Employee(int eid, String ename, double salary, Date doj) {
        this.eid = eid;
        this.ename = ename;
        Salary = salary;
        this.doj = doj;
    }

    public Employee(int eid){
        this(eid,null,0.0,null);
    };

    public int getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public double getSalary() {
        return Salary;
    }

    public Date getDoj() {
        return doj;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }


    //here doj must be modified so that it is in user understandable form
    //use sdf for the same

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", Salary=" + Salary +
                ", doj=" + sdf.format(doj) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return this.eid==((Employee)o).getEid();

    }

    @Override
    public int hashCode() {
        return eid;
    }

    @Override
    public int compareTo(Employee o) {
        if(this.getSalary()<o.getSalary())
            return -1;
        else if(this.getSalary()>o.getSalary())
            return 1;
        else
            return 0;
    }
}
