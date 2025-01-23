package lab6.Serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserial {
    public static void main(String[] args) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/lab6/Serialization/example.ser"));
            Student s1 = (Student) in.readObject();
            System.out.println(s1.number + " " + s1.age);
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
