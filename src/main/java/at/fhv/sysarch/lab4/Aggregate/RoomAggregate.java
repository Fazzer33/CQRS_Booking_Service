package at.fhv.sysarch.lab4.Aggregate;

import at.fhv.sysarch.lab4.Commands.UpdateRoom;
import at.fhv.sysarch.lab4.Domain.Room;
import at.fhv.sysarch.lab4.Events.Event;
import at.fhv.sysarch.lab4.Events.EventStore;

import java.util.List;

public class RoomAggregate {
    private EventStore writeRepository;

    public RoomAggregate(EventStore repository) {
        this.writeRepository = repository;
    }

    public List<Event> handleUpdateRoom(UpdateRoom command) {
        return null;
    }
}
