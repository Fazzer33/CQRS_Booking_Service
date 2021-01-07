package at.fhv.sysarch.lab4.Domain;

public class Room {
    private String roomNumber;
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

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", persons=" + persons +
                '}';
    }
}
