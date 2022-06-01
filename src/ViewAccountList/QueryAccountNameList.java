/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewAccountList;

/**
 *
 * @author hoangdao
 */
import java.sql.*;
import java.util.ArrayList;
public class QueryAccountNameList {
    public static ArrayList<String> connecttodb(String userhashcode){
        Connection connobj=null;
        PreparedStatement stmobj=null;
        ArrayList<String> appname=new ArrayList<String>();
        try{
            //Database's url
            String urlobject = "jdbc:sqlite://Users//hoangdao//Documents//Projects//DatabasePMA//objectaccount.db";
            //Connect to databse
            Class.forName("org.sqlite.JDBC");
            connobj = DriverManager.getConnection(urlobject);
            //Query string
            String queryinobjdb="SELECT * from object WHERE usercode= ? ORDER BY apptitle;";
            //Statement
            stmobj= connobj.prepareStatement(queryinobjdb);
            //Set variable in query string
            stmobj.setString(1, userhashcode);
            //Execute Query
            ResultSet rs=stmobj.executeQuery();
            //Process into appname list
            while (rs.next()){
                String name=rs.getString("apptitle"),username=rs.getString("username");
                appname.add(name+"-"+username);
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
        return appname;
    }
    public static void main(String[] args){
        /*ArrayList<String> appname=connecttodb("hoangjackdao");
        if (appname==null) System.out.println("Error");
        if (appname.isEmpty()) System.out.println("No app title yet");*/
    }
}
