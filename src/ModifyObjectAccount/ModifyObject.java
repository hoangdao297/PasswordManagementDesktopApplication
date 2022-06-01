package ModifyObjectAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author hoangdao
 */
public class ModifyObject {
    public static int modifyindb(String userhashcode,String web, String username, String password, String lastupdate){
        Connection conn = null;
        Statement stm=null;
        try {
            String url = "jdbc:sqlite://Users//hoangdao//Documents//Projects//DatabasePMA//objectaccount.db";
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            //System.out.println("Connection to SQLite has been established.");
            stm = conn.createStatement();
            String testsql="SELECT * FROM object where usercode='"+userhashcode+"';";
            ResultSet rs=stm.executeQuery(testsql);
            int find=0;
            while (rs.next()) {
                if (rs.getString("apptitle").equals(web)&&rs.getString("username").equals(username)) {
                    find=1; break;
                }
            }
            if (find==0){
                //System.out.println("Error occured while modifying"); 
                return 2;
            }
            PreparedStatement stm1=null;
            String sql = "UPDATE object SET pass=?,date=? WHERE usercode=? AND apptitle=? AND username=?;"; 
            stm1=conn.prepareStatement(sql);
            stm1.setString(1,password);
            stm1.setString(2,lastupdate);
            stm1.setString(3,userhashcode);
            stm1.setString(4,web);
            stm1.setString(5,username);
            stm1.executeUpdate();
            //System.out.println("Object is modified successfully");
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
    public static int modifyindb(String userhashcode,String web, String username, String password,String link, String lastupdate){
        Connection conn = null;
        Statement stm=null;
        try {
            String url = "jdbc:sqlite:/Users/hoangdao/Documents/Projects/DatabasePMA/objectaccount.db";
            conn = DriverManager.getConnection(url);
            //System.out.println("Connection to SQLite has been established.");
            stm = conn.createStatement();
            String testsql="SELECT * FROM object where usercode='"+userhashcode+"';";
            ResultSet rs=stm.executeQuery(testsql);
            int find=0;
            while (rs.next()) {
                if (rs.getString("apptitle").equals(web)&&rs.getString("username").equals(username)) {
                    find=1; break;
                }
            }
            if (find==0){
                //System.out.println("Error occured while modifying"); 
                return 0;
            }
            PreparedStatement stm1=null;
            String sql = "UPDATE object SET pass=?,url= ?,date=? WHERE usercode=? AND apptitle=? AND username=?;"; 
            stm1=conn.prepareStatement(sql);
            stm1.setString(1,password);
            stm1.setString(2,link);
            stm1.setString(3,lastupdate);
            stm1.setString(4,userhashcode);
            stm1.setString(5,web);
            stm1.setString(6,username);
            stm1.executeUpdate();
            //System.out.println("Object is modified successfully");
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

}
