package view;

//import View.Member.Member;
import model.Driver;
import model.User;
//import View.Librarian.Librarian;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.*;
import view.sa.SAMenu;

public class Login extends JFrame
{
    private JLabel ID, password;
    private JTextField IDField;
    private JPasswordField PWField;
    private JButton loginButton, exitButton;
    private Container contain;
    private JPanel centerPane, bottomPane;
    private GridBagConstraints gc;
    
    private static String cNum;
    
    public Login()
    {
        //Set Title
        super("Payroll");
        
        setIconImage(new ImageIcon("images/JLMSLogo.png").getImage());
        
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
        
        //Adding Panel
        centerPane = new JPanel();
        centerPane.setLayout(new GridBagLayout());
        bottomPane = new JPanel();
        bottomPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        bottomPane.setLayout(new FlowLayout());
        
        //Initialize Grid Bag Constraints
        gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 25, 10, 25);
        
        //Initializing Components
        ID = new JLabel("ID :");
        password = new JLabel("Password :");
        IDField = new JTextField();
        IDField.setPreferredSize(new Dimension(300, 30));
        PWField = new JPasswordField();
        PWField.setPreferredSize(new Dimension(300, 30));
        loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(90, 30));
        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(90, 30));
        
        //Adding Components to Panel
        gc.gridx = 0;
        gc.gridy = 0;
        centerPane.add(ID, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        centerPane.add(IDField, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        centerPane.add(password, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        centerPane.add(PWField, gc);
        
        bottomPane.add(loginButton);
        bottomPane.add(exitButton);
        
        //Adding Panel to Container
        contain.add(centerPane, BorderLayout.CENTER);
        contain.add(bottomPane, BorderLayout.SOUTH);
        
        //Adding Listener
        addListener(new handler(), new keyhandler());
    }
    
    public void addListener(ActionListener listenforbtn, KeyListener listenforkey)
    {
        loginButton.addActionListener(listenforbtn);
        PWField.addKeyListener(listenforkey);
        exitButton.addActionListener(listenforbtn);
    }
    
    public class handler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            int type = 0;
            String id;
            char[] pw;
            boolean userFound = false;
            
            if(evt.getSource() == loginButton)
            {
                try
                {
                    id = IDField.getText();
                    pw = PWField.getPassword();
                    
                    //checking users arraylist for id and password
                    for(User elements : Driver.users)
                    {
                        if(elements.getID().equals(id))
                        {
                            if(elements.getPassword().equals(new String(pw)))
                            {
                                userFound = true;
                                type = elements.getType();
                                cNum = id;
                                break;
                            }
                        }
                    }
                    
                    //if owner found
                    if(userFound && type == 1)
                    {
                        dispose();
                        new SAMenu();
                    }
                    
                    //if manager found
                    else if(userFound && type == 2)
                    {
                        dispose();
                        new SAMenu();
                    }
                    
                    //if user does not exist
                    else if(!userFound)
                    {
                        JOptionPane.showMessageDialog(null, "Wrong ID/Password!");
                    }
                }
                
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Invalid Input! Please enter ID with your Card Number");
                }
                
                catch(Exception ex)
                {
                    System.out.println("Error : "+ex);
                }
            }
            
            else if(evt.getSource() == exitButton)
            {
                dispose();
            }
        }
    }
    
    public class keyhandler implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e)
        {
            
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            int type = 0;
            String id;
            char[] pw;
            boolean userFound = false;
            
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                try
                {
                    id = IDField.getText();
                    pw = PWField.getPassword();
                    
                    for(User elements : Driver.users)
                    {
                        if(elements.getID().equals(id))
                        {
                            if(elements.getPassword().equals(new String(pw)))
                            {
                                userFound = true;
                                type = elements.getType();
                                cNum = elements.getID();
                                break;
                            }
                        }
                    }
                    
                    if(userFound && type == 1)
                    {
                        dispose();
                        new SAMenu();
                    }
                    
                    else if(userFound && type == 2)
                    {
                        dispose();
                        new SAMenu();
                    }
                    
                    else if(!userFound)
                    {
                        JOptionPane.showMessageDialog(null, "Wrong ID/Password!");
                    }
                }
                
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Invalid Input! Please enter ID with your Card Number");
                }
                
                catch(Exception ex)
                {
                    System.out.println("Error : "+ex);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            
        }
    }
    
    public static String getcNum()
    {
        return cNum;
    }
}
