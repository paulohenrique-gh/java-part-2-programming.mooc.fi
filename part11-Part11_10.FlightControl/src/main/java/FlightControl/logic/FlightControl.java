package FlightControl.logic;

import java.util.Collection;
import java.util.HashMap;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;

public class FlightControl {
    
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Place> places;
    private HashMap<String, Flight> flights;

    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.places = new HashMap<>();
        this.flights = new HashMap<>();
    }

    public void addAirplane(String id, int capacity) {
        this.airplanes.put(id, new Airplane(id, capacity));
    }

    public void addFlight(Airplane airplane, String departureId, String destinationId) {
        this.places.putIfAbsent(departureId, new Place(departureId));
        this.places.putIfAbsent(destinationId, new Place(destinationId));

        Flight flight = new Flight(airplane, this.places.get(departureId), this.places.get(destinationId));
        this.flights.put(flight.toString(), flight);
    }

    public Collection<Airplane> getAirplanes() {
        return this.airplanes.values();
    }

    public Collection<Flight> getFlights() {
        return this.flights.values();
    }

    public Airplane getAirplane(String id) {
        return this.airplanes.get(id);
    }

}
