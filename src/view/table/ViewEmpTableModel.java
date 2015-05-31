/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.table;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Driver;
import model.Employee;

/**
 *
 * @author EdwardLeonardi
 */
public class ViewEmpTableModel extends AbstractTableModel {

    private ArrayList<Employee> emps = new ArrayList<>();
    
    public ViewEmpTableModel()
    {
        emps = Driver.employees;
    }
    
    @Override
    public int getRowCount() {
        return emps.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        Class type = String.class;
        
        if(columnIndex == 4)
        {
            type = Integer.class;
        }
        
        return type;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee emp = emps.get(rowIndex);
        Object value = null;
        
        if(columnIndex == 0)
        {
            value = emp.getfName() + " " + emp.getlName();
        }
        
        else if(columnIndex == 1)
        {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String join = formatter.format(emp.getJoinDate());
            value = join;
        }
        
        else if(columnIndex == 2)
        {
            String pos = null;
            
            if(emp.getPosition() == 1)
            {
                pos = "Director";
            }
            
            else if(emp.getPosition() == 2)
            {
                pos = "Manager";
            }
            
            else if(emp.getPosition() == 3)
            {
                pos = "Supervisor";
            }
            
            else if(emp.getPosition() == 4)
            {
                pos = "Administrator";
            }
            
            else if(emp.getPosition() == 5)
            {
                pos = "General Affair";
            }
            
            else if(emp.getPosition() == 6)
            {
                pos = "Store Keeper";
            }
            
            else if(emp.getPosition() == 7)
            {
                pos = "Packing";
            }
            
            else if(emp.getPosition() == 8)
            {
                pos = "Courier";
            }
            
            else if(emp.getPosition() == 9)
            {
                pos = "Office Boy";
            }
            
            value = pos;
        }
        
        else if(columnIndex == 3)
        {
            String types;
            
            if(emp.getType() == 1)
            {
                types = "Monthly";
            }
            
            else
            {
                types = "Weekly";
            }
            
            value = types;
        }
        
        else if(columnIndex == 4)
        {
            value = emp.getSalary();
        }
        
        return value;
    }
    
    @Override
    public String getColumnName(int column)
    {
        String name = "";
        
        if(column == 0)
        {
            name = "Name";
        }
        
        else if(column == 1)
        {
            name = "Date";
        }
        
        else if(column == 2)
        {
            name = "Position";
        }
        
        else if(column == 3)
        {
            name = "Type";
        }
        
        else if(column == 4)
        {
            name = "Salary";
        }
        
        return name;
    }
}
