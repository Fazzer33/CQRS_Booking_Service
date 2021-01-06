package at.fhv.sysarch.lab4.Commands;

import at.fhv.sysarch.lab4.Domain.Guest;

import java.time.LocalDate;

public class CreateBooking implements ICommand {
    private String bookingId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String roomNumber;
    private Guest guest;

    public CreateBooking(String bookingId, LocalDate startDate, LocalDate endDate, String roomNumber, Guest guest) {
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
}
