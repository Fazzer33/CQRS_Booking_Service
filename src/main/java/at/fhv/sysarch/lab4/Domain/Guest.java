package at.fhv.sysarch.lab4.Domain;

import java.util.Date;

public class Guest {

    private String name;
    private String address;

    public Guest(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
