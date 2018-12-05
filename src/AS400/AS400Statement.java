/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AS400;

import java.sql.*;

/**
 *
 * @author it theptarin
 */
public class AS400Statement {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.ibm.as400.access.AS400JDBCDriver";
    static final String DB_URL = "jdbc:as400://10.1.99.2/ORR_TEST";

    //  Database credentials
    static final String USER = "it";
    static final String PASS = "it";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.ibm.as400.access.AS400JDBCDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating Table...");
            stmt = conn.createStatement();
            // stmt.executeUpdate("CREATE TABLE MYTABLE (NAME VARCHAR(20), ID INTEGER)");
            // stmt.executeUpdate("INSERT INTO MYTABLE (NAME, ID) VALUES ('DAVE', 123)");
            //stmt.executeUpdate("INSERT INTO MYTABLE (NAME, ID) VALUES ('สุชาติ', 467)");
            stmt.executeUpdate("UPDATE mytable SET name='เทพธารินทร์' WHERE id=123");
            System.out.println("Table created insert successfully...");

            System.out.println("Table created successfully...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end JDBCExample
