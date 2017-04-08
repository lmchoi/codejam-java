package codejam.codejam.cj11.r1;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Scanner;

public class ProblemA {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");

    public void solve() {
        // read inputs
        int numOfCases = scanner.nextInt();
        scanner.nextLine(); // skip to next line
        for (int i = 1; i <= numOfCases; i++) {
            int n = scanner.nextInt(); // no more than n games (D <= N)
            int pd = scanner.nextInt(); // games won today
            int pg = scanner.nextInt(); // ever

            // find solution
            boolean possible = solveCase(n, pd, pg);
            String result = possible ? "Possible" : "Broken";
            // output
            System.out.println("Case #" + i + ": " + result);
        }

    }

    private boolean solveCase(int n, int pd, int pg) {
        int d = n;
        int wd = pd * d;

        return false;

    }

}
