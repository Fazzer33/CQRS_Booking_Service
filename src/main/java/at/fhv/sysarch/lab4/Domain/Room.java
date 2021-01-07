package at.fhv.sysarch.lab4.Domain;

import java.util.LinkedList;
import java.util.List;

public class Room {
    private String roomNumber;
    private boolean isFree = true;
    private int persons;

    public Room(String roomNumber, int persons) {
        this.roomNumber = roomNumber;
        this.persons = persons;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

}
