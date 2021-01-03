package at.fhv.sysarch.lab4.Domain;

import java.sql.Date;

public class Guest {

    private String name;
    private String address;
    private Date birthDate;

    public Guest(String name, String address, Date birthDate) {
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
