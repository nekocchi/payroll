/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;
import model.Driver;
import model.Employee;
import model.Record;
import view.sa.SAMenu;

/**
 *
 * @author EdwardLeonardi
 */
public class Calculate extends JFrame{
    private JPanel topPane, centerPane, bottomPane, datePane, absencePane, overtimePane;
    private Container contain;
    private GridBagConstraints gc;
    private JLabel titleLab, empLab, dateLab, absenceLab, overLab, supportLab, overtimeLab, hoursLab, insuranceLab, loanLab, mulLab;
    private JComboBox empCB, dayCB, monthCB;
    private JTextField yearTF, absenceTF, overmonthTF, supportTF, overtimeTF, insuranceTF, loanTF, overAmountTF;
    private JButton okBtn, backBtn;
    private ArrayList<String> names;
    
    public Calculate()
    {
        super("Payroll");
        
        //setIconImage(new ImageIcon("images/JLMSLogo.png").getImage());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initcomponents();
        
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void initcomponents()
    {
        //Combo Box Selection Array
        String[] dayCombo = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                             "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                             "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        
        String[] monthCombo = {"January", "Febuary", "March", "April", "May", "June", "July", "August",
                               "September", "October", "November", "December"};
        
        //Creating Panel
        contain = getContentPane();
        contain.setLayout(new BorderLayout());
        
        //Adding Panel
        topPane = new JPanel();
        topPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        topPane.setLayout(new FlowLayout());
        centerPane = new JPanel();
        centerPane.setLayout(new GridBagLayout());
        bottomPane = new JPanel();
        bottomPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        bottomPane.setLayout(new FlowLayout());
        datePane = new JPanel();
        datePane.setBorder(new EmptyBorder(10, -3, 10, 10));
        datePane.setLayout(new FlowLayout(FlowLayout.LEFT));
        absencePane = new JPanel();
        absencePane.setBorder(new EmptyBorder(10, -3, 10, 10));
        absencePane.setLayout(new FlowLayout(FlowLayout.LEFT));
        overtimePane = new JPanel();
        overtimePane.setBorder(new EmptyBorder(10, -3, 10, 10));
        overtimePane.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //initializing labels
        titleLab = new JLabel("Calculate Allowance");
        titleLab.setFont(titleLab.getFont().deriveFont(24.0f));
        empLab = new JLabel("Employee :");
        dateLab = new JLabel("Date :");
        absenceLab = new JLabel("Absence :");
        supportLab = new JLabel("Support :");
        overtimeLab = new JLabel("Overtime :");
        hoursLab = new JLabel("Hours");
        insuranceLab = new JLabel("Insurance :");
        loanLab = new JLabel("Loan :");
        overLab = new JLabel("/");
        mulLab = new JLabel("x");
        
        names = new ArrayList<>();
        
        //initializing combo box
        for(Employee elements : Driver.employees)
        {
            names.add(elements.getfName() + " " + elements.getlName());
        }
        
        empCB = new JComboBox(names.toArray());
        empCB.setPreferredSize(new Dimension(300, 30));
        dayCB = new JComboBox(dayCombo);
        monthCB = new JComboBox(monthCombo);
        
        //initializing textfields
        yearTF = new JTextField();
        yearTF.setPreferredSize(new Dimension(70, 30));
        absenceTF = new JTextField();
        absenceTF.setPreferredSize(new Dimension(50, 30));
        overmonthTF = new JTextField();
        overmonthTF.setPreferredSize(new Dimension(50, 30));
        supportTF = new JTextField();
        supportTF.setPreferredSize(new Dimension(300, 30));
        overtimeTF = new JTextField();
        overtimeTF.setPreferredSize(new Dimension(50, 30));
        insuranceTF = new JTextField();
        insuranceTF.setPreferredSize(new Dimension(300, 30));
        loanTF = new JTextField();
        loanTF.setPreferredSize(new Dimension(300, 30));
        overAmountTF = new JTextField();
        overAmountTF.setPreferredSize(new Dimension(90, 30));
        
        //initializing buttons
        okBtn = new JButton("OK");
        okBtn.setPreferredSize(new Dimension(90, 30));
        backBtn = new JButton("Back");
        backBtn.setPreferredSize(new Dimension(90, 30));
        
        //add components to sub panels
        datePane.add(dayCB);
        datePane.add(monthCB);
        datePane.add(yearTF);
        
        absencePane.add(absenceTF);
        absencePane.add(overLab);
        absencePane.add(overmonthTF);
        
        overtimePane.add(overAmountTF);
        overtimePane.add(mulLab);
        overtimePane.add(overtimeTF);
        overtimePane.add(hoursLab);
        
        //Set date to today's date (default)
        Date now = new Date();
        yearTF.setText(Integer.toString(now.getYear() + 1900));
        dayCB.setSelectedIndex(now.getDate() - 1);
        monthCB.setSelectedIndex(now.getMonth());
        
        //Initialize Grid Bag Constraints
        gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 25, 10, 25);
        
        //Adding components to panel
        topPane.add(titleLab);
        
        gc.gridx = 0;
        gc.gridy = 0;
        centerPane.add(empLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        centerPane.add(empCB, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        centerPane.add(dateLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        centerPane.add(datePane, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        centerPane.add(absenceLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        centerPane.add(absencePane, gc);
        
        gc.gridx = 0;
        gc.gridy = 3;
        centerPane.add(supportLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        centerPane.add(supportTF, gc);
        
        gc.gridx = 0;
        gc.gridy = 4;
        centerPane.add(overtimeLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 4;
        centerPane.add(overtimePane, gc);
        
        gc.gridx = 0;
        gc.gridy = 5;
        centerPane.add(insuranceLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 5;
        centerPane.add(insuranceTF, gc);
        
        gc.gridx = 0;
        gc.gridy = 6;
        centerPane.add(loanLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 6;
        centerPane.add(loanTF, gc);
        
        bottomPane.add(okBtn);
        bottomPane.add(backBtn);
        
        //Adding Panel to Container
        contain.add(topPane, BorderLayout.NORTH);
        contain.add(centerPane, BorderLayout.CENTER);
        contain.add(bottomPane, BorderLayout.SOUTH);
        
        addListener(new handler());
    }
    
    public void addListener(ActionListener listenForBtn)
    {
        okBtn.addActionListener(listenForBtn);
        backBtn.addActionListener(listenForBtn);
    }
    
    public class handler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            if(evt.getSource() == okBtn)
            {
                String tempID, recID;
                int daytemp, montemp, yeartemp, abstemp, totemp, supptemp, overamtemp, overtitemp, instemp, loantemp, num;
                
                tempID = Driver.employees.get(empCB.getSelectedIndex()).getEmpID();
                daytemp = dayCB.getSelectedIndex() + 1;
                montemp = monthCB.getSelectedIndex() + 1;
                yeartemp = Integer.parseInt(yearTF.getText());
                abstemp = Integer.parseInt(absenceTF.getText());
                totemp = Integer.parseInt(overmonthTF.getText());
                supptemp = Integer.parseInt(supportTF.getText());
                overamtemp = Integer.parseInt(overAmountTF.getText());
                overtitemp = Integer.parseInt(overtimeTF.getText());
                instemp = Integer.parseInt(insuranceTF.getText());
                loantemp = Integer.parseInt(loanTF.getText());
                
                num = Driver.records.size() + 1;
                
                //Generate Record ID
                if(num < 10)
                {
                    recID = "R00" + num; 
                }
                
                else if(num >= 10 && num < 100)
                {
                    recID = "R0" + num;
                }
                
                else
                {
                    recID = "R" + num;
                }
                
                //Add to database and arraylist
                Driver.database.addRecord(recID, tempID, daytemp, montemp, yeartemp, abstemp, totemp, supptemp, overamtemp, overtitemp, instemp, loantemp);
                Driver.records.add(new Record(recID, tempID, daytemp, montemp, yeartemp, abstemp, totemp, supptemp, overamtemp, overtitemp, instemp, loantemp));
                
                dispose();
                
                //DetailFrame
                new Details(Driver.records.get(Driver.records.size() - 1), 1);
            }
            
            else
            {
                dispose();
                new SAMenu();
            }
        }
    }
}
