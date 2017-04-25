package codejam.cj17.r1b;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public class CodeJamMainA {
    public static boolean DEBUG = true;
    public static void main (String[] args) throws ParseException {
        Problem problem = new Problem();
        problem.solve();
    }

    public static class Problem {
        Scanner in = new Scanner(System.in);

        public void solve() {
            // read inputs
            int numOfCases = in.nextInt();
            in.nextLine(); // skip to next line
            for (int cn = 1; cn <= numOfCases; cn++) {

                // destination
                long d = in.nextLong();
                // other horses
                int n = in.nextInt();

                double timeTaken[] = new double[n];
                for (int i = 0; i < n; i++) {
                    // initial position
                    long k = in.nextLong();
                    // speed km/hr
                    int s = in.nextInt();

                    double distance = d - k;
                    timeTaken[i] = distance / s;
                }

                Arrays.sort(timeTaken);

                double speed = d / timeTaken[n-1];

                // output
                System.out.println("Case #" + cn + ": " + speed);
            }

        }
    }
}
