package at.fhv.sysarch.lab4.Service;

import at.fhv.sysarch.lab4.Events.EventStore;

public class RoomService {
    private EventStore repository;

    public RoomService(EventStore repository) {
        this.repository = repository;
    }

    public void updateRoom() {

    }
}
