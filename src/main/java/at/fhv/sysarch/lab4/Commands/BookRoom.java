package at.fhv.sysarch.lab4.Commands;

import at.fhv.sysarch.lab4.Domain.Guest;

import java.sql.Date;

public class BookRoom {
    private Date startDate;
    private Date endDate;
    private int roomNumber;
    private Guest guest;

    public BookRoom(Date startDate, Date endDate, int roomNumber, Guest guest) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNumber = roomNumber;
        this.guest = guest;
    }
}
