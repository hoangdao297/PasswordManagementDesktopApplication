/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserHome;

/**
 *
 * @author hoangdao
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import LoginForm.Login;
import userchangepassword.ChangePassFrame;
import GeneratorFrame.GeneratorFrame;
import ViewAccountList.*;
public class UserHome extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static String username;
    private static String pass;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserHome frame = new UserHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserHome() {

    }

    /**
     * Create the frame.
     */
    public UserHome(String userName,String password) {
        this.username=userName; this.pass=password;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(270, 90, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JButton btnNewButton = new JButton("Logout");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    Login obj = new Login();
                    obj.setTitle("Login");
                    obj.setVisible(true);
                }
            }
        });
        btnNewButton.setBounds(18, 27, 118, 36);
        contentPane.add(btnNewButton);
        
        JButton button = new JButton("Change-password\r\n");
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println(pass);
                ChangePassFrame passframe = new ChangePassFrame(username,pass);
                passframe.setTitle("Change Password");
                passframe.setVisible(true);
                if (passframe.returnnewpass()!=null){
                    pass=passframe.returnnewpass();
                }
            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 18));
        button.setBounds(18, 81, 162, 36);
        contentPane.add(button);
        
        JButton generatepass = new JButton("Password Generator");
        generatepass.setBackground(UIManager.getColor("Button.disabledForeground"));
        generatepass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Put password generator here
                dispose();
                GeneratorFrame genpage=new GeneratorFrame(username,pass);
                genpage.setTitle("Generator Page");
                genpage.setVisible(true);
            }
        });
        generatepass.setFont(new Font("Tahoma", Font.PLAIN, 36));
        generatepass.setBounds(450, 81, 360, 54);
        contentPane.add(generatepass);
        
        JButton viewaccountlist = new JButton("View Account List");
        viewaccountlist.setBackground(UIManager.getColor("Button.disabledForeground"));
        viewaccountlist.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Put password generator here
                dispose();
                ViewAccountListFrame viewpage=new ViewAccountListFrame(username,pass);
                viewpage.setTitle("Viewing List Page");
                viewpage.setVisible(true);
            }
        });
        viewaccountlist.setFont(new Font("Tahoma", Font.PLAIN, 36));
        viewaccountlist.setBounds(450, 162, 360, 54);
        contentPane.add(viewaccountlist);
    }
}
