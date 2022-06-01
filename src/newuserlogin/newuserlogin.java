package newuserlogin;
/**
 *
 * @author hoangdao
 */
import java.sql.*;
//import user.user;
//import InputStuff.InputStuff;

//this class is to create account for the new user to database
public class newuserlogin {
    public static int connecttodb(String username, String password, String userhashcode){
        Connection conn = null; //open connection to database
        Statement stm=null;
        try {
            String url = "jdbc:sqlite://Users//hoangdao//Documents//Projects//DatabasePMA//user.db";
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            //System.out.println("Connection to SQLite has been established.");
            stm = conn.createStatement();
            String testsql="SELECT username FROM user where username='"+username+"'";
            ResultSet rs=stm.executeQuery(testsql);
            while (rs.next()) {
                if (rs.getString("username").equals(username)){
                    //System.out.println("Account is already existed");
                    return 0;
                }
            }
            String sql = "INSERT INTO user (username,password,usercode)"+"VALUES ('"+username+"', '"+password+"','"+userhashcode+ "');"; 
            stm.executeUpdate(sql);
            //System.out.println("User account is created successfully");
            //conn.commit();
            stm.close();
            
        } 
        catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.exit(1);
    }
        catch (SQLException e) {
            System.out.println(e.getMessage()); return 0;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage()); return 0;
            }
        }
        return 1;
    }
    
    public static void main(String[] args){
        /*StringBuilder username=new StringBuilder();
        StringBuilder password =new StringBuilder();
        InputStuff.InputUsernamePassword(username,password);
        user userinput=new user(username.toString(),password.toString());
        connecttodb(userinput.username,userinput.password,userinput.userhashcode);*/
    }
}
