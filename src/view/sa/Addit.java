/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sa;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;
import model.Driver;
import model.Employee;

/**
 *
 * @author EdwardLeonardi
 */
public class Addit extends JFrame{
    private int addit;
    private String tempID;
    private String fname, lname;
    private int salary, position, type;
    private Date join;
    private JLabel titleLab, fNameLab, lNameLab, joinLab, salaryLab, posLab, typeLab;
    private JTextField fNameTF, lNameTF, yearTF, salaryTF;
    private JComboBox dayCB, monthCB, posCB, typeCB;
    private JButton additBtn, backBtn;
    private JPanel topPane, centerPane, bottomPane, datePane;
    private Container contain;
    private GridBagConstraints gc;
    
    
    public Addit(int addit, Employee empInit)
    {
        super("Payroll");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.addit = addit;
        this.tempID = empInit.getEmpID();
        this.fname = empInit.getfName();
        this.lname = empInit.getlName();
        this.join = empInit.getJoinDate();
        this.salary = empInit.getSalary();
        this.position = empInit.getPosition();
        this.type = empInit.getType();
        
        initcomponents();
        
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public Addit(int addit)
    {
        super("Payroll");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.addit = addit;
        
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
        
        String[] posCombo = {"Manager", "Accountant", "Packing", "Courier"};
        
        String[] typeCombo = {"Monthly", "Weekly"};
        
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
        
        //Initializing labels
        fNameLab = new JLabel("First Name :");
        lNameLab = new JLabel("Last Name :");
        joinLab = new JLabel("Join Date :");
        salaryLab = new JLabel("Salary :");
        posLab = new JLabel("Position :");
        typeLab = new JLabel("Type :");
        
        //Initializing textfields
        fNameTF = new JTextField();
        fNameTF.setPreferredSize(new Dimension(300, 30));
        lNameTF = new JTextField();
        lNameTF.setPreferredSize(new Dimension(300, 30));
        salaryTF = new JTextField();
        salaryTF.setPreferredSize(new Dimension(300, 30));
        yearTF = new JTextField();
        yearTF.setPreferredSize(new Dimension(70, 30));
        
        //Initializing combo box
        dayCB = new JComboBox(dayCombo);
        monthCB = new JComboBox(monthCombo);
        posCB = new JComboBox(posCombo);
        typeCB = new JComboBox(typeCombo);
        
        //Add or edit
        if(this.addit == 1)
        {
            titleLab = new JLabel("Add Employee");
            additBtn = new JButton("Add");
            
            Date now = new Date();
            
            yearTF.setText(Integer.toString(now.getYear() + 1900));
            dayCB.setSelectedIndex(now.getDate() - 1);
            monthCB.setSelectedIndex(now.getMonth());
        }
        
        else
        {
            titleLab = new JLabel("Edit Employee");
            additBtn = new JButton("Edit");
            
            fNameTF.setText(fname);
            lNameTF.setText(lname);
            salaryTF.setText(Integer.toString(salary));
            yearTF.setText(Integer.toString(join.getYear() + 1900));
            
            dayCB.setSelectedIndex(join.getDate() - 1);
            monthCB.setSelectedIndex(join.getMonth());
            posCB.setSelectedIndex(position - 1);
            typeCB.setSelectedIndex(type - 1);
            
            yearTF.setEditable(false);
            dayCB.setEnabled(false);
            monthCB.setEnabled(false);
        }
        
        titleLab.setFont(titleLab.getFont().deriveFont(24.0f));
        
        additBtn.setPreferredSize(new Dimension(90, 30));
        
        backBtn = new JButton("Back");
        backBtn.setPreferredSize(new Dimension(90, 30));
        
        //Initialize Grid Bag Constraints
        gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 25, 10, 25);
        
        datePane.add(dayCB);
        datePane.add(monthCB);
        datePane.add(yearTF);
        
        //Adding components to panel
        topPane.add(titleLab);
        
        gc.gridx = 0;
        gc.gridy = 0;
        centerPane.add(fNameLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        centerPane.add(fNameTF, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        centerPane.add(lNameLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        centerPane.add(lNameTF, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        centerPane.add(joinLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        centerPane.add(datePane, gc);
        
        gc.gridx = 0;
        gc.gridy = 3;
        centerPane.add(posLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        centerPane.add(posCB, gc);
        
        gc.gridx = 0;
        gc.gridy = 4;
        centerPane.add(salaryLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 4;
        centerPane.add(salaryTF, gc);
        
        gc.gridx = 0;
        gc.gridy = 5;
        centerPane.add(typeLab, gc);
        
        gc.gridx = 1;
        gc.gridy = 5;
        centerPane.add(typeCB, gc);
        
        bottomPane.add(additBtn);
        bottomPane.add(backBtn);
        
        //Adding Panel to Container
        contain.add(topPane, BorderLayout.NORTH);
        contain.add(centerPane, BorderLayout.CENTER);
        contain.add(bottomPane, BorderLayout.SOUTH);
        
        addListener(new handler());
    }
    
    public void addListener(ActionListener listenForBtn)
    {
        additBtn.addActionListener(listenForBtn);
        backBtn.addActionListener(listenForBtn);
    }
    
    public class handler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            if(evt.getSource() == additBtn)
            {
                String fNtemp, lNtemp;
                int saltemp, postemp, typetemp, daytemp, monthtemp, yeartemp;
                Date jointemp;
                
                fNtemp = fNameTF.getText();
                lNtemp = lNameTF.getText();
                daytemp = dayCB.getSelectedIndex() + 1;
                monthtemp = monthCB.getSelectedIndex() + 1;
                yeartemp = Integer.parseInt(yearTF.getText());
                saltemp = Integer.parseInt(salaryTF.getText());
                postemp = posCB.getSelectedIndex() + 1;
                typetemp = typeCB.getSelectedIndex() + 1;
                
                //if add
                if(addit == 1)
                {
                    //generate empID
                    int tempNum;
                    Employee temp = Driver.employees.get(Driver.employees.size() - 1);
                    
                    tempNum = Integer.parseInt(temp.getEmpID().substring(1));
                    tempNum++;
                    
                    if(tempNum < 10)
                    {
                        tempID = "E00" + Integer.toString(tempNum);
                    }
                    
                    else if(tempNum >= 10 && tempNum < 100)
                    {
                        tempID = "E0" + Integer.toString(tempNum);
                    }
                    
                    else if(tempNum >= 100)
                    {
                        tempID = "E" + Integer.toString(tempNum);
                    }
                    
                    //Adding employee to database
                    Driver.database.addEmployee(tempID, fNtemp, lNtemp, daytemp, monthtemp, yeartemp, postemp,saltemp, typetemp);
                    
                    //Adding employee to arraylist
                    Driver.employees.add(new Employee(tempID, fNtemp, lNtemp, daytemp, monthtemp, yeartemp, postemp,saltemp, typetemp));
                    
                    dispose();
                    new SAMenu();
                }
                
                //if edit
                else
                {
                    int i;
                    
                    for(i = 0; i < Driver.employees.size(); i++)
                    {
                        if(Driver.employees.get(i).getEmpID() == tempID)
                        {
                            break;
                        }
                    }
                    
                    //update employee to database
                    Driver.database.updateEmployee(tempID, fNtemp, lNtemp, daytemp, monthtemp, yeartemp, postemp,saltemp, typetemp);
                    
                    //update employee to arraylist
                    Driver.employees.get(i).setfName(fNtemp);
                    Driver.employees.get(i).setlName(fNtemp);
                    Driver.employees.get(i).getJoinDate().setDate(daytemp);
                    Driver.employees.get(i).getJoinDate().setMonth(monthtemp - 1);
                    Driver.employees.get(i).getJoinDate().setYear(yeartemp - 1900);
                    Driver.employees.get(i).setPosition(postemp);
                    Driver.employees.get(i).setSalary(saltemp);
                    Driver.employees.get(i).setType(typetemp);
                    
                    dispose();
                }
            }
            
            else if(evt.getSource() == backBtn)
            {
                dispose();
                new SAMenu();
            }
        }
    }
}
