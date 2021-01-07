package at.fhv.sysarch.lab4.Events;

public class BookingCancelEvent extends Event {

    private String bookingId;

    public BookingCancelEvent(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}
