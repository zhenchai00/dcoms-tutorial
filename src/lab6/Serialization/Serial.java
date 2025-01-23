package lab6.Serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serial {
    public static void main(String[] args) {
        try {
            // create the object 
            Student s1 = new Student(221, 20);
            FileOutputStream fout = new FileOutputStream("src/lab6/Serialization/example.ser");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(s1);
            out.flush();
            out.close();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
