package at.fhv.sysarch.lab4.Repository;

import at.fhv.sysarch.lab4.Domain.Booking;
import java.util.LinkedList;
import java.util.List;

public class BookingWriteRepository {
    private List<Booking> bookingStore = new LinkedList<>();

    public void addBooking(Booking booking) {
        bookingStore.add(booking);
    }

}
