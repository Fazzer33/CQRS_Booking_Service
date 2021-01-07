package at.fhv.sysarch.lab4.Commands;

public class CancelBooking implements ICommand{
    private String bookingId;

    public CancelBooking(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}
