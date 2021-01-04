package at.fhv.sysarch.lab4;

import at.fhv.sysarch.lab4.Aggregate.BookingAggregate;
import at.fhv.sysarch.lab4.Commands.CreateBooking;
import at.fhv.sysarch.lab4.Domain.Guest;
import at.fhv.sysarch.lab4.Events.EventStore;
import at.fhv.sysarch.lab4.Projector.BookingProjector;
import at.fhv.sysarch.lab4.Repository.BookingReadRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

            String dateString = "1997-02-01 12:00:00";
            DateFormat formatter = new SimpleDateFormat(DEFAULT_PATTERN);
            Date myDate = formatter.parse(dateString);

            Guest guest = new Guest("Fabian", "Strasse3", myDate);

            EventStore eventStore = new EventStore();
            BookingAggregate bookingAggregate = new BookingAggregate(eventStore);

            BookingReadRepository readRepository = new BookingReadRepository();
            BookingProjector bookingProjector = new BookingProjector(readRepository);
            bookingProjector.project(bookingAggregate.handleCreateBooking(
                    new CreateBooking("1", formatter.parse("2021-01-01 12:00:00"),
                            formatter.parse("2021-02-01 12:00:00"), "1", guest)));
            bookingProjector.project(bookingAggregate.handleCreateBooking(
                    new CreateBooking("2", formatter.parse("2021-01-05 12:00:00"),
                            formatter.parse("2021-01-20 12:00:00"), "3", guest)));

            System.out.println(eventStore.getEvents("1"));
            System.out.println(eventStore.getEvents("2"));


            System.out.println(readRepository.getBookingByPeriod(formatter.parse("2021-01-01 11:00:00"),
                    formatter.parse("2021-03-01 12:00:00")));


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
