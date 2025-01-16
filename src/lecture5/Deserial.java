package lecture5;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserial {
    public static void main(String[] args) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/lecture5/f.ser"));
            student s1 = (student) in.readObject();
            System.out.println(s1.id + " " + s1.name);
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
