package at.fhv.sysarch.lab4.Commands;

public class CancelBooking implements ICommand{
    private int bookingId;

    public CancelBooking(int bookingId) {
        this.bookingId = bookingId;
    }
}
