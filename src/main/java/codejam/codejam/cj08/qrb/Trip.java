package codejam.codejam.cj08.qrb;

import org.joda.time.DateTime;

public class Trip {
    private final DateTime departure;
    private final DateTime arrival;
    private final char departingStation;
    private final char destination;

    public Trip(DateTime departure, DateTime arrival, char departingStation, char destination) {
        this.departure = departure;
        this.arrival = arrival;
        this.departingStation = departingStation;
        this.destination = destination;
    }

    public DateTime getDeparture() {
        return departure;
    }

    public DateTime getArrival() {
        return arrival;
    }

    public char getDepartingStation() {
        return departingStation;
    }

    public char getDestination() {
        return destination;
    }
    @Override
    public String toString() {
        return "Trip{" +
                "departure=" + departure +
                ", arrival=" + arrival +
                ", departingStation=" + departingStation +
                '}';
    }

}
