package at.fhv.sysarch.lab4.Projections;

import at.fhv.sysarch.lab4.Domain.Room;
import at.fhv.sysarch.lab4.Facade;
import at.fhv.sysarch.lab4.Queries.GetFreeRooms;
import at.fhv.sysarch.lab4.Repository.RoomReadRepository;

import java.util.List;

public class RoomProjection {
    private RoomReadRepository readRepository;

    public RoomProjection(Facade facade) {
        this.readRepository = facade.getRoomReadRepository();
    }

    public List<Room> handle(GetFreeRooms query) {
        return readRepository.getAllFreeRoomsByPeriodAndPerson(query.getStartDate(), query.getEndDate(), query.getPersons());
    }

}
