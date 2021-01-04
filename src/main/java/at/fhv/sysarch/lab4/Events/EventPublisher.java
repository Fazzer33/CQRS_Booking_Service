package at.fhv.sysarch.lab4.Events;

import at.fhv.sysarch.lab4.Projector.BookingProjector;

import java.util.LinkedList;
import java.util.List;

public class EventPublisher {
    private List<BookingProjector> subscribers = new LinkedList<>();

    public void subscribe(BookingProjector projector) {
        subscribers.add(projector);
    }

    public void publish(BookingCreatedEvent event) {
        for (BookingProjector subscriber : subscribers) {

            // tell subscriber to do something with the event
        }
    }
}
