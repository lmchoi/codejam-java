package codejam.qr;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Scanner;

public class ProblemB {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");

    public void solve() {
        // read inputs
        int numOfCases = scanner.nextInt();
        scanner.nextLine(); // skip to next line
        for (int i = 1; i <= numOfCases; i++) {

            // --- Parsing
            BigInteger n = scanner.nextBigInteger();

            BigInteger r = solveCase(n);

            // output
            System.out.println("Case #" + i + ": " + r);
        }

    }

    private BigInteger solveCase(BigInteger n) {
        String s = n.toString();

        if (s.length() == 1) {
            return n;
        }

        int notTidy = -1;
        char b = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > b) {
                b = c;
            } else if (c < b) {
                notTidy = i;
            }
        }

        if (notTidy != -1) {
            return tidy(s, notTidy);
        } else {
            return n;
        }
    }

    private BigInteger tidy(String s, int notTidy) {
        String s1 = s.substring(0, notTidy);

        BigInteger b1 = new BigInteger(s1);
        BigInteger newB1 = solveCase(b1.subtract(BigInteger.ONE));

        String nine = "9";
        int i = s.length() - notTidy;
        String s2 = String.join("", Collections.nCopies(i, nine));

        return new BigInteger(newB1.toString().concat(s2));
    }
}
