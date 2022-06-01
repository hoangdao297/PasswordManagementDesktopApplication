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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class userchangepassword {
    public static int connecttodb(String username, String oldpassword, String newpassword){
        Connection connuser = null, connobj=null;
        PreparedStatement stmuser=null, stmobj=null;
        String olduserhashcode=username+oldpassword, newuserhashcode=username+newpassword;
        try {
            //Database's url
            String urluser = "jdbc:sqlite://Users//hoangdao//Documents//Projects//DatabasePMA//user.db";
            String urlobject = "jdbc:sqlite://Users//hoangdao//Documents//Projects//DatabasePMA//objectaccount.db";
            //Connect to database
            Class.forName("org.sqlite.JDBC");
            connuser = DriverManager.getConnection(urluser);
            connobj = DriverManager.getConnection(urlobject);
            //Query
            String queryinuserdb="UPDATE user SET password =?,usercode= ? WHERE usercode= ?;";
            String queryinobjdb="UPDATE object SET pass =?,usercode= ? WHERE usercode= ?;";
            //Statement
            stmuser = connuser.prepareStatement(queryinuserdb);
            stmobj= connobj.prepareStatement(queryinobjdb);
            //Set string in query
            stmuser.setString(1, newpassword);
            stmobj.setString(1, newpassword);
            stmuser.setString(2, newuserhashcode);
            stmobj.setString(2, newuserhashcode);
            stmuser.setString(3, olduserhashcode);
            stmobj.setString(3, olduserhashcode);
            //Execute Query
            stmuser.executeUpdate();
            stmobj.executeUpdate();
            //Close Statement
            stmuser.close();
            stmobj.close();
            
        } 
        catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.exit(1);
    } 
        catch (SQLException e) {
            System.out.println(e.getMessage()); return 0;
        } finally {
            try {
                if (connuser != null) {
                    connuser.close();
                }
                if (connobj != null) {
                    connobj.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage()); return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args){
        
    }
}
