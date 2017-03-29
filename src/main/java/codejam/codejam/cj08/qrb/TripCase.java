package codejam.codejam.cj08.qrb;

import codejam.codejam.Case;
import codejam.codejam.TrainSolution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripCase implements Case {
    private final List<Trip> trips;

    Map<Character, Station> stations;

    public TripCase(List<Trip> trips, int turnaroundTime) {
        this.trips = trips;
        stations = new HashMap<Character, Station>();
        stations.put('A', new Station(turnaroundTime));
        stations.put('B', new Station(turnaroundTime));
    }

    @Override
    public TrainSolution solve() {
        for (Trip trip : trips) {
            Station station = stations.get(trip.getDepartingStation());
            station.nextTrain(trip);

            Station destination = stations.get(trip.getDestination());
            destination.updateIncoming(trip);
        }

        return new TrainSolution(stations.get('A').getCounter(), stations.get('B').getCounter());
    }
}
