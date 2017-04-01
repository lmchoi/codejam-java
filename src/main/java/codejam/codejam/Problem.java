package codejam.codejam;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Scanner;

public class Problem {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");

    public void solve() {
        // read inputs
        int numOfCases = scanner.nextInt();

        for (int i = 1; i <= numOfCases; i++) {
            Case c = parseCase();

            // find solution
            Solution solution = c.solve();

            // output
            System.out.println("Case #" + i + ": " + solution);
        }

    }

    private Case parseCase() {




        // parse time
        //String timeStr = scanner.next();
        //DateTime t = formatter.parseDateTime(timeStr);

        return null;
    }
}
