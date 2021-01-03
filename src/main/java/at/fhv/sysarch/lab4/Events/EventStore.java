package at.fhv.sysarch.lab4.Events;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventStore {
    private Map<String, List<Event>> store = new HashMap<>();
}
