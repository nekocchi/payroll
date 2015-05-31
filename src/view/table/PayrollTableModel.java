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
import model.Record;

/**
 *
 * @author EdwardLeonardi
 */
public class PayrollTableModel extends AbstractTableModel {
    private ArrayList<Record> recs = new ArrayList<>();
    
    public PayrollTableModel()
    {
        recs = Driver.records;
    }
    
    @Override
    public int getRowCount() {
        return recs.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        Class type = String.class;
        
        if(columnIndex == 2)
        {
            type = Integer.class;
        }
        
        return type;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Record rec = recs.get(rowIndex);
        Object value = null;
        
        String tempID, name = null;
        int allowance = 0;
        
        tempID = rec.getEmpID();

        for(Employee elements : Driver.employees)
        {
            if(elements.getEmpID().equals(tempID))
            {
                name = elements.getfName() + " " + elements.getlName();
                allowance = elements.getSalary();
                break;
            }
        }
        
        if(columnIndex == 0)
        {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String payday = formatter.format(rec.getPayday());
            value = payday;
        }
        
        else if(columnIndex == 1)
        {
            value = name;
        }
        
        else if(columnIndex == 2)
        {
            int tot;
            tot = (rec.getAbsence() * allowance) + rec.getSupport() + (rec.getOveramount() * rec.getOvertime()) + rec.getInsurance() - rec.getLoan();
            value = tot;
        }
        
        return value;
    }
    
    @Override
    public String getColumnName(int column)
    {
        String name = "";
        
        if(column == 0)
        {
            name = "Date";
        }
        
        else if(column == 1)
        {
            name = "Name";
        }
        
        else if(column == 2)
        {
            name = "Total";
        }
        
        return name;
    }
    
}
