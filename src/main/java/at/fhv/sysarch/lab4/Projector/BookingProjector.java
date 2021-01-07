package at.fhv.sysarch.lab4.Projector;

import at.fhv.sysarch.lab4.Domain.Booking;
import at.fhv.sysarch.lab4.Events.BookingCancelEvent;
import at.fhv.sysarch.lab4.Events.BookingCreatedEvent;
import at.fhv.sysarch.lab4.Events.Event;
import at.fhv.sysarch.lab4.Facade;
import java.util.List;

public class BookingProjector {

    private Facade facade;

    public BookingProjector(Facade facade) {
        this.facade = facade;
    }

    public void project(List<Event> events) {
        for (Event event : events) {
            if (event instanceof BookingCreatedEvent) {
                apply((BookingCreatedEvent) event);
            }
            if (event instanceof BookingCancelEvent) {
                remove((BookingCancelEvent) event);
            }
        }
    }

    private void apply(BookingCreatedEvent event) {
        Booking booking = new Booking(event.getBookingId(), event.getStartDate(), event.getEndDate(), event.getRoomNumber(), event.getGuest());
        facade.getBookingReadRepository().addBooking(booking);
    }

    private void remove(BookingCancelEvent event) {
        facade.getBookingReadRepository().removeBookingByBookingId(event.getBookingId());
    }
}
