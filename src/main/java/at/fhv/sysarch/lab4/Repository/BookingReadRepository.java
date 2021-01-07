package at.fhv.sysarch.lab4.Repository;

import at.fhv.sysarch.lab4.Domain.Booking;
import java.time.LocalDate;
import java.util.*;

public class BookingReadRepository {

    private List<Booking> bookings = new LinkedList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void removeBookingByBookingId(String bookingId) {
        bookings.removeIf(booking -> booking.getBookingId().equals(bookingId));
    }

    public List<Booking> getBookingByPeriod(LocalDate startDate, LocalDate endDate) {
        List<Booking> bookingsByPeriod = new LinkedList<>();
        for (Booking booking : bookings) {
            if (booking.getStartDate().isAfter(startDate) || booking.getStartDate().isEqual(startDate) &&
                    booking.getEndDate().isBefore(endDate) || booking.getEndDate().isEqual(endDate)) {
                bookingsByPeriod.add(booking);
            }
        }
        return bookingsByPeriod;
    }

    public Booking getBookingByBookingId(String bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                return booking;
            }
        }
        return null;
    }


}
