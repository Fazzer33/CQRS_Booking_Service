package at.fhv.sysarch.lab4.Events;

import at.fhv.sysarch.lab4.Domain.Guest;
import at.fhv.sysarch.lab4.Projector.BookingProjector;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BookingCreatedEvent extends Event{

    private LocalDate startDate;
    private LocalDate endDate;
    private String roomNumber;
    private String bookingId;
    private Guest guest;

    public BookingCreatedEvent(LocalDate startDate, LocalDate endDate, String roomNumber, String bookingId, Guest guest) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNumber = roomNumber;
        this.bookingId = bookingId;
        this.guest = guest;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
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

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}
