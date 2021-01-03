package at.fhv.sysarch.lab4.Repository;

import at.fhv.sysarch.lab4.Domain.Booking;
import at.fhv.sysarch.lab4.Domain.Room;

import java.util.HashMap;
import java.util.Map;

public class RoomRepository {
    private Map<Integer, Room> roomsStore = new HashMap<>();

    public void addRoom(int id, Room booking) {
        roomsStore.put(id, booking);
    }

    public Room getRoom(int id) {
        return roomsStore.get(id);
    }
}
