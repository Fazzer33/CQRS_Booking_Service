package at.fhv.sysarch.lab4.Queries;

import java.util.Date;

public class GetBookings {
    private Date startDate;
    private Date endDate;

    public GetBookings(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
