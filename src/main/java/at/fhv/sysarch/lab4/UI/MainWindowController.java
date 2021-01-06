package at.fhv.sysarch.lab4.UI;

import at.fhv.sysarch.lab4.Aggregate.BookingAggregate;
import at.fhv.sysarch.lab4.Domain.Booking;
import at.fhv.sysarch.lab4.Domain.Guest;
import at.fhv.sysarch.lab4.Events.EventPublisher;
import at.fhv.sysarch.lab4.Facade;
import at.fhv.sysarch.lab4.Projections.BookingProjection;
import at.fhv.sysarch.lab4.Projector.BookingProjector;
import at.fhv.sysarch.lab4.Queries.GetBookings;
import at.fhv.sysarch.lab4.Service.BookingService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class MainWindowController {

    private Facade facade = new Facade();
    private BookingService bookingService = new BookingService();
    private EventPublisher publisher = new EventPublisher();
    private BookingAggregate bookingAggregate = new BookingAggregate(facade.getEventStore());
    // write
    private BookingProjector bookingProjector = new BookingProjector(facade.getBookingReadRepository());
    // read
    private BookingProjection bookingProjection = new BookingProjection(facade.getBookingReadRepository());
    private int bookingId = 1;

    @FXML
    private void initialize() {
        publisher.subscribe(bookingAggregate);
        roomSelection.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6"));
    }

    @FXML
    private Button bookRoomButton;

    @FXML
    private Button cancelBookingButton;

    @FXML
    private Button getBookingsButton;

    @FXML
    private Button getRoomsButton;

    @FXML
    private TextArea consoleField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField nameField;

    @FXML
    private DatePicker bookRoomStart;

    @FXML
    private DatePicker bookRoomEnd;

    @FXML
    private ComboBox<String> roomSelection;

    @FXML
    private TextField reservationNrField;

    @FXML
    private DatePicker getBookingsStart;

    @FXML
    private DatePicker getBookingsEnd;

    @FXML
    private DatePicker getRoomsStart;

    @FXML
    private DatePicker getRoomsEnd;

    @FXML
    private ComboBox<String> personsPicker;

    @FXML
    void bookRoomAction(ActionEvent event) {
        String bookingId = getBookingId();
        bookingService.createBooking(bookingId, bookRoomStart.getValue(), bookRoomEnd.getValue(),
                roomSelection.getValue(), new Guest(nameField.getText(), addressField.getText()));
        bookingProjector.project(facade.getEventStore().getEvents(bookingId));
        consoleField.appendText("Booking complete");
        System.out.println();
    }

    @FXML
    void getBookingsAction(ActionEvent event) {
        List<Booking> bookings = bookingProjection.handle(new GetBookings(getBookingsStart.getValue(),
                getBookingsEnd.getValue()));

        for (Booking booking : bookings) {
            consoleField.appendText(booking.toString());
            System.out.println();
        }

    }

    @FXML
    void getRoomsAction(ActionEvent event) {

    }

    private String getBookingId() {
        String id = "booking: "+bookingId++;
        return id;
    }

}
