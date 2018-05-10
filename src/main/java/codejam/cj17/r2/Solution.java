import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner;
    private final int i;

    private Solution(Scanner scanner, int i) {
        this.scanner = scanner;
        this.i = i + 1;
    }

    private void solve() {
        int seats = scanner.nextInt();
        int customers = scanner.nextInt();
        int tickets = scanner.nextInt();

        int[] seatsTaken = new int[seats]; // by row
        int[] ticketsBrought = new int[customers]; // by customer
        for (int j = 0; j < tickets; j++) {
            int p = scanner.nextInt(); // position
            int b = scanner.nextInt(); // buyer

            Ticket ticket = new Ticket(p, b);
            ticketsBrought[ticket.customerId]++;
            seatsTaken[ticket.seatId]++;
        }

        OptionalInt highestNumTicketsByCustomer = Arrays.stream(ticketsBrought).max();
        int minRidesByTicketsSold = divideRoundUp(seats, tickets);
        int minNumOfRides = Math.max(highestNumTicketsByCustomer.getAsInt(), minRidesByTicketsSold);

        int numOfPromos = 0; // z

        int available = 0;
        int j = 0;
        while (j < seats) {
            int extras = minNumOfRides - seatsTaken[j];

            if (extras > 0) {
                available += extras;
            } else if (extras < 0) {
                available += extras;

                if (available < 0) {
                    minNumOfRides++;
                    j = 0;
                    available = 0;
                    numOfPromos = 0;
                    continue;
                } else {
                    numOfPromos -= extras;
                }
            }
            j++;
        }


        System.out.println(String.format("Case #%d: %d %d", i, minNumOfRides, numOfPromos));
    }

    private int divideRoundUp(int n, int d) {
        return (d + n - 1) / n;
    }

    public class Ticket {
        final int seatId;
        final int customerId;

        public Ticket(int seatId, int customerId) {
            this.seatId = seatId - 1;
            this.customerId = customerId - 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            Solution solution = new Solution(scanner, i);
            solution.solve();
        }
    }
}
