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
import java.sql.*;
import java.util.ArrayList;
public class ViewAccountObject {
    public static ArrayList<String> connecttodb(String userhashcode,String apptitle,String username){
        Connection connobj=null;
        PreparedStatement stmobj=null;
        ArrayList<String> accountdetail=new ArrayList<String>();
        try{
            //Database's url
            String urlobject = "jdbc:sqlite://Users//hoangdao//Documents//Projects//DatabasePMA//objectaccount.db";
            //Connect to databse
            Class.forName("org.sqlite.JDBC");
            connobj = DriverManager.getConnection(urlobject);
            //Query string
            String queryinobjdb="SELECT * from object WHERE usercode= ? AND apptitle=? AND username=?;";
            //Statement
            stmobj= connobj.prepareStatement(queryinobjdb);
            //Set variable in query string
            stmobj.setString(1, userhashcode);
            stmobj.setString(2, apptitle);
            stmobj.setString(3, username);
            //Execute Query
            ResultSet rs=stmobj.executeQuery();
            //Process into appname list
            while (rs.next()){
                accountdetail.add(rs.getString("apptitle"));
                accountdetail.add(rs.getString("username"));
                accountdetail.add(rs.getString("pass"));
                if (rs.getString("url")!=null && !rs.getString("url").equals("")) accountdetail.add(rs.getString("url"));
                else accountdetail.add("None");
                accountdetail.add(rs.getString("date"));
            }
            //Close
            rs.close();
            stmobj.close();
        }
        catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.exit(1);
    } 
        catch (SQLException e) {
            System.out.println(e.getMessage()); return null;
        }
        finally {
            try {
                if (connobj != null)  connobj.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage()); return null;
            }
        }
        return accountdetail;
    }
    public static void main(String[] args){
        
    }
}
