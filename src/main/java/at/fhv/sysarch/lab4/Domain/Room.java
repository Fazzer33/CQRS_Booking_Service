package at.fhv.sysarch.lab4.Domain;

public class Room {
    private int roomNumber;
    private boolean isFree = true;
    private int persons;

    public Room(int roomNumber, int persons) {
        this.roomNumber = roomNumber;
        this.persons = persons;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
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
