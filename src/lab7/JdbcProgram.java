package lab7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcProgram {
    public JdbcProgram() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/tutorialsix", "tutorialsix", "tutorialsix");
        System.out.println("Connected");
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO student VALUES (50, 32)");
        conn.commit();
        conn.close();
    }
}
