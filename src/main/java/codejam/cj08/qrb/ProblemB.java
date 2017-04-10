package codejam.cj08.qrb;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemB {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");

    private TrainCase parseCase() throws ParseException {
        // for each case
        int turnaroundTime = scanner.nextInt();
        int numberOfTripsA = scanner.nextInt();
        int numberOfTripsB = scanner.nextInt();

        List<Trip> trips = new ArrayList<>();
        for (int i = 0; i < numberOfTripsA; i++) {
            addTrip(scanner, trips, 'A', 'B');
        }

        for (int i = 0; i < numberOfTripsB; i++) {
            addTrip(scanner, trips, 'B', 'A');
        }

        trips.sort((t, o) -> {
            int res = t.getDeparture().compareTo(o.getDeparture());
            if (res == 0) {
                res = t.getArrival().compareTo(o.getArrival());
            }
            return res;
        });

        return new TripCase(trips, turnaroundTime);
    }

    private void addTrip(Scanner scanner, List<Trip> trips, char departingStation, char destination) throws ParseException {
        String departureStr = scanner.next();
        DateTime departure = formatter.parseDateTime(departureStr);

        String arrivalStr = scanner.next();
        DateTime arrival = formatter.parseDateTime(arrivalStr);

        trips.add(new Trip(departure, arrival, departingStation, destination));
    }

    public void solve() throws ParseException {
        int numOfCases = scanner.nextInt();

        for (int i = 1; i <= numOfCases; i++) {
            TrainCase c = parseCase();
            TrainSolution solve = c.solve();
            System.out.println("Case #" + i + ": " + solve);
        }
    }
}
