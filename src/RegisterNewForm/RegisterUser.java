/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegisterNewForm;

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
import newuserlogin.newuserlogin;
import LoginForm.Login;
import strengthcheck.strengthcheck;
import GeneratorFrame.GeneratorFrame;
import java.awt.Component;
public class RegisterUser extends JFrame{
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JPasswordField retypepasswordField;
    private JButton btnNewButton;
    private JButton btnbacktoLogButton;
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
                    RegisterUser frame = new RegisterUser();
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
    public RegisterUser() {
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

        JLabel lblNewLabel1 = new JLabel("Register New User");
        lblNewLabel1.setForeground(Color.BLACK);
        lblNewLabel1.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        lblNewLabel1.setBounds(410, 153, 800, 93);
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
        
        retypepasswordField = new JPasswordField();
        retypepasswordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        retypepasswordField.setBounds(360, 502, 540, 68);
        contentPane.add(retypepasswordField);

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
        
        JLabel lblretypePassword = new JLabel("Re-type Pass");
        lblretypePassword.setForeground(Color.BLACK);
        lblretypePassword.setBackground(Color.CYAN);
        lblretypePassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblretypePassword.setBounds(90, 502, 200, 52);
        contentPane.add(lblretypePassword);
        
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

        btnNewButton = new JButton("Register");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(360, 606, 162, 73);
        btnNewButton.addActionListener((ActionEvent e) -> {
            String userName = textField.getText();
            String password = new String(passwordField.getPassword());
            String repassword = new String(retypepasswordField.getPassword());
            if (!password.equals(repassword)){
                JOptionPane.showMessageDialog(btnNewButton, "Password and re-type password do not match");
            }
            else{
                int passcheck=strengthcheck.main(password);
                if (passcheck<=2){
                    JOptionPane.showMessageDialog(btnNewButton, "Your password is weak, it should contain...");
                }
                else{
                    int rs=newuserlogin.connecttodb(userName,password,userName+password);
                    if (rs==1) {
                        dispose();
                        Login loginframe = new Login();
                        loginframe.setTitle("Login Page");
                        loginframe.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully registered");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "There is something wrong with us");
                    }
                }
            }
        });

        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
        btnbacktoLogButton = new JButton("<- Login Page");
        btnbacktoLogButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnbacktoLogButton.setBounds(18, 27, 180, 73);
        btnbacktoLogButton.addActionListener((ActionEvent e) -> {
            //Add Login frame into this
            dispose();
            Login loginframe = new Login();
            loginframe.setTitle("Login Page");
            loginframe.setVisible(true);
        });
        contentPane.add(btnbacktoLogButton);

        label1 = new JLabel("");
        label1.setBounds(0, 0, 1008, 562);
        contentPane.add(label1);
    }
}
