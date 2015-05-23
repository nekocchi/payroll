/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import model.Driver;
import view.sa.SAMenu;
import view.table.ViewEmpTableModel;

/**
 *
 * @author EdwardLeonardi
 */
public class ViewEmployee extends JFrame{
    private JTable table;
    private JScrollPane scrollTable;
    private ViewEmpTableModel model;
    private JButton back;
    private JPanel centerPane, bottomPane;
    private Container contain;
    private Object[] options = {"Edit", "Delete"};
    
    public ViewEmployee()
    {
        super("Payroll");
        
        //setIconImage(new ImageIcon("").getImage());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initcomponents();
        
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void initcomponents()
    {
        //Creating container to Frame
        contain = getContentPane();
        contain.setLayout(new BorderLayout());
        
        //initializing components
        model = new ViewEmpTableModel();
        table = new JTable(model);
        scrollTable = new JScrollPane(table);
        back = new JButton("Back");
        back.setPreferredSize(new Dimension(90, 30));
        
        //initialize panels
        centerPane = new JPanel();
        centerPane.setBorder(new EmptyBorder(10, 30, 10, 30));
        centerPane.setLayout(new FlowLayout());
        bottomPane = new JPanel();
        bottomPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        bottomPane.setLayout(new FlowLayout());
        
        //adding components to panel
        centerPane.add(scrollTable);
        bottomPane.add(back);
        
        //adding panels to container
        contain.add(centerPane, BorderLayout.CENTER);
        contain.add(bottomPane, BorderLayout.SOUTH);
        
        back.addActionListener(new handler());
        table.addMouseListener(new mouseHandler());
    }
    
    public class handler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            if(evt.getSource() == back)
            {
                dispose();
                new SAMenu();
            }
        }
    }
    
    public class mouseHandler extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent evt)
        {
            if (evt.getClickCount() == 2)
            {
                int row = table.getSelectedRow();
                
                int reply = JOptionPane.showOptionDialog(centerPane, "What would you like to do?", "Employee Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                
                if(reply == JOptionPane.YES_OPTION)
                {
                    System.out.println("a");
                }
                
                else if(reply == JOptionPane.NO_OPTION)
                {
                    Driver.database.deleteEmployee(Driver.employees.get(row).getEmpID());
                    Driver.employees.remove(row);
                }
            }
        }
    }
}
