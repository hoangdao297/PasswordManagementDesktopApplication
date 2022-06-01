/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneratorFrame;

/**
 *
 * @author hoangdao
 */
import generatingpassword.Generator;
import LoginForm.Login;
import UserHome.UserHome;
import generatingpassword.Generator;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class GeneratorFrame extends JFrame implements ChangeListener{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GeneratorFrame frame = new GeneratorFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public GeneratorFrame(){
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(270, 90, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel l = new JLabel();
        JSlider b = new JSlider(10,26);
        b.setValue(0);
        b.setPaintTrack(true);
        b.setPaintTicks(true);
        b.setPaintLabels(true);
        b.setBounds(81, 360, 360, 36);
        l.setBounds(81, 388, 360, 36);
        l.setText("Number of characters in password: 10");
        l.setFont(new Font("Tahoma", Font.PLAIN, 18));
        // add slider to panel
        contentPane.add(l);
        contentPane.add(b);
        b.addChangeListener(e->{
            l.setText("Number of characters in password:" + b.getValue());
        });
        JTextField inp = new JTextField();
        inp.setFont(new Font("Tahoma", Font.PLAIN, 18));
        inp.setBounds(81, 270, 360, 27);
        contentPane.add(inp);
        //inp.setColumns(10);
        JLabel input=new JLabel();
        input.setText("Desired Phrase, if not let it blank");
        input.setFont(new Font("Tahoma", Font.PLAIN, 18));
        input.setBounds(81, 243, 360, 27);
        contentPane.add(input);
        
        /*JButton btnbacktoLogButton = new JButton("<- Login Page");
        btnbacktoLogButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnbacktoLogButton.setBounds(18, 27, 153, 54);
        btnbacktoLogButton.addActionListener((ActionEvent e) -> {
            //Add Login frame into this
            dispose();
            Login loginframe = new Login();
            loginframe.setTitle("Login Page");
            loginframe.setVisible(true);
        });
        contentPane.add(btnbacktoLogButton);*/
        
        Generator passmachine=new Generator((int)b.getValue());
        JTextArea generatedpass=new JTextArea();
        generatedpass.setText(passmachine.returnPass());
        generatedpass.setFont(new Font("Tahoma", Font.PLAIN, 18));
        generatedpass.setBounds(540,360,360,27);
        generatedpass.setEditable( false );
        contentPane.add(generatedpass);
        
        JLabel genlabel=new JLabel();
        genlabel.setText("Generated Password:");
        genlabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        genlabel.setBounds(540, 333, 360, 27);
        contentPane.add(genlabel);
        
        JButton genButton = new JButton("Generate");
        genButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        genButton.setBounds(540, 450, 153, 54);
        genButton.addActionListener((ActionEvent e) -> {
            String phrase=inp.getText();
            Generator passmachine2;
            if (phrase.equals("") || phrase==null){
                passmachine2=new Generator((int)b.getValue());
            }
            else{
                passmachine2=new Generator(phrase,(int)b.getValue());
            }
            generatedpass.setText(passmachine2.returnPass());
            generatedpass.setFont(new Font("Tahoma", Font.PLAIN, 18));
            generatedpass.setBounds(540,360,360,27);
            generatedpass.setEditable( false );
            contentPane.add(generatedpass);
        });
        contentPane.add(genButton);
        
    }
    
    public GeneratorFrame(String username,String password){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(270, 90, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel l = new JLabel();
        JSlider b = new JSlider(10,26);
        b.setValue(0);
        b.setPaintTrack(true);
        b.setPaintTicks(true);
        b.setPaintLabels(true);
        b.setBounds(81, 360, 360, 36);
        l.setBounds(81, 388, 360, 36);
        l.setText("Number of characters in password: 10");
        l.setFont(new Font("Tahoma", Font.PLAIN, 18));
        // add slider to panel
        contentPane.add(l);
        contentPane.add(b);
        b.addChangeListener(e->{
            l.setText("Number of characters in password:" + b.getValue());
        });
        JTextField inp = new JTextField();
        inp.setFont(new Font("Tahoma", Font.PLAIN, 18));
        inp.setBounds(81, 270, 360, 27);
        contentPane.add(inp);
        //inp.setColumns(10);
        JLabel input=new JLabel();
        input.setText("Desired Phrase, if not let it blank");
        input.setFont(new Font("Tahoma", Font.PLAIN, 18));
        input.setBounds(81, 243, 360, 27);
        contentPane.add(input);
        
        JButton btnbacktoLogButton = new JButton("<- Home Page");
        btnbacktoLogButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnbacktoLogButton.setBounds(18, 27, 153, 54);
        btnbacktoLogButton.addActionListener((ActionEvent e) -> {
            //Add Login frame into this
            dispose();
            UserHome homeframe = new UserHome(username,password);
            homeframe.setTitle("Home Page");
            homeframe.setVisible(true);
        });
        contentPane.add(btnbacktoLogButton);
        
        Generator passmachine=new Generator((int)b.getValue());
        JTextArea generatedpass=new JTextArea();
        generatedpass.setText(passmachine.returnPass());
        generatedpass.setFont(new Font("Tahoma", Font.PLAIN, 18));
        generatedpass.setBounds(540,360,360,27);
        generatedpass.setEditable( false );
        contentPane.add(generatedpass);
        
        JLabel genlabel=new JLabel();
        genlabel.setText("Generated Password:");
        genlabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        genlabel.setBounds(540, 333, 360, 27);
        contentPane.add(genlabel);
        
        JButton genButton = new JButton("Generate");
        genButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        genButton.setBounds(540, 450, 153, 54);
        genButton.addActionListener((ActionEvent e) -> {
            String phrase=inp.getText();
            Generator passmachine2;
            if (phrase.equals("") || phrase==null){
                passmachine2=new Generator((int)b.getValue());
            }
            else{
                passmachine2=new Generator(phrase,(int)b.getValue());
            }
            generatedpass.setText(passmachine2.returnPass());
            generatedpass.setFont(new Font("Tahoma", Font.PLAIN, 18));
            generatedpass.setBounds(540,360,360,27);
            generatedpass.setEditable( false );
            contentPane.add(generatedpass);
        });
        contentPane.add(genButton);
        
    }
    @Override
    public void stateChanged(ChangeEvent e)
    {
        //l.setText("value of Slider is =" + b.getValue());
    }
}
