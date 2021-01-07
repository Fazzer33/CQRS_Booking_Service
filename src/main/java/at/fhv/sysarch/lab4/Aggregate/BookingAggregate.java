package at.fhv.sysarch.lab4.Aggregate;

import at.fhv.sysarch.lab4.Commands.CancelBooking;
import at.fhv.sysarch.lab4.Commands.CreateBooking;
import at.fhv.sysarch.lab4.Events.BookingCancelEvent;
import at.fhv.sysarch.lab4.Events.BookingCreatedEvent;
import at.fhv.sysarch.lab4.Events.Event;
import at.fhv.sysarch.lab4.Events.EventStore;
import at.fhv.sysarch.lab4.Facade;

import java.util.Arrays;
import java.util.List;

public class BookingAggregate {
    private EventStore writeRepository;

    public BookingAggregate(Facade facade) {
        this.writeRepository = facade.getEventStore();
    }

    public List<Event> handleCreateBooking(CreateBooking command) {
        BookingCreatedEvent event = new BookingCreatedEvent(command.getStartDate(), command.getEndDate(),
                command.getRoomNumber(), command.getBookingId(), command.getGuest());
        writeRepository.addEvent(command.getBookingId(), event);
        return Arrays.asList(event);
    }

    public List<Event> handleCancelBooking(CancelBooking command) {
        BookingCancelEvent event = new BookingCancelEvent(command.getBookingId());
        writeRepository.addEvent(command.getBookingId(), event);
        return Arrays.asList(event);
    }
}
