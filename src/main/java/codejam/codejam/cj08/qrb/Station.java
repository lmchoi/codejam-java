package codejam.codejam.cj08.qrb;


import org.joda.time.DateTime;

import java.util.LinkedList;
import java.util.List;

public class Station {
    private final int turnaroundTime;
    int counter = 0;
    List<DateTime> trains = new LinkedList<DateTime>();

    public Station(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public void nextTrain(Trip trip) {
        if (trains.isEmpty()) {
            counter++;
        } else {
            DateTime nextAvailableAt = trains.get(0);
            if (nextAvailableAt.isAfter(trip.getDeparture())) {
                counter++;
            } else {
                trains.remove(0);
            }
        }
    }

    public void updateIncoming(Trip trip) {
        trains.add(trip.getArrival().plusMinutes(turnaroundTime));
        trains.sort((t, o) -> t.compareTo(o));
    }

    public int getCounter() {
        return counter;
    }
}
