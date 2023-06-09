package FlightControl.domain;

public class Flight {
    
    private Airplane airplane;
    private Place departureId;
    private Place destinationId;

    public Flight(Airplane airplane, Place departureId, Place destinationId) {
        this.airplane = airplane;
        this.departureId = departureId;
        this.destinationId = destinationId;
    }

    @Override
    public String toString() {
        return this.airplane + " (" + this.departureId + "-" + this.destinationId + ")";
    }

}
