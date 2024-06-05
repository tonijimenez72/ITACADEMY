package n1exercise5;

import java.io.Serializable;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;    private String name;
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
