package at.fhv.sysarch.lab4.Service;

import at.fhv.sysarch.lab4.Commands.CancelBooking;
import at.fhv.sysarch.lab4.Commands.CreateBooking;
import at.fhv.sysarch.lab4.Domain.Booking;
import at.fhv.sysarch.lab4.Domain.Guest;
import at.fhv.sysarch.lab4.Domain.Room;
import at.fhv.sysarch.lab4.Events.EventPublisher;
import at.fhv.sysarch.lab4.Facade;
import at.fhv.sysarch.lab4.Repository.BookingReadRepository;
import at.fhv.sysarch.lab4.Repository.RoomReadRepository;
import java.time.LocalDate;

public class BookingService {

    private Facade facade;

    public BookingService(Facade facade) {
        this.facade = facade;
    }

    public void createBooking(String bookingId, LocalDate startDate, LocalDate endDate, String roomNumber, Guest guest) {
        Room room = facade.getRoomReadRepository().getRoomById(roomNumber);
        System.out.println(room.isFree());
        if (room.isFree()) {
            System.out.println("Room is free");
            EventPublisher.publish(new CreateBooking(bookingId, startDate, endDate, roomNumber, guest));

        } else {
            System.out.println("Room is not free");
        }
    }

    public Booking cancelBooking(String bookingId) {
        if (facade.getBookingReadRepository().getBookingByBookingId(bookingId) != null) {
            Booking booking = facade.getBookingReadRepository().getBookingByBookingId(bookingId);
            EventPublisher.publish(new CancelBooking(bookingId));
            return booking;
        } else {
            System.out.println("Booking doesn't exist");
        }
        return null;
    }
}
