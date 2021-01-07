# CQRS_Booking_Service
- gradle run um das Programm zu starten (JavaFX UI)
- Book Room: Raum Nummer wird beim Buchen je nach Datum automatisch angezeigt wenn verfügbar (wenn bereits vergeben kann man den Raum nicht auswählen)
- Cancel Booking: booking id ist immer: "booking: NR"  -> wobei NR immer die Nummer der Buchung ist (erste Buchung hat Nr: 1, zweite Nr 2 etc.)
- Get Bookings: einfach Start und Enddatum eingeben, die Buchungen werden in der TextArea angezeigt
- Get Free Rooms: Start und Enddatum sowie gewünschte Personenanzahl angeben, Räume werden ebenfalls in TextArea angezeigt

# Commands:
- Beim Klick auf den Book Room Button published unser BookingService über den EventPublisher das CreateBooking Command, diese wird an alle
Subscriber des Eventpublisher gesendet
- Der EventPublisher unterscheidet je nach Command wie das Command gehandled werden soll
- Die Subscriber sind unsere Aggregates welche aus dem Command ein Event erstellen und dieses in den EventStore speichern
- Über den jeweiligen Projector wird das Event welches über die Facade geladen wird in die jeweiligen Read Repositories projeziert

# Queries:
- Beim Klick auf die Buttons welche unsere Queries entsprechen, wird über die jeweilige Projection die Query über die Facade an die Read Repositories gesendet
- In den Read Repositories werden dann die Queries verarbeitet und die Ergebnisse über die Facade zurück geschickt.
