/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author EdwardLeonardi
 */

public class DBConnect
{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    //Connecting to Database
    public DBConnect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll", "root", "");
            st = con.createStatement();
        }
        
        catch(Exception ex)
        {
            System.out.println("Error : "+ex);
        }
    }
    
    public ArrayList<Employee> getEmployee()
    {
        ArrayList<Employee> employees = new ArrayList<>();
        
        try
        {
            rs = st.executeQuery("SELECT * FROM Employee");
            
            while(rs.next())
            {
                employees.add(new Employee(rs.getString("empID"), rs.getString("fName"), rs.getString("lName"), rs.getInt("joinDay"), rs.getInt("joinMonth"), rs.getInt("joinYear"), rs.getInt("position"), rs.getInt("salary"), rs.getInt("type")));
            }
        }
        
        catch(Exception ex)
        {
            System.out.println("Error : " + ex);
        }
        
        return employees;
    }
    
    public void updateEmployee(String empID, String fName, String lName, int joinDay, int joinMonth, int joinYear, int position, int salary, int type)
    {
        try
        {
            st.executeUpdate("UPDATE employee SET fName = '" + fName + "', lName = '" + lName + "', joinDay = " + joinDay + ", joinMonth = " + joinMonth + ", joinYear = " + joinYear + ", position = " + position + ", salary = " + salary + ", type = " + type + " WHERE empID = '" + empID + "'");
        }
        
        catch(Exception ex)
        {
            System.out.println("Error : " + ex);
        }
    }
    
    public void deleteEmployee(String empID)
    {
        try
        {
            st.executeUpdate("DELETE FROM Employee WHERE empID = '" + empID + "'");
        }
        
        catch(Exception ex)
        {
            System.out.println("Error : " + ex);
        }
    }
    
    public void addEmployee(String empID, String fName, String lName, int joinDay, int joinMonth, int joinYear, int position, int salary, int type)
    {
        try
        {
            st.executeUpdate("INSERT INTO Employee VALUES('" + empID + "', '" + fName + "', '" + lName + "', " + joinDay + ", " + joinMonth + ", " + joinYear + ", " + position + ", " + salary + ", " + type + ")");
        }
        
        catch(Exception ex)
        {
            System.out.println("Error : " + ex);
        }
    }
    
    public ArrayList<User> getUser()
    {
        ArrayList<User> users = new ArrayList<>();
        
        try
        {
            rs = st.executeQuery("SELECT * FROM User");
            
            while(rs.next())
            {
                users.add(new User(rs.getString("ID"), rs.getString("Password"), rs.getString("Name"), rs.getInt("type")));
            }
        }
        
        catch(Exception ex)
        {
            System.out.println("Error : " + ex);
        }
        
        return users;
    }
    
    public ArrayList<Record> getRecords()
    {
        ArrayList<Record> records = new ArrayList<>();
        
        try
        {
            rs = st.executeQuery("SELECT * FROM Records");
            
            while(rs.next())
            {
                records.add(new Record(rs.getString("RecordID"), rs.getString("EmpID"), rs.getInt("day"), rs.getInt("month"), rs.getInt("year"), rs.getInt("absence"), rs.getInt("overmonth"), rs.getInt("support"), rs.getInt("overAmount"), rs.getInt("overtime"), rs.getInt("insurance"), rs.getInt("loan")));
            }
        }
        
        catch(Exception ex)
        {
            System.out.println("Error : " + ex);
        }
        
        return records;
    }
    
    public void addRecord(String RecordID, String EmpID, int day, int month, int year, int absence, int overmonth, int support, int overamount, int overtime, int insurance, int loan)
    {
        try
        {
            st.executeUpdate("INSERT INTO Records VALUES('" + RecordID + "', '" + EmpID + "', " + day + ", " + month + ", " + year + ", " + absence + ", " + overmonth + ", " + support + ", " + overamount + ", " + overtime + ", " + insurance + ", " + loan + ")");
        }
        
        catch(Exception ex)
        {
            System.out.println("Error : " + ex);
        }
    }
}
