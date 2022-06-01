package olduserlogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hoangdao
 */
//this class is for old user log in the database
public class olduserlogin {
    public static String connecttodb(String username, String password){
        Connection conn = null;
        Statement stm=null;
        String userhashcode=null;
        try {
            String url = "jdbc:sqlite://Users//hoangdao//Documents//Projects//DatabasePMA//user.db";
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            //System.out.println("Connection to SQLite has been established.");
            stm = conn.createStatement();
            String testsql="SELECT username,password,usercode FROM user where username='"+username+"'";
            ResultSet rs=stm.executeQuery(testsql);
            while (rs.next()) {
                if (rs.getString("username").equals(username)&&rs.getString("password").equals(password)){
                    //System.out.println("Log in successfully");
                    userhashcode=rs.getString("usercode");
                    break;
                }
            }
            stm.close();
            
        } 
        catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.exit(1);
    } 
        catch (SQLException e) {
            System.out.println(e.getMessage()); return userhashcode;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage()); return userhashcode;
            }
        }
        //if (userhashcode==null) System.out.println("Log in failed");
        return userhashcode;
    }
    public static void main(String[] args){
        /*StringBuilder username=new StringBuilder();
        StringBuilder password =new StringBuilder();
        String userhashcode=connecttodb(username.toString(),password.toString());
        System.out.println(userhashcode);*/
    }
}
