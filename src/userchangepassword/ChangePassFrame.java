/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userchangepassword;

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
import strengthcheck.strengthcheck;
public class ChangePassFrame extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField newpassField;
    private JTextField oldpassField;
    private JTextField retypenewpassField;
    private JLabel lblEnterNewPassword;
    private JLabel enteroldpass;
    private JLabel retypenewpass;
    private String newpassword=null;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @param username
     * @param password
     */
    public ChangePassFrame(String username,String password) {
        setBounds(270, 360, 1024, 360);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        newpassField = new JTextField();
        newpassField.setFont(new Font("Tahoma", Font.PLAIN, 34));
        newpassField.setBounds(373, 35, 609, 67);
        contentPane.add(newpassField);
        newpassField.setColumns(10);
        
        retypenewpassField = new JTextField();
        retypenewpassField.setFont(new Font("Tahoma", Font.PLAIN, 34));
        retypenewpassField.setBounds(373, 102, 609, 67);
        contentPane.add(retypenewpassField);
        retypenewpassField.setColumns(10);
        
        oldpassField = new JTextField();
        oldpassField.setFont(new Font("Tahoma", Font.PLAIN, 34));
        oldpassField.setBounds(373, 169, 609, 67);
        contentPane.add(oldpassField);
        oldpassField.setColumns(10);

        JButton btnSearch = new JButton("Enter");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newpass=newpassField.getText();
                String retypenewpass=retypenewpassField.getText();
                if (!newpass.equals(retypenewpass)){
                    JOptionPane.showMessageDialog(btnSearch, "Password and re-type password do not match");
                }
                else{
                    String oldpass=oldpassField.getText();
                    if (!oldpass.equals(password)){
                        JOptionPane.showMessageDialog(btnSearch, "Wrong password, unable to confirm");
                    }
                    else{
                        int passcheck=strengthcheck.main(newpass);
                        if (passcheck<=2){
                            JOptionPane.showMessageDialog(btnSearch, "Your password is weak, it should contain...");
                        }
                        else{
                            int rs=userchangepassword.connecttodb(username,password,newpass);
                            if (rs==1){
                                newpassword=newpass;
                                dispose();
                                JOptionPane.showMessageDialog(btnSearch, "You have successfully changed password");
                            }
                            else{
                                JOptionPane.showMessageDialog(btnSearch, "Cannot change password");
                            }
                        }
                    }
                }
            }
        });
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 29));
        btnSearch.setBackground(new Color(240, 240, 240));
        btnSearch.setBounds(438, 270, 170, 59);
        contentPane.add(btnSearch);

        lblEnterNewPassword = new JLabel("Enter New Password :");
        lblEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblEnterNewPassword.setBounds(45, 37, 326, 67);
        contentPane.add(lblEnterNewPassword);
        
        retypenewpass = new JLabel("Re-type New Password:");
        retypenewpass.setFont(new Font("Tahoma", Font.PLAIN, 30));
        retypenewpass.setBounds(45, 104, 326, 67);
        contentPane.add(retypenewpass);
        
        enteroldpass = new JLabel("Enter Old Password:");
        enteroldpass.setFont(new Font("Tahoma", Font.PLAIN, 30));
        enteroldpass.setBounds(45, 171, 326, 67);
        contentPane.add(enteroldpass);
    }
    public String returnnewpass(){
        return this.newpassword;
    }
}
