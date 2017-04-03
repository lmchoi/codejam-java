package codejam.codejam;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Scanner;

public class Problem {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");

    public void solve() {
        // read inputs
        int numOfCases = scanner.nextInt();
        scanner.nextLine(); // skip to next line
        for (int i = 1; i <= numOfCases; i++) {

            // --- Parsing
            // read space separated lines
            String line = scanner.nextLine();
            String[] bases = line.split("\\s+");

            // read date
            String timeString = scanner.next();
            DateTime dt = formatter.parseDateTime(timeString);


            // find solution
            Solution solution = null;

            // output
            System.out.println("Case #" + i + ": " + solution);
        }

    }

}
