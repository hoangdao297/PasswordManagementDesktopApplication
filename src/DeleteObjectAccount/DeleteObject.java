
package DeleteObjectAccount;

/**
 *
 * @author hoangdao
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class DeleteObject {
    public static int deleteindb(String userhashcode,String web,String username){
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
                if (rs.getString("apptitle").equals(web) && rs.getString("username").equals(username)){
                    find=1; break;
                } 
            }
            if (find==0){
                /*System.out.println("Apptitile does not exist");*/ return 2;
            }
            //System.out.println("Were here");
            PreparedStatement stm1=null;
            String deletestring = "DELETE FROM object WHERE usercode=? AND apptitle=? AND username=? ;"; 
            stm1=conn.prepareStatement(deletestring);
            stm1.setString(1,userhashcode);
            stm1.setString(2,web);
            stm1.setString(3,username);
            
            stm1.executeUpdate();
            //System.out.println("Object is deleted successfully");
            //conn.commit();
            stm.close();
            stm1.close();
            
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
}
