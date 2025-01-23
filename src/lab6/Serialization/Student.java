package lab6.Serialization;

import java.io.Serializable;

public class Student implements Serializable {
    public int number;
    public int age;

    public Student (int number, int age) {
        this.number = number;
        this.age = age;
    }
}
