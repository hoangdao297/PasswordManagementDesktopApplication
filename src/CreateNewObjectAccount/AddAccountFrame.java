/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreateNewObjectAccount;

/**
 *
 * @author hoangdao
 */
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import UserHome.UserHome;
import ViewAccountList.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  
public class AddAccountFrame extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static String userhashcode;
    public AddAccountFrame(String username, String password){
        this.userhashcode=username+password;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(270, 90, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel pagetitle=new JLabel();
        pagetitle.setText("Add Account Information");
        pagetitle.setFont(new Font("Tahoma", Font.PLAIN, 27));
        pagetitle.setBounds(360, 27, 360, 63);
        contentPane.add(pagetitle);
        
        JButton btnbacktoHomeButton = new JButton("<- Home Page");
        btnbacktoHomeButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnbacktoHomeButton.setBounds(18, 18, 153, 54);
        btnbacktoHomeButton.addActionListener((ActionEvent e) -> {
            //Add Login frame into this
            dispose();
            UserHome homeframe = new UserHome(username,password);
            homeframe.setTitle("Home Page");
            homeframe.setVisible(true);
        });
        contentPane.add(btnbacktoHomeButton);
        
        JButton btnbacktoViewButton = new JButton("View Account List");
        btnbacktoViewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnbacktoViewButton.setBounds(18, 72, 153, 54);
        btnbacktoViewButton.addActionListener((ActionEvent e) -> {
            //Add Login frame into this
            dispose();
            ViewAccountListFrame viewframe = new ViewAccountListFrame(username,password);
            viewframe.setTitle("View Account Page");
            viewframe.setVisible(true);
        });
        contentPane.add(btnbacktoViewButton);
        
        JLabel apptitleLabel=new JLabel();
        apptitleLabel.setText("App title");
        apptitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
        apptitleLabel.setBounds(180, 162, 360, 36);
        contentPane.add(apptitleLabel);
        JTextField apptitleField = new JTextField();
        apptitleField.setFont(new Font("Tahoma", Font.PLAIN, 27));
        apptitleField.setBounds(360, 162, 540, 45);
        contentPane.add(apptitleField);
        apptitleField.setColumns(10);
        
        JLabel usernameLabel=new JLabel();
        usernameLabel.setText("Username");
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
        usernameLabel.setBounds(180, 243, 360, 36);
        contentPane.add(usernameLabel);
        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 27));
        usernameField.setBounds(360, 243, 540, 45);
        contentPane.add(usernameField);
        usernameField.setColumns(10);
        
        JLabel passLabel=new JLabel();
        passLabel.setText("Password");
        passLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
        passLabel.setBounds(180, 315, 360, 36);
        contentPane.add(passLabel);
        JTextField passField = new JTextField();
        passField.setFont(new Font("Tahoma", Font.PLAIN, 27));
        passField.setBounds(360, 315, 540, 45);
        contentPane.add(passField);
        passField.setColumns(10);
        
        JLabel urlLabel=new JLabel();
        urlLabel.setText("URL (optional)");
        urlLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
        urlLabel.setBounds(180, 414, 360, 36);
        contentPane.add(urlLabel);
        JTextField urlField = new JTextField();
        urlField.setFont(new Font("Tahoma", Font.PLAIN, 27));
        urlField.setBounds(360, 414, 540, 45);
        contentPane.add(urlField);
        urlField.setColumns(10);
        
        JButton addButton = new JButton("Add");
        addButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        addButton.setBounds(360, 504, 153, 54);
        addButton.addActionListener((ActionEvent e) -> {
           String apptitle=apptitleField.getText();
           String usernameget=usernameField.getText();
           String pass=passField.getText();
           String url=urlField.getText();
           if (apptitle==null || pass==null||usernameget==null|| apptitle.equals("")||pass.equals("")||usernameget.equals("")){
               JOptionPane.showMessageDialog(addButton,"Missing field");
           }
           else{
               Date date = new Date();  
               SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
               String strDate = formatter.format(date);  
               int rs;
               if (url==null||url.equals("")){
                   rs=CreateObjectAccount.createindb(AddAccountFrame.userhashcode,apptitle,usernameget,pass,strDate);
               }
               else{
                   rs = CreateObjectAccount.createindb(AddAccountFrame.userhashcode,apptitle,usernameget,pass,url,strDate);
               }
               switch (rs) {
                   case 0:
                       JOptionPane.showMessageDialog(addButton,"There is some error");
                       break;
                   case 1:
                       JOptionPane.showMessageDialog(addButton,"Successfully added");
                       break;
                   default:
                       JOptionPane.showMessageDialog(addButton,"Account already existed");
                       break;
               }
           }
        });
        contentPane.add(addButton);
    }
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddAccountFrame frame = new AddAccountFrame("HoangJackDao","@Jack2972001");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
