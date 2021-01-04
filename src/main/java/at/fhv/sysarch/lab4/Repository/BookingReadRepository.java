package at.fhv.sysarch.lab4.Repository;

import at.fhv.sysarch.lab4.Domain.Booking;

import java.util.*;

public class BookingReadRepository {

    private List<Booking> bookings = new LinkedList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookingByPeriod(Date startDate, Date endDate) {
        List<Booking> bookingsByPeriod = new LinkedList<>();
        for (Booking booking : bookings) {
            if (booking.getStartDate().after(startDate) && booking.getEndDate().before(endDate)) {
                bookingsByPeriod.add(booking);
            }
        }
        return bookingsByPeriod;
    }
}
