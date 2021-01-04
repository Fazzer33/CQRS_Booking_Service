package at.fhv.sysarch.lab4.Projections;

import at.fhv.sysarch.lab4.Domain.Booking;
import at.fhv.sysarch.lab4.Queries.GetBookings;
import at.fhv.sysarch.lab4.Repository.BookingReadRepository;
import java.util.List;

public class BookingProjection {
    private BookingReadRepository readRepository;

    public BookingProjection(BookingReadRepository readRepository) {
        this.readRepository = readRepository;
    }

    public List<Booking> handle(GetBookings query) {
        return readRepository.getBookingByPeriod(query.getStartDate(), query.getEndDate());
    }
}
