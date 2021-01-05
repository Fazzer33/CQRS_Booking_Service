package at.fhv.sysarch.lab4.Repository;

import at.fhv.sysarch.lab4.Domain.Booking;
import at.fhv.sysarch.lab4.Domain.Room;

import java.util.HashMap;
import java.util.Map;

public class RoomReadRepository {
    private Map<String, Room> roomsStore = new HashMap<>();

    public RoomReadRepository() {
        roomsStore.put("1", new Room(1));
    }

    public void addRoom(String id, Room booking) {
        roomsStore.put(id, booking);
    }

    public Room getRoomById(String id) {
        return roomsStore.get(id);
    }
}
