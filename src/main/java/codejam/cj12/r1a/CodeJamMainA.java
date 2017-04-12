package codejam.cj12.r1a;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class CodeJamMainA {
    public static boolean DEBUG = true;
    public static void main (String[] args) throws ParseException {
        System.out.println("A");
        Problem problem = new Problem();
        problem.solve();
    }

    public static class Problem {
        Scanner in = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        Map<Integer, Double> cacheP = new ConcurrentHashMap<>();

        public void solve() {
            // read inputs
            int numOfCases = in.nextInt();
            in.nextLine(); // skip to next line
            for (int cn = 1; cn <= numOfCases; cn++) {
                int a = in.nextInt(); // already typed
                int b = in.nextInt(); // total num of chars in password
                double[] p = new double[a];
                double[] ip = new double[a];
                for (int i = 0; i < a; i++) {
                    // probability of being correct
                    p[i] = in.nextDouble(); // at most one decimal point

                    // incorrect
                    ip[i] = 1 - p[i];
                }



                // all correct
                double allCorrectP = 1;
                for (int i = 0; i < a; i++) {
                    allCorrectP = allCorrectP * p[i];
                }

                // all wrong
                double allCorrectW = 1;
                for (int i = 0; i < a; i++) {
                    allCorrectW = allCorrectW * ip[i];
                }

                double y = 0; // expected number (to type remaining (b - a) characters
                // excluding letters typed so far)

                // find solution
                Solution solution = null;

                // output
                System.out.println("Case #" + cn + ": " + solution);
            }
        }
        //
        //Double doubleValue(Double x) {
        //
        //    return cache.computeIfAbsent(x, z -> (y1, y2) -> );
        //}
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
