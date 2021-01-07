package at.fhv.sysarch.lab4.Queries;

import java.time.LocalDate;
import java.util.Date;

public class GetFreeRooms {
    private LocalDate startDate;
    private LocalDate endDate;
    private int persons;

    public GetFreeRooms(LocalDate startDate, LocalDate endDate, int persons) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.persons = persons;
    }

    public LocalDate getStartDate() {
        return startDate;
    }


    public LocalDate getEndDate() {
        return endDate;
    }


    public int getPersons() {
        return persons;
    }

}
