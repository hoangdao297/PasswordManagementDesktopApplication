/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewAccountObject;

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
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import ViewAccountList.*;
import DeleteObjectAccount.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import GeneratorFrame.*;
import java.awt.event.ActionListener;
import ModifyObjectAccount.*;
public class ViewAccountObjectFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static String userhashcode;
    public ViewAccountObjectFrame(String user,String userpass,String apptitle, String username){
        this.userhashcode=user+userpass;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(270, 90, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel pagetitle=new JLabel();
        pagetitle.setText("View Account Information");
        pagetitle.setFont(new Font("Tahoma", Font.PLAIN, 27));
        pagetitle.setBounds(360, 27, 360, 63);
        contentPane.add(pagetitle);
        
        JButton btnbacktoViewButton = new JButton("View Account List");
        btnbacktoViewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnbacktoViewButton.setBounds(18, 27, 153, 54);
        btnbacktoViewButton.addActionListener((ActionEvent e) -> {
            dispose();
            ViewAccountListFrame viewframe = new ViewAccountListFrame(user,userpass);
            viewframe.setTitle("View Account Page");
            viewframe.setVisible(true);
        });
        contentPane.add(btnbacktoViewButton);
        
        JButton genpassButton = new JButton("Password Generator");
        genpassButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        genpassButton.setBounds(18, 81, 207, 54);
        genpassButton.addActionListener(new ActionListener() {
            //dispose();
            @Override
            public void actionPerformed(ActionEvent e) {
                GeneratorFrame genframe = new GeneratorFrame();
                genframe.setTitle("Password Generator");
                genframe.setVisible(true);
            }
        });
        contentPane.add(genpassButton);
        
        ArrayList<String> info=ViewAccountObject.connecttodb(user+userpass,apptitle,username);
        if (info!=null){
                
        JLabel apptitleLabel=new JLabel();
        apptitleLabel.setText("App title");
        apptitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
        apptitleLabel.setBounds(180, 162, 360, 36);
        contentPane.add(apptitleLabel);
        JTextArea apptitleField = new JTextArea();
        apptitleField.setText(info.get(0));
        apptitleField.setFont(new Font("Tahoma", Font.PLAIN, 27));
        apptitleField.setBounds(360, 162, 540, 45);
        contentPane.add(apptitleField);
        apptitleField.setColumns(10);
        
        JLabel usernameLabel=new JLabel();
        usernameLabel.setText("Username");
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
        usernameLabel.setBounds(180, 243, 360, 36);
        contentPane.add(usernameLabel);
        JTextArea usernameField = new JTextArea();
        usernameField.setText(info.get(1));
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 27));
        usernameField.setBounds(360, 243, 540, 45);
        contentPane.add(usernameField);
        usernameField.setColumns(10);
        
        JLabel passLabel=new JLabel();
        passLabel.setText("Password");
        passLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
        passLabel.setBounds(180, 315, 360, 36);
        contentPane.add(passLabel);
        JTextArea passField = new JTextArea();
        passField.setText(info.get(2));
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
        urlField.setText(info.get(3));
        urlField.setFont(new Font("Tahoma", Font.PLAIN, 27));
        urlField.setBounds(360, 414, 540, 45);
        contentPane.add(urlField);
        urlField.setColumns(10);
        
        JLabel dateLabel=new JLabel();
        dateLabel.setText("Last Update");
        dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
        dateLabel.setBounds(180, 504, 360, 36);
        contentPane.add(dateLabel);
        JTextArea dateField = new JTextArea();
        dateField.setText(info.get(4));
        dateField.setFont(new Font("Tahoma", Font.PLAIN, 27));
        dateField.setBounds(360, 504, 540, 45);
        contentPane.add(dateField);
        dateField.setColumns(10);
        }
        else JOptionPane.showMessageDialog(null,"Error");
        
        JButton delButton = new JButton("Delete Account");
        delButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        delButton.setBounds(739, 27, 153, 54);
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(delButton, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    int delrs=DeleteObject.deleteindb(user+userpass, info.get(0), info.get(1));
                    if (delrs==1) {
                        JOptionPane.showMessageDialog(null, "Successfully Deleted");
                        dispose();
                        ViewAccountListFrame viewframe = new ViewAccountListFrame(user,userpass);
                        viewframe.setTitle("View Account Page");
                        viewframe.setVisible(true);
                    }
                    else if (delrs==2) JOptionPane.showMessageDialog(null, "Not Found");
                    else JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
        contentPane.add(delButton);
        
        JButton modButton = new JButton("Modify Account");
        modButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        modButton.setBounds(739, 81, 153, 54);
        modButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                ModifyObjectFrame modframe=new ModifyObjectFrame(user,userpass,info.get(0),info.get(1),info.get(2));
                modframe.setTitle("Modify page");
                modframe.setVisible(true);
                }
        });
        contentPane.add(modButton);
    }
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //ViewAccountObjectFrame frame=new ViewAccountObjectFrame("haha","haha","haha","haha");
                    //frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
