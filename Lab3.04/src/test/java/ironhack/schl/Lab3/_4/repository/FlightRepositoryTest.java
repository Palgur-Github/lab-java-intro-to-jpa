package ironhack.schl.Lab3._4.repository;

import ironhack.schl.LabThreeDotZeroFourApplication;
import ironhack.schl.Model.Flight;
import ironhack.schl.repository.FlightRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = LabThreeDotZeroFourApplication.class)
public class FlightRepositoryTest {
    @Autowired
    private FlightRepository flightRepository;

    private Flight testFlight;

    @BeforeEach
    void setUp() {
        testFlight = new Flight("L203", "BOEING 747", 200, 600);
    }

    @AfterEach
    void tearDown() {
        flightRepository.deleteById(testFlight.getFlightId());
    }

    @Test
    public void testCreateFlight() {
        Flight testFlight = new Flight("FL123", "BOEING 747", 200, 600);
        Flight savedFlight = flightRepository.save(testFlight);
        assertNotNull(savedFlight.getFlightId());
        assertEquals(testFlight.getFlightNumber(), savedFlight.getFlightNumber());
        assertEquals(testFlight.getAircraft(), savedFlight.getAircraft());
        assertEquals(testFlight.getTotalAircraftSeats(), savedFlight.getTotalAircraftSeats());
        assertEquals(testFlight.getFlightMileage(), savedFlight.getFlightMileage());
    }


    @Test
    public void testFindFlightsByFlightNumber() {
        Flight testFlight = new Flight("FL123", "BOEING 747", 200, 600);
        Flight savedFlight = flightRepository.save(testFlight);
        Optional<Flight> foundFlight = FlightRepository.findFlightsByFlightNumber(testFlight.getFlightNumber());
        assertTrue(foundFlight.isPresent());
        assertEquals(testFlight, foundFlight.get());
    }

    @Test
    public void testFindAircraftByNameContainingBoeing() {
        Flight testFlight2 = new Flight("FL123", "BOEING 747", 200, 600);
        Flight savedAircraft = flightRepository.save(testFlight2);
        List<Flight> aircraftByNameContainingBoeing = FlightRepository.findAircraftByNameContaining("Boeing");
        assertTrue(aircraftByNameContainingBoeing.contains(savedAircraft));
    }

    @Test
    public void testFindFlightsWithDistanceGreaterThan500() {
        Flight testFlight = new Flight("FL123", "JFK", 200, 600);
        Flight savedFlight = flightRepository.save(testFlight);
        List<Flight> flightsWithDistanceGreaterThan500 = FlightRepository.findFlightsWithDistanceGreaterThan(500);
        assertTrue(flightsWithDistanceGreaterThan500.contains(savedFlight));
    }
}
