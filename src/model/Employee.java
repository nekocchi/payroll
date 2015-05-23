/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author EdwardLeonardi
 */
public class Employee
{
    private String empID;
    private String fName;
    private String lName;
    private Date joinDate;
    private int position;
    private int salary;
    private int type;
    
    public Employee(String empID, String fName, String lName, int joinDay, int joinMonth, int joinYear, int position, int salary, int type)
    {
        this.empID = empID;
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
        this.joinDate = new Date(joinYear - 1900, joinMonth - 1, joinDay);
        this.position = position;
        this.type = type;
    }

    public String getfName()
    {
        return fName;
    }

    public void setfName(String fName)
    {
        this.fName = fName;
    }

    public String getlName()
    {
        return lName;
    }

    public void setlName(String lName)
    {
        this.lName = lName;
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public Date getJoinDate()
    {
        return joinDate;
    }

    public String getEmpID()
    {
        return empID;
    }

    public void setEmpID(String empID)
    {
        this.empID = empID;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }
}
