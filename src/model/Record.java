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
public class Record
{
    private String RecordID, EmpID;
    private Date payday;
    private int absence, overmonth, support, overamount, overtime, insurance, loan;

    public Record(String RecordID, String EmpID, int day, int month, int year, int absence, int overmonth, int support, int overamount, int overtime, int insurance, int loan)
    {
        this.RecordID = RecordID;
        this.EmpID = EmpID;
        payday = new Date(year - 1900, month - 1, day);
        this.absence = absence;
        this.overmonth = overmonth;
        this.support = support;
        this.overamount = overamount;
        this.overtime = overtime;
        this.insurance = insurance;
        this.loan = loan;
    }

    public String getRecordID() {
        return RecordID;
    }

    public String getEmpID() {
        return EmpID;
    }

    public Date getPayday() {
        return payday;
    }
    
    public int getAbsence() {
        return absence;
    }

    public int getOvermonth() {
        return overmonth;
    }

    public int getSupport() {
        return support;
    }

    public int getOvertime() {
        return overtime;
    }

    public int getInsurance() {
        return insurance;
    }

    public int getLoan() {
        return loan;
    }

    public int getOveramount() {
        return overamount;
    }
}
