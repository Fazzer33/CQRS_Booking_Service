package at.fhv.sysarch.lab4.Aggregate;

import at.fhv.sysarch.lab4.Commands.CancelBooking;
import at.fhv.sysarch.lab4.Commands.CreateBooking;
import at.fhv.sysarch.lab4.Events.BookingCreatedEvent;
import at.fhv.sysarch.lab4.Events.Event;
import at.fhv.sysarch.lab4.Events.EventStore;

import java.util.Arrays;
import java.util.List;

public class BookingAggregate {
    private EventStore writeRepository;

    public BookingAggregate(EventStore repository) {
        this.writeRepository = repository;
    }

    public List<Event> handleCreateBooking(CreateBooking command) {
        BookingCreatedEvent event = new BookingCreatedEvent(command.getStartDate(), command.getEndDate(),
                command.getRoomNumber(), command.getBookingId(), command.getGuest());
        writeRepository.addEvent(command.getBookingId(), event);
        return Arrays.asList(event);
    }

    public List<Event> handleCancelBooking(CancelBooking command) {
        return null;
    }
}
