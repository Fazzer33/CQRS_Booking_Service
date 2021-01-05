package at.fhv.sysarch.lab4.Commands;

import at.fhv.sysarch.lab4.Domain.Guest;

import java.util.Date;


public class CreateBooking implements ICommand {
    private String bookingId;
    private Date startDate;
    private Date endDate;
    private String roomNumber;
    private Guest guest;

    public CreateBooking(String bookingId, Date startDate, Date endDate, String roomNumber, Guest guest) {
        this.bookingId = bookingId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNumber = roomNumber;
        this.guest = guest;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
