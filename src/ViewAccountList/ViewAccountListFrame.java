
package ViewAccountList;

/**
 *
 * @author hoangdao
 */
import UserHome.UserHome;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import CreateNewObjectAccount.*;
import ViewAccountObject.*;
public class ViewAccountListFrame extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static String userhashcode;
    public ViewAccountListFrame(String username,String password){
        this.userhashcode=username+password;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(270, 90, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnbacktoLogButton = new JButton("<- Home Page");
        btnbacktoLogButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnbacktoLogButton.setBounds(18, 27, 153, 54);
        btnbacktoLogButton.addActionListener((ActionEvent e) -> {
            dispose();
            UserHome homeframe = new UserHome(username,password);
            homeframe.setTitle("Home Page");
            homeframe.setVisible(true);
        });
        contentPane.add(btnbacktoLogButton);
        
        JLabel title=new JLabel();
        title.setText("Account List to View");
        title.setFont(new Font("Tahoma", Font.PLAIN, 27));
        title.setBounds(630, 45, 360, 27);
        contentPane.add(title);
        
        JButton button = new JButton("Add Account");
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddAccountFrame addframe=new AddAccountFrame(username,password);
                addframe.setTitle("Add page");
                addframe.setVisible(true);
            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 27));
        button.setBounds(252, 162, 180, 53);
        contentPane.add(button);
        
        ArrayList<String> listname= QueryAccountNameList.connecttodb(ViewAccountListFrame.userhashcode);
        if (listname==null){
            JLabel errordisplay=new JLabel();
            errordisplay.setText("There is some error");
            errordisplay.setFont(new Font("Tahoma", Font.PLAIN, 27));
            errordisplay.setBounds(630, 72, 360, 36);
            contentPane.add(errordisplay);
        }
        else if (listname.isEmpty()){
            JLabel nonetitle=new JLabel();
            nonetitle.setText("There is no account yet");
            nonetitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
            nonetitle.setBounds(630, 90, 360, 36);
            contentPane.add(nonetitle);
        }
        else{
            JList<String> accountJList;
            String[] arrayofaccount=new String[listname.size()];
            for (int i = 0; i < listname.size(); i++) arrayofaccount[i] = listname.get(i);
            accountJList = new JList<>(arrayofaccount);
            accountJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            accountJList.setFont(new Font("Tahoma", Font.PLAIN, 18));
            accountJList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
            if (me.getClickCount() == 1) {
               JList target = (JList)me.getSource();
               int index = target.locationToIndex(me.getPoint());
               if (index >= 0) {
                  Object item = target.getModel().getElementAt(index);
                  String[] AppandUsername=item.toString().split("-",2);
                  dispose();
                  ViewAccountObjectFrame viewframe=new ViewAccountObjectFrame(username,password,AppandUsername[0],AppandUsername[1]);
                  viewframe.setTitle("Viewing page");
                  viewframe.setVisible(true);
               }
            }
         }
      });
            JScrollPane scrollPane = new JScrollPane(accountJList);
            scrollPane.setBounds(630, 90, 360, 450);
            contentPane.add(scrollPane);
        }
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewAccountListFrame frame = new ViewAccountListFrame("HoangJackDao","@Jack2972001");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private ViewAccountListFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
