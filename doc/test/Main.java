package com.doc.test;
import com.doc.beans.Employee;
import com.doc.services.EmployeeServicesImplementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner ins = new Scanner(System.in);
        int choice = 99;
        EmployeeServicesImplementations esi = new EmployeeServicesImplementations();




        do {
            System.out.println("1. add new Employee\n2. remove by id\n 3. remove by name\n");
            System.out.println("4. display all\n5.find by id\n6. sort by salary\n");
            System.out.println("7. display all with salary > given salary\n8.modify salary\n9.find by name 10.exit\n ");
            System.out.println("choice :");
            choice = ins.nextInt();

            switch (choice){

                case 1:
                    esi.addNewEmployee();
                    break;

                case 2:
                    System.out.println();

                    System.out.println("Enter the id of the employee: ");
                    int rm_id = ins.nextInt();
                    esi.removeEmployeeById(rm_id);
                    break;

                case 3:
                    System.out.println();

                    System.out.println("Enter the name of the employee: ");
                    String rm_name = ins.next();
                    esi.removeEmployeeByName(rm_name);
                    break;

                case 4:
                    System.out.println();

                    System.out.println("Displaying all Employees..");
                    esi.displayAll();
                    break;

                case 5:
                    System.out.println();

                    System.out.println("Enter the id of the employee: ");
                    int find_id = ins.nextInt();
                    Employee found = esi.findEmployeeById(find_id);
                    if(found==null)
                        System.out.println("Employee Not Found");
                    else {
                        System.out.println();
                        System.out.println(found);
                    }

                    break;


                case 6:
                    System.out.println();

                    System.out.println("Sorting by salary: ");
                    ArrayList<Employee> sorted_elist = esi.sortBySalary();
                    Iterator<Employee> it = sorted_elist.iterator();
                    while(it.hasNext()){
                        System.out.println(it.next());
                    }
                    break;

                case 7:
                    System.out.println();

                    System.out.println("Enter the salary over which you want to display all the employees: ");
                    Double ab_salary = ins.nextDouble();
                    ArrayList<Employee> above_salary = esi.allSalaryAbove(ab_salary);
                    if(above_salary.isEmpty())
                        System.out.println("No employee found filling the complete criterion");
                    else {
                        for (Employee emp : above_salary)
                            System.out.println(emp);
                    }
                    break;

                case 8:
                    System.out.println();

                    System.out.println("Enter the id of the Employee for whom you want to change the salary: ");
                    int change_emp = ins.nextInt();
                    System.out.println("Enter the new salary: ");
                    Double new_sal = ins.nextDouble();
                    if(esi.updateSalary(change_emp,new_sal))
                        System.out.println("Salary updated successfully");
                    else
                        System.out.println("Cannot update salary");

                    break;

                case 9:
                    System.out.println();

                    System.out.println("Enter the name of the employee to search: ");
                    String search_name = ins.next();
                    Employee found_by_name= esi.findEmployeeByName(search_name);
                    if(found_by_name==null)
                        System.out.println("Employee Not found");
                    else
                        System.out.println(found_by_name);

                    break;

                case 10:
                    System.out.println();
                    System.out.println("Thank you for using our application.");

            }


        }while(choice!=10);

        ins.close();
    }
}