/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import view.Login;
import view.Synthetica;

/**
 *
 * @author EdwardLeonardi
 */
public class Driver
{
    public static DBConnect database;
    public static ArrayList<Employee> employees;
    public static ArrayList<User> users;
    
    public static void main(String[] args)
    {
        Synthetica synth = new Synthetica();
        
        database = new DBConnect();
        
        //initialize global array list
        users = database.getUser();
        employees = database.getEmployee();
        
        
        //print list of employees
        /*for(Employee emps : employees)
        {
            System.out.println("empID: " + emps.getEmpID() + ", fName: " + emps.getfName() + ", lName: " + emps.getlName() + ", joinDay: " + emps.getJoinDate().getDate() + ", joinMonth: " + emps.getJoinDate().getMonth() + ", joinYear: " + emps.getJoinDate().getYear() + ", position: " + emps.getPosition() + ", salary: " + emps.getSalary() +  ", type: " + emps.getType());
        }*/
        
        //database.updateEmployee("E002", "Billy", "Sean", 1, 1, 1990, 2, 10000, 3);
        
        //SAMenu saFrame = new SAMenu();
        
        Login loginFrame = new Login();
    }
}
