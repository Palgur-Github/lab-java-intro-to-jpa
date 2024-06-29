package ironhack.schl.Model;

import jakarta.persistence.*;

@Entity
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer bookingId;

    @OneToOne
    @Column(name = "customer_id")
    private Integer costumerId;

    @OneToOne
    @Column(name = "flight_id")
    private Integer flightId;

    public FlightBooking() {

    }

    public FlightBooking(Integer costumerId, Integer flightId) {
        this.costumerId = costumerId;
        this.flightId = flightId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(Integer costumerId) {
        this.costumerId = costumerId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "FlightBooking{" +
                "bookingId=" + bookingId +
                ", costumerId=" + costumerId +
                ", flightId=" + flightId +
                '}';
    }
}
