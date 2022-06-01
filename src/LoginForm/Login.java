/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginForm;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import olduserlogin.olduserlogin;
import RegisterNewForm.RegisterUser;
import UserHome.UserHome;
import GeneratorFrame.GeneratorFrame;
public class Login extends JFrame{
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JButton btnRegButton;
    private JLabel label;
    private JLabel label1;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(270, 90, 1014, 720);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel TitleLabel = new JLabel("EzPassW");
        TitleLabel.setForeground(Color.BLACK);
        TitleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        TitleLabel.setBounds(410, 18, 810, 90);
        contentPane.add(TitleLabel);
        
        JLabel AuthorLabel = new JLabel("By Hoang Dao");
        AuthorLabel.setForeground(Color.BLACK);
        AuthorLabel.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        AuthorLabel.setBounds(410, 63, 810, 90);
        contentPane.add(AuthorLabel);

        JLabel lblNewLabel1 = new JLabel("Login");
        lblNewLabel1.setForeground(Color.BLACK);
        lblNewLabel1.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        lblNewLabel1.setBounds(423, 153, 273, 93);
        contentPane.add(lblNewLabel1);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(360, 270, 540, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(360, 386, 540, 68);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(110, 270, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(110, 386, 193, 52);
        contentPane.add(lblPassword);
        
        JButton genButton = new JButton("Password Generator");
        genButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        genButton.setBounds(720, 18, 216, 54);
        genButton.addActionListener(new ActionListener(){
            //dispose();
            public void actionPerformed(ActionEvent e){
                GeneratorFrame genpage=new GeneratorFrame();
                genpage.setTitle("Generator Page");
                genpage.setVisible(true);
            }
        });
        contentPane.add(genButton);

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(360, 490, 162, 73);
        btnNewButton.addActionListener((ActionEvent e) -> {
            String userName = textField.getText();
            String password = new String(passwordField.getPassword());
            String rs=olduserlogin.connecttodb(userName,password);
            if (rs!=null) {
                dispose();
                UserHome homeframe = new UserHome(userName,password);
                homeframe.setTitle("Welcome");
                homeframe.setVisible(true);
                JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
            } else {
                JOptionPane.showMessageDialog(btnNewButton, "Wrong Username or Password");
            }
        });

        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
        
        btnRegButton = new JButton("Register New User");
        btnRegButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnRegButton.setBounds(360, 580, 270, 73);
        btnRegButton.addActionListener((ActionEvent e) -> {
            //Add register frame into this
            dispose();
            RegisterUser regframe=new RegisterUser();
            regframe.setTitle("Register New User");
            regframe.setVisible(true);
            
        });
        contentPane.add(btnRegButton);

        label1 = new JLabel("");
        label1.setBounds(0, 0, 1008, 562);
        contentPane.add(label1);
    }
}
