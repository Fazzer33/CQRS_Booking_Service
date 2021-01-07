package at.fhv.sysarch.lab4.Repository;

import at.fhv.sysarch.lab4.Domain.Booking;
import at.fhv.sysarch.lab4.Domain.Room;
import at.fhv.sysarch.lab4.Facade;

import java.time.LocalDate;
import java.util.*;

public class RoomReadRepository {
    private Facade facade;
    private Map<String, Room> roomsStore = new HashMap<>();

    public RoomReadRepository(Facade facade) {
        this.facade = facade;
        roomsStore.put("1", new Room("1", 1));
        roomsStore.put("2", new Room("2", 1));
        roomsStore.put("3", new Room("3", 3));
        roomsStore.put("4", new Room("4", 2));
        roomsStore.put("5", new Room("5", 2));
        roomsStore.put("6", new Room("6", 4));
    }

    public void addRoom(String id, Room booking) {
        roomsStore.put(id, booking);
    }

    public Room getRoomById(String id) {
        return roomsStore.get(id);
    }

    public Map<String, Room> getAllFreeRooms() {
        return roomsStore;
    }

    public List<Room> getAllFreeRoomsByPeriodAndPerson(LocalDate startDate, LocalDate endDate, int persons) {
        List<Room> availableRooms = getRoomsByPerson(persons);
        List<Booking> bookingByPeriod = facade.getBookingReadRepository().getBookingByPeriod(startDate, endDate);
        for (Room r : availableRooms) {
            for (Booking b : bookingByPeriod) {
                if (r.getRoomNumber().equals(b.getRoomNumber())){
                    availableRooms.remove(r);
                }
            }
        }

        return availableRooms;
    }

    private List<Room> getRoomsByPerson(int person) {
        List<Room> roomsByPerson = new LinkedList<>();
        for (Map.Entry<String, Room> roomEntry :
                roomsStore.entrySet()) {
            if (roomEntry.getValue().getPersons() == person) {
                roomsByPerson.add(roomEntry.getValue());
            }
        }
        return roomsByPerson;

    }

}
