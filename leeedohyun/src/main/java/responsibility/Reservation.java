package responsibility;

import movie.Money;

public class Reservation {

    private data.Customer customer;
    private data.Screening screening;
    private Money fee;
    private int audienceCount;

    public Reservation(data.Customer customer, data.Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
