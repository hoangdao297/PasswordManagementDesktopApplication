package CreateNewObjectAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hoangdao
 */
public class CreateObjectAccount {
    public static int createindb(String userhashcode,String web,String username, String password, String lastupdate){
        Connection conn = null;
        Statement stm=null;
        try {
            String url = "jdbc:sqlite://Users//hoangdao//Documents//Projects//DatabasePMA//objectaccount.db";
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            //System.out.println("Connection to SQLite has been established.");
            stm = conn.createStatement();
            String testsql="SELECT apptitle FROM object where usercode='"+userhashcode+"'";
            ResultSet rs=stm.executeQuery(testsql);
            while (rs.next()) {
                if (rs.getString("apptitle").equals(web) && rs.getString("username").equals(username)){
                    //System.out.println("Object is already existed");
                    return 2;
                }
            }
            String sql = "INSERT INTO object (usercode,apptitle,username,pass,date)"+"VALUES ('"+userhashcode+"', '"+web+"','"+username+"','"+password+"','"+lastupdate+"');"; 
            stm.executeUpdate(sql);
            //System.out.println("Object is created successfully");
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
    public static int createindb(String userhashcode,String web,String username, String password,String link, String lastupdate){
        Connection conn = null;
        Statement stm=null;
        try {
            String url = "jdbc:sqlite:/Users/hoangdao/Documents/Projects/DatabasePMA/objectaccount.db";
            conn = DriverManager.getConnection(url);
            stm = conn.createStatement();
            String testsql="SELECT apptitle FROM object where usercode='"+userhashcode+"'";
            ResultSet rs=stm.executeQuery(testsql);
            while (rs.next()) {
                if (rs.getString("apptitle").equals(web)&& rs.getString("username").equals(username)){
                    //System.out.println("Object is already existed");
                    return 2;
                }
            }
            String sql = "INSERT INTO object (usercode,apptitle,username,pass,url,date)"+"VALUES ('"+userhashcode+"', '"+web+"','"+username+"','"+password+"','"+link+"','"+lastupdate+"');"; 
            stm.executeUpdate(sql);
            //System.out.println("Object is created successfully");
            //conn.commit();
            stm.close();
            
        } catch (SQLException e) {
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
        /*String userhashcode="HoangJackDao@Jack2972001";
        String apptitle="Facebook";
        String password="j@ckH0@ng297";
        String date="5/11/2022";
        int status=createindb(userhashcode,apptitle,password,date);
        if (status==1) System.out.println("Error");
        else System.out.println("Successful");*/
    }
}
