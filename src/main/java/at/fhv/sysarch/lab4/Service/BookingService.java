package at.fhv.sysarch.lab4.Service;

import at.fhv.sysarch.lab4.Commands.CancelBooking;
import at.fhv.sysarch.lab4.Commands.CreateBooking;
import at.fhv.sysarch.lab4.Domain.Booking;
import at.fhv.sysarch.lab4.Domain.Guest;
import at.fhv.sysarch.lab4.Domain.Room;
import at.fhv.sysarch.lab4.Events.EventPublisher;
import at.fhv.sysarch.lab4.Facade;
import javafx.scene.control.Alert;

import java.time.LocalDate;

public class BookingService {

    private Facade facade;

    public BookingService(Facade facade) {
        this.facade = facade;
    }

    public void createBooking(String bookingId, LocalDate startDate, LocalDate endDate, String roomNumber, Guest guest) {
        if (startDate != null && endDate != null && guest != null) {
            EventPublisher.publish(new CreateBooking(bookingId, startDate, endDate, roomNumber, guest));
        }
    }

    public Booking cancelBooking(String bookingId) {
        if (facade.getBookingReadRepository().getBookingByBookingId(bookingId) != null) {
            Booking booking = facade.getBookingReadRepository().getBookingByBookingId(bookingId);
            EventPublisher.publish(new CancelBooking(bookingId));
            return booking;
        }
        return null;
    }
}
