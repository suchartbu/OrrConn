package AS400;

import java.sql.*;

/**
 *
 * @author it
 */
public class AS400Simple {

    static final String DB_URL
            = "jdbc:as400://10.1.99.2/trhpfv5";
    static final String DB_DRV
            = "com.ibm.as400.access.AS400JDBCDriver";
    static final String DB_USER = "orrconn";
    static final String DB_PASSWD = "xoylfk";

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            //statement.executeQuery("UPDATE regmasv5pf SET rmssurnam='จาก Simple java' where rmshnref='211'" );
            resultSet = statement.executeQuery("select rmshnref,rmsname,rmssurnam from regmasv5pf where rmsname='ทดสอบ'" );
            while (resultSet.next()) {
                System.out.printf("%s\t%s\t%s\n",
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
            }

        } catch (SQLException ex) {
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
            }
        }
    }
}
