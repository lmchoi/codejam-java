package codejam;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.util.Scanner;

public class CodeJamMainTemplate {
    public static boolean DEBUG = true;
    public static void main (String[] args) throws ParseException {
        Problem problem = new Problem();
        problem.solve();
    }

    public static class Problem {
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

                // convert 123 to [1, 2, 3]
                // String.valueOf(a).chars().map(c -> c -= '0').toArray();

                // find solution
                Solution solution = null;

                // output
                System.out.println("Case #" + i + ": " + solution);
            }

        }

    }

    public static class Solution {
        private final boolean r;

        public Solution(boolean r) {
            this.r = r;
        }

        @Override
        public String toString() {
            return r ? "ON" : "OFF";
        }

        // two ints, strings etc, careful with chars!
        //@Override
        //public String toString() {
        //    return a + " " + b;
        //}


        // char array
        //@Override
        //public String toString() {
        //    return String.valueOf(arr).replace("", " ").trim();
        //}
    }
}
