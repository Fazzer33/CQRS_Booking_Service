package at.fhv.sysarch.lab4.Commands;

public class CancelBooking implements ICommand{
    private int reservationNumber;

    public CancelBooking(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
}
