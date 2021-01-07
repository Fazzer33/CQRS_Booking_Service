package at.fhv.sysarch.lab4.UI;

import at.fhv.sysarch.lab4.Aggregate.BookingAggregate;
import at.fhv.sysarch.lab4.Domain.Booking;
import at.fhv.sysarch.lab4.Domain.Guest;
import at.fhv.sysarch.lab4.Domain.Room;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MainWindowController {

    private Facade facade = new Facade();
    private BookingService bookingService = new BookingService(facade);
    private EventPublisher publisher = new EventPublisher();
    private BookingAggregate bookingAggregate = new BookingAggregate(facade);
    // write
    private BookingProjector bookingProjector = new BookingProjector(facade);
    // read
    private BookingProjection bookingProjection = new BookingProjection(facade);
    private int bookingId = 1;
    private LocalDate bookingStartDate;

    @FXML
    private void initialize() {
        publisher.subscribe(bookingAggregate);
        bookRoomStart.valueProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue != null) {
                bookingStartDate = newValue;
            }
        }));
        bookRoomEnd.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Map<String, Room> rooms = facade.getRoomReadRepository().getAllFreeRooms();
                ObservableList<String> list = FXCollections.observableArrayList();
                list.addAll(rooms.keySet());
                List<Booking> bookings = facade.getBookingReadRepository().getBookingByPeriod(bookingStartDate, newValue);
                for (Booking booking: bookings) {
                    System.out.println(booking.getRoomNumber());
                    list.remove(booking.getRoomNumber());
                }

                roomSelection.setItems(FXCollections.observableArrayList(list));
            }
        });
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
        consoleField.appendText("Booking complete\n");
        consoleField.appendText(facade.getBookingReadRepository().getBookingByBookingId(bookingId).toString()+ "\n\n");
        bookRoomStart.setValue(null);
        bookRoomEnd.setValue(null);
    }

    @FXML
    void cancelBookingAction(ActionEvent event) {
        Booking booking = bookingService.cancelBooking(reservationNrField.getText());
        if (facade.getEventStore().getEvents(booking.getBookingId()) != null) {
            bookingProjector.project(facade.getEventStore().getEvents(booking.getBookingId()));
        }
        consoleField.appendText("Booking with id: "+booking.getBookingId() +"got canceled\n\n");
        reservationNrField.clear();
        bookRoomStart.setValue(null);
        bookRoomEnd.setValue(null);
    }

    @FXML
    void getBookingsAction(ActionEvent event) {
        List<Booking> bookings = bookingProjection.handle(new GetBookings(getBookingsStart.getValue(),
                getBookingsEnd.getValue()));

        consoleField.appendText("Booking in your requested period\n");
        for (Booking booking : bookings) {
            consoleField.appendText(booking.toString()+"\n");
        }
        consoleField.appendText("\n");
    }

    @FXML
    void getRoomsAction(ActionEvent event) {

    }

    private String getBookingId() {
        String id = "booking: "+bookingId++;
        return id;
    }

}
