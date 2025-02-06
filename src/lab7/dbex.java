package lab7;

public class dbex {
    public static void main(String[] args) {
        try {
            new JdbcProgram();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
