package ironhack.schl.repository;

import ironhack.schl.Model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer>{
}
