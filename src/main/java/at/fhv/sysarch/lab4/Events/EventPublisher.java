package at.fhv.sysarch.lab4.Events;

import at.fhv.sysarch.lab4.Aggregate.BookingAggregate;
import at.fhv.sysarch.lab4.Commands.CancelBooking;
import at.fhv.sysarch.lab4.Commands.CreateBooking;
import at.fhv.sysarch.lab4.Commands.ICommand;
import at.fhv.sysarch.lab4.Projector.BookingProjector;

import java.util.LinkedList;
import java.util.List;

// https://medium.com/easyread/create-your-own-java-pubsub-library-fbee21d0bb44


public class EventPublisher {
    private static List<BookingAggregate> subscribers = new LinkedList<>();

    public void subscribe(BookingAggregate aggregate) {
        subscribers.add(aggregate);
    }

    public static void publish(ICommand command) {
        if (command instanceof CreateBooking) {
            for (BookingAggregate subscriber : subscribers) {
                subscriber.handleCreateBooking((CreateBooking) command);
            }
        }
        if (command instanceof CancelBooking) {
            for (BookingAggregate subscriber : subscribers) {
//                subscriber((CancelBooking) command);
            }
        }

    }
}
