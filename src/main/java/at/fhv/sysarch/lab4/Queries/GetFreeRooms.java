package at.fhv.sysarch.lab4.Queries;

import java.util.Date;

public class GetFreeRooms {
    private Date startDate;
    private Date endDate;
    private int persons;

    public GetFreeRooms(Date startDate, Date endDate, int persons) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.persons = persons;
    }
}
