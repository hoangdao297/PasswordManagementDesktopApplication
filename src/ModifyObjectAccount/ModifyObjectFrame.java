/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModifyObjectAccount;

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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import ViewAccountObject.*;
import java.text.SimpleDateFormat;  
import java.util.Date;
public class ModifyObjectFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public ModifyObjectFrame(String user, String userpass,String appname,String username,String password){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(270, 90, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel pagetitle=new JLabel();
        pagetitle.setText("Modify Account Information");
        pagetitle.setFont(new Font("Tahoma", Font.PLAIN, 27));
        pagetitle.setBounds(360, 27, 360, 63);
        contentPane.add(pagetitle);
        
        JLabel userins=new JLabel();
        userins.setText("Note: If you only want to add or change url, fill the url field and let the other fields blank");
        userins.setFont(new Font("Tahoma", Font.ITALIC, 12));
        userins.setBounds(289 ,72, 531,45);
        contentPane.add(userins);
        
        JButton viewaccountButton = new JButton("View Account");
        viewaccountButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        viewaccountButton.setBounds(18, 27, 153, 54);
        viewaccountButton.addActionListener((ActionEvent e) -> {
            dispose();
            ViewAccountObjectFrame viewframe = new ViewAccountObjectFrame(user,userpass,appname,username);
            viewframe.setTitle("View Account Page");
            viewframe.setVisible(true);
        });
        contentPane.add(viewaccountButton);
        
        JLabel apptitleLabel=new JLabel();
        apptitleLabel.setText("App title:");
        apptitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        apptitleLabel.setBounds(90, 162, 360, 36);
        contentPane.add(apptitleLabel);
        JLabel appLabel=new JLabel();
        appLabel.setText(appname);
        appLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        appLabel.setBounds(252, 162, 360, 36);
        contentPane.add(appLabel);
        
        JLabel usernameLabel=new JLabel();
        usernameLabel.setText("Username:");
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        usernameLabel.setBounds(90, 225, 360, 36);
        contentPane.add(usernameLabel);
        JLabel userLabel=new JLabel();
        userLabel.setText(username);
        userLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        userLabel.setBounds(252, 225, 360, 36);
        contentPane.add(userLabel);
        
        JLabel newpassLabel=new JLabel();
        newpassLabel.setText("New password (if applicable):");
        newpassLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        newpassLabel.setBounds(90, 286, 360, 36);
        contentPane.add(newpassLabel);
        JTextField newpassField = new JTextField();
        newpassField.setFont(new Font("Tahoma", Font.PLAIN, 27));
        newpassField.setBounds(423, 286, 540, 45);
        contentPane.add(newpassField);
        newpassField.setColumns(10);
        
        JLabel renewpassLabel=new JLabel();
        renewpassLabel.setText("Re-type new password:");
        renewpassLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        renewpassLabel.setBounds(90, 347, 360, 36);
        contentPane.add(renewpassLabel);
        JTextField repassField = new JTextField();
        repassField.setFont(new Font("Tahoma", Font.PLAIN, 27));
        repassField.setBounds(423, 347, 540, 45);
        contentPane.add(repassField);
        repassField.setColumns(10);
        
        JLabel urlLabel=new JLabel();
        urlLabel.setText("URL (if applicable):");
        urlLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        urlLabel.setBounds(90, 408, 360, 36);
        contentPane.add(urlLabel);
        JTextField urlField = new JTextField();
        urlField.setFont(new Font("Tahoma", Font.PLAIN, 27));
        urlField.setBounds(423, 408, 540, 45);
        contentPane.add(urlField);
        urlField.setColumns(10);
        
        JButton modifyButton = new JButton("Modify");
        modifyButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        modifyButton.setBounds(420, 469, 153, 54);
        modifyButton.addActionListener((ActionEvent e) -> {
            Date date = new Date();  
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
            String strDate = formatter.format(date);
            
            String newpassget=newpassField.getText();
            String repassget=repassField.getText();
            String urlget=urlField.getText();
            boolean bigcond= ((newpassget.equals(""))&& (repassget.equals(""))) ||(urlget.equals(""));
            if (!bigcond) JOptionPane.showMessageDialog(null,"Missing fields to modify");
            else{
                int rs=0;
                if ((newpassget.equals(""))&& (repassget.equals(""))){
                    rs=ModifyObject.modifyindb(user+userpass, appname, username, password,urlget, strDate);}
                else{
                    if (!newpassget.equals(repassget)) JOptionPane.showMessageDialog(null,"Password and re-type password do not match");
                    else {
                        rs=ModifyObject.modifyindb(user+userpass,appname,username,newpassget,strDate);}
                }
                if (rs==0 || rs==2) JOptionPane.showMessageDialog(null,"Error");
                else JOptionPane.showMessageDialog(null,"Modified Successfully");
            }
        });
        contentPane.add(modifyButton);
        
    }
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //ModifyObjectFrame frame=new ModifyObjectFrame();
                    //frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
