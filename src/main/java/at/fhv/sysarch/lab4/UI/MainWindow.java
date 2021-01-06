package at.fhv.sysarch.lab4.UI;

import at.fhv.sysarch.lab4.Aggregate.BookingAggregate;
import at.fhv.sysarch.lab4.Domain.Booking;
import at.fhv.sysarch.lab4.Domain.Guest;
import at.fhv.sysarch.lab4.Events.EventPublisher;
import at.fhv.sysarch.lab4.Events.EventStore;
import at.fhv.sysarch.lab4.Projections.BookingProjection;
import at.fhv.sysarch.lab4.Projector.BookingProjector;
import at.fhv.sysarch.lab4.Queries.GetBookings;
import at.fhv.sysarch.lab4.Repository.BookingReadRepository;
import at.fhv.sysarch.lab4.Service.BookingService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        try {
//            String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
//
//            DateFormat formatter = new SimpleDateFormat(DEFAULT_PATTERN);
//
//            Guest guest = new Guest("Fabian", "Strasse3");
//            EventStore eventStore = new EventStore();
//            EventPublisher publisher = new EventPublisher();
//
//            BookingAggregate bookingAggregate = new BookingAggregate(eventStore);
//            publisher.subscribe(bookingAggregate);
//
//            BookingReadRepository readRepository = new BookingReadRepository();
//            BookingProjector bookingProjector = new BookingProjector(readRepository);
//
//            BookingService bookingService = new BookingService(eventStore);
//            bookingService.createBooking("1", formatter.parse("2021-01-01 12:00:00"),
//                    formatter.parse("2021-02-01 12:00:00"), "1", guest);
//
//            bookingProjector.project(eventStore.getEvents("1"));
//
//            System.out.println(eventStore.getEvents("1"));
//
//            BookingProjection bookingProjection = new BookingProjection(readRepository);
//            List<Booking> bookings = bookingProjection.handle(new GetBookings(formatter.parse("2021-01-01 11:00:00"),
//                    formatter.parse("2021-03-01 12:00:00")));
//
//            for (Booking booking : bookings) {
//                System.out.println(booking);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainWindow.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("CQRS_Booking");
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setY(5);
        double width = 1050;

        primaryStage.setX((primScreenBounds.getWidth() - width) / 2);

        primaryStage.show();
    }
}
