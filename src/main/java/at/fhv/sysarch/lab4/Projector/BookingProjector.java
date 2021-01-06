package at.fhv.sysarch.lab4.Projector;

import at.fhv.sysarch.lab4.Domain.Booking;
import at.fhv.sysarch.lab4.Events.BookingCreatedEvent;
import at.fhv.sysarch.lab4.Events.Event;
import at.fhv.sysarch.lab4.Repository.BookingReadRepository;
import java.util.List;

public class BookingProjector {
    BookingReadRepository readRepository = new BookingReadRepository();

    public BookingProjector(BookingReadRepository readRepository) {
        this.readRepository = readRepository;
    }

    public void project(List<Event> events) {
        for (Event event : events) {
            if (event instanceof BookingCreatedEvent) {
                apply((BookingCreatedEvent) event);
            }
        }
    }

    private void apply(BookingCreatedEvent event) {
        Booking booking = new Booking(event.getBookingId(), event.getStartDate(), event.getEndDate(), event.getRoomNumber(), event.getGuest());
        readRepository.addBooking(booking);
    }
}
