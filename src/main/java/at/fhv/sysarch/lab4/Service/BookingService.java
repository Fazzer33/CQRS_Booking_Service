package at.fhv.sysarch.lab4.Service;

import at.fhv.sysarch.lab4.Commands.CreateBooking;
import at.fhv.sysarch.lab4.Domain.Guest;
import at.fhv.sysarch.lab4.Domain.Room;
import at.fhv.sysarch.lab4.Events.BookingCreatedEvent;
import at.fhv.sysarch.lab4.Events.EventPublisher;
import at.fhv.sysarch.lab4.Events.EventStore;
import at.fhv.sysarch.lab4.Repository.RoomReadRepository;
import java.util.Date;


public class BookingService {

    private EventStore repository;
    private RoomReadRepository roomReadRepository = new RoomReadRepository();

    public BookingService(EventStore repository) {
        this.repository = repository;
    }

    public void createBooking(String bookingId, Date startDate, Date endDate, String roomNumber, Guest guest) {
        Room room = roomReadRepository.getRoomById(roomNumber);
        System.out.println(room.isFree());
        if (room.isFree()) {
            System.out.println("Room is free");
            EventPublisher.publish(new CreateBooking(bookingId, startDate, endDate, roomNumber, guest));

        } else {
            System.out.println("Room is not free");
        }
    }
}
