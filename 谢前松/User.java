package pers.xqs.algorithm;

import java.io.Serializable;

public class User {
    private String serial;
    private String name;
    public User(String serial, String name) {
        this.serial = serial;
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
