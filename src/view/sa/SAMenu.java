/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import view.Calculate;
import view.Login;
import view.ViewEmployee;

/**
 *
 * @author EdwardLeonardi
 */
public class SAMenu extends JFrame {
    private JButton viewEmpBtn, addEmpBtn, payrollBtn, calcBtn, logout;
    private Container contain;
    private JPanel topPane, bottomPane;
    
    public SAMenu()
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
        //Creating Panel
        contain = getContentPane();
        contain.setLayout(new BorderLayout());
        
        //Adding Panel
        topPane = new JPanel();
        topPane.setBorder(new EmptyBorder(10, 50, 10, 50));
        topPane.setLayout(new FlowLayout());
        bottomPane = new JPanel();
        bottomPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        bottomPane.setLayout(new FlowLayout());
        
        //Initialize components
        viewEmpBtn = new JButton("View", new ImageIcon("images/employeeList.png"));
        viewEmpBtn.setPreferredSize(new Dimension(90, 80));
        viewEmpBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        viewEmpBtn.setVerticalAlignment(SwingConstants.BOTTOM);
        viewEmpBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        addEmpBtn = new JButton("Add", new ImageIcon("images/addEmployee.png"));
        addEmpBtn.setPreferredSize(new Dimension(90, 80));
        addEmpBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        addEmpBtn.setVerticalAlignment(SwingConstants.BOTTOM);
        addEmpBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        payrollBtn = new JButton("Payroll", new ImageIcon("images/payroll.png"));
        payrollBtn.setPreferredSize(new Dimension(90, 80));
        payrollBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        payrollBtn.setVerticalAlignment(SwingConstants.BOTTOM);
        payrollBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        calcBtn = new JButton("Calculate", new ImageIcon("images/calc.png"));
        calcBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        calcBtn.setVerticalAlignment(SwingConstants.BOTTOM);
        calcBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        logout = new JButton("Log Out");
        logout.setPreferredSize(new Dimension(90, 30));
        
        //Adding components to panel
        topPane.add(Box.createRigidArea(new Dimension(0,100)));
        topPane.add(viewEmpBtn);
        topPane.add(addEmpBtn);
        topPane.add(payrollBtn);
        topPane.add(calcBtn);
        bottomPane.add(logout);
        
        //Adding Panel to Container
        contain.add(topPane, BorderLayout.NORTH);
        contain.add(bottomPane, BorderLayout.SOUTH);
        
        addListener(new handler());
    }
    
    public void addListener(ActionListener listenForBtn)
    {
        logout.addActionListener(listenForBtn);
        viewEmpBtn.addActionListener(listenForBtn);
        addEmpBtn.addActionListener(listenForBtn);
        payrollBtn.addActionListener(listenForBtn);
        calcBtn.addActionListener(listenForBtn);
    }
    
    public class handler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            if(evt.getSource() == logout)
            {
                dispose();
                new Login();
            }
            
            else if(evt.getSource() == viewEmpBtn)
            {
                dispose();
                new ViewEmployee();
            }
            
            else if(evt.getSource() == addEmpBtn)
            {
                dispose();
                new Addit(1);
            }
            
            else if(evt.getSource() == payrollBtn)
            {
                dispose();
                //new Payroll();
            }
            
            else if(evt.getSource() == calcBtn)
            {
                dispose();
                new Calculate();
            }
        }
    }
}
