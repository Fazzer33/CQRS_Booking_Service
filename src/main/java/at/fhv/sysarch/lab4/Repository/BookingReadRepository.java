package at.fhv.sysarch.lab4.Repository;

import at.fhv.sysarch.lab4.Domain.Booking;

import java.time.LocalDate;
import java.util.*;

public class BookingReadRepository {

    private List<Booking> bookings = new LinkedList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookingByPeriod(LocalDate startDate, LocalDate endDate) {
        List<Booking> bookingsByPeriod = new LinkedList<>();
        for (Booking booking : bookings) {
            if (booking.getStartDate().isAfter(startDate) && booking.getEndDate().isBefore(endDate)) {
                System.out.println("test");
                bookingsByPeriod.add(booking);
            }
        }
        return bookingsByPeriod;
    }
}
