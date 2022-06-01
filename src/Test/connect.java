package Test;

import java.sql.*;


public class connect {
     /**
     * Connect to a sample database
     */
    public static void connect() {
        Connection conn = null;
        Statement stm=null;
        //Class.forName("org.sqlite.JDBC");
        try {
            // db parameters
            String url = "jdbc:sqlite:/Users/hoangdao/Documents/Projects/DatabasePMA/test.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
            stm = conn.createStatement();
            String sql = "INSERT INTO test (name,pass) " +
                        "VALUES ('minhhoang2907', 'daominhhoang2907');"; 
            stm.executeUpdate(sql);
            stm.close();
            conn.commit();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Records created successfully");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
}

