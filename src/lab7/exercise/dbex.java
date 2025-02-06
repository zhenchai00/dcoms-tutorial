package lab7.exercise;

public class dbex {
    public static void main(String[] args) {
        try {
            new JbdcProgram();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
