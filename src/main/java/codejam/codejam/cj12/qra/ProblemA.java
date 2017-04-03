package codejam.codejam.cj12.qra;

import codejam.codejam.Case;
import codejam.codejam.Solution;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigInteger;
import java.util.Scanner;

public class ProblemA {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");

    public void solve() {
        // read inputs
        int numOfCases = scanner.nextInt();
        scanner.nextLine(); // skip to next time
        for (int i = 1; i <= numOfCases; i++) {
            Case c = parseCase();

            // find solution
            Solution solution = c.solve();

            // output
            System.out.println("Case #" + i + ": " + solution);
        }

    }

    private Case parseCase() {
        Integer n = scanner.nextInt();
        BigInteger k = scanner.nextBigInteger();

        return new Case(n, k);
    }
}
