package at.fhv.sysarch.lab4.Service;

import at.fhv.sysarch.lab4.Domain.Guest;
import at.fhv.sysarch.lab4.Events.BookingCreatedEvent;
import at.fhv.sysarch.lab4.Events.EventStore;

import java.util.Date;


public class BookingService {

    private EventStore repository;

    public BookingService(EventStore repository) {
        this.repository = repository;
    }

    public void createBooking(Date startDate, Date endDate, String roomNumber, Guest guest) {
        repository.addEvent(roomNumber, new BookingCreatedEvent(startDate, endDate, roomNumber, guest));
    }
}
