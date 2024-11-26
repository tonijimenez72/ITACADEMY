package n1exercise5;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String mail;

    public User(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

     @Override
    public String toString() {
        return "User{name='" + name + "', mail='" + mail + "'}";
    }
}
