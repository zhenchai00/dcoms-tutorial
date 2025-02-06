package lab7.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JbdcProgram {
    public JbdcProgram() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Library", "Library", "123");
        System.out.println("Connected");
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO Department VALUES (50, 25)");
        conn.commit();
        conn.close();
    }
}
