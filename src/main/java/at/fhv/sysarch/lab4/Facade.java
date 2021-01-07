package at.fhv.sysarch.lab4;

import at.fhv.sysarch.lab4.Events.EventStore;
import at.fhv.sysarch.lab4.Repository.BookingReadRepository;
import at.fhv.sysarch.lab4.Repository.RoomReadRepository;

public class Facade {

    private EventStore eventStore = new EventStore();
    private BookingReadRepository bookingReadRepository = new BookingReadRepository();
    private RoomReadRepository roomReadRepository = new RoomReadRepository(this);

    public Facade() {
    }

    public EventStore getEventStore() {
        return eventStore;
    }

    public void setEventStore(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public BookingReadRepository getBookingReadRepository() {
        return bookingReadRepository;
    }

    public RoomReadRepository getRoomReadRepository() {
        return roomReadRepository;
    }
}
