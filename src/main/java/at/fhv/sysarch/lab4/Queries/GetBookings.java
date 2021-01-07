package at.fhv.sysarch.lab4.Queries;

import java.time.LocalDate;

public class GetBookings {
    private LocalDate startDate;
    private LocalDate endDate;

    public GetBookings(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
