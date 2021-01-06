package at.fhv.sysarch.lab4.Repository;

import at.fhv.sysarch.lab4.Domain.Room;
import java.util.HashMap;
import java.util.Map;

public class RoomReadRepository {
    private Map<String, Room> roomsStore = new HashMap<>();

    public RoomReadRepository() {
        roomsStore.put("1", new Room(1, 1));
        roomsStore.put("2", new Room(2, 1));
        roomsStore.put("3", new Room(3, 3));
        roomsStore.put("4", new Room(4, 2));
        roomsStore.put("5", new Room(5, 2));
        roomsStore.put("6", new Room(6, 4));
    }

    public void addRoom(String id, Room booking) {
        roomsStore.put(id, booking);
    }

    public Room getRoomById(String id) {
        return roomsStore.get(id);
    }
}
