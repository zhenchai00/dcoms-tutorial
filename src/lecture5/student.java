package lecture5;

import java.io.Serializable;

public class student implements Serializable {
    public int id;
    public String name;

    public student (int id, String name) {
        this.id = id;
        this.name = name;
    }
}
