package ironhack.schl.repository;


import ironhack.schl.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{

    static Optional<Flight> findFlightsByFlightNumber(String flightNumber){
        return Optional.empty();
    }

    static List<Flight> findFlightsWithDistanceGreaterThan(Integer i){
        return List.of();
    }

    static List<Flight> findAircraftByNameContaining(String boeing){
        return List.of();
    }
}
