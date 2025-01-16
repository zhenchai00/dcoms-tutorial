package lecture5;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serial {
    public static void main(String[] args) {
        try {
            // create the object 
            student s1 = new student(221, "ravi");
            FileOutputStream fout = new FileOutputStream("src/lecture5/f.ser");
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
