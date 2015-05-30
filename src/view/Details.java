/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.Driver;
import model.Employee;
import model.Record;

/**
 *
 * @author EdwardLeonardi
 */
public class Details extends JFrame
{
    private JPanel centerPane, bottomPane;
    private Container contain;
    private GridBagConstraints gc;
    private JLabel empLab, emp, dateLab, date, absenceLab, absence, supportLab, support, overtimeLab, overtime, insuranceLab, insurance, loanLab, loan, totalLab, total;
    private JButton okBtn;
    private Record rec;
    private int allowance;
    
    public Details(Record rec)
    {
        super("Payroll");
        
        //setIconImage(new ImageIcon("images/JLMSLogo.png").getImage());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.rec = rec;
        
        initcomponents();
        
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void initcomponents()
    {
        //Creating Panel
        contain = getContentPane();
        contain.setLayout(new BorderLayout());
        
        //Adding Panel
        centerPane = new JPanel();
        centerPane.setLayout(new GridBagLayout());
        bottomPane = new JPanel();
        bottomPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        bottomPane.setLayout(new FlowLayout());
        
        //bold font
        empLab = new JLabel("Employee :");
        Font font = empLab.getFont();
        Font boldFont = new Font(font.getFontName(), Font.BOLD, font.getSize());
        
        //Initializing Labels
        empLab.setFont(boldFont);
        dateLab = new JLabel("Date :");
        dateLab.setFont(boldFont);
        absenceLab = new JLabel("Absence :");
        absenceLab.setFont(boldFont);
        supportLab = new JLabel("Support :");
        supportLab.setFont(boldFont);
        overtimeLab = new JLabel("Overtime :");
        overtimeLab.setFont(boldFont);
        insuranceLab = new JLabel("Insurance :");
        insuranceLab.setFont(boldFont);
        loanLab = new JLabel("Loan :");
        loanLab.setFont(boldFont);
        totalLab = new JLabel("Total :");
        totalLab.setFont(boldFont);
        
        String name = null;
        
        //Initialize Dynamic Labels
        for(Employee elements : Driver.employees)
        {
            if(elements.getEmpID().equalsIgnoreCase(rec.getEmpID()))
            {
                name = elements.getfName() + " " + elements.getlName();
                allowance = elements.getSalary();
                break;
            }
        }
        
        emp = new JLabel(name);
        
        DateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        String today = formatter.format(rec.getPayday());
        date = new JLabel(today);
        
        absence = new JLabel(Integer.toString(rec.getAbsence()) + " / " + rec.getOvermonth());
        support = new JLabel("Rp " + Integer.toString(rec.getSupport()));
        overtime = new JLabel("Rp " + Integer.toString(rec.getOveramount()) + " x " + Integer.toString(rec.getOvertime()) + " Hours = " + Integer.toString(rec.getOveramount() * rec.getOvertime()));
        insurance = new JLabel("Rp " + Integer.toString(rec.getInsurance()));
        loan = new JLabel("Rp " + Integer.toString(rec.getLoan()));
        
        //Calculate Total
        int tot;
        tot = (rec.getAbsence() * allowance) + rec.getSupport() + (rec.getOveramount() * rec.getOvertime()) + rec.getInsurance() - rec.getLoan();
        total = new JLabel("Rp " + Integer.toString(tot));
        
        //Initialize Button
        okBtn = new JButton("OK");
        okBtn.setPreferredSize(new Dimension(90, 30));
        
        //Initialize Grid Bag Constraints
        gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 25, 10, 25);
        
        gc.gridx = 0;
        gc.gridy = 0;
        centerPane.add(empLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        centerPane.add(emp, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        centerPane.add(dateLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        centerPane.add(date, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        centerPane.add(absenceLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        centerPane.add(absence, gc);
        
        gc.gridx = 0;
        gc.gridy = 3;
        centerPane.add(supportLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        centerPane.add(support, gc);
        
        gc.gridx = 0;
        gc.gridy = 4;
        centerPane.add(overtimeLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 4;
        centerPane.add(overtime, gc);
        
        gc.gridx = 0;
        gc.gridy = 5;
        centerPane.add(insuranceLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 5;
        centerPane.add(insurance, gc);
        
        gc.gridx = 0;
        gc.gridy = 6;
        centerPane.add(loanLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 6;
        centerPane.add(loan, gc);
        
        gc.gridx = 0;
        gc.gridy = 7;
        centerPane.add(totalLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 7;
        centerPane.add(total, gc);
        
        bottomPane.add(okBtn);
        
        //Add panels to container
        contain.add(centerPane, BorderLayout.CENTER);
        contain.add(bottomPane, BorderLayout.SOUTH);
    }
}
