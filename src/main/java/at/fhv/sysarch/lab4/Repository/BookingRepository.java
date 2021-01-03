package at.fhv.sysarch.lab4.Repository;

import at.fhv.sysarch.lab4.Domain.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    private Map<Integer, Booking> bookingStore = new HashMap<>();

    public void addBooking(int id, Booking booking) {
        bookingStore.put(id, booking);
    }

    public Booking getBooking(int id) {
        return bookingStore.get(id);
    }
}
