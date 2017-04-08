package codejam.codejam;

import java.text.ParseException;
import java.util.BitSet;
import java.util.Scanner;

public class CodeJamMain {
    public static void main (String[] args) throws ParseException {
        ProblemA problem = new ProblemA();
        problem.solve();
    }

    public static class ProblemA {
        Scanner scanner = new Scanner(System.in);

        public void solve() {
            // read inputs
            int numOfCases = scanner.nextInt();
            scanner.nextLine(); // skip to next line
            for (int i = 1; i <= numOfCases; i++) {

                // --- Parsing
                // read space separated lines
                String pancakes = scanner.next();
                int k = scanner.nextInt(); // 2 <= k <= s length

                // find solution
                int solution = solveCase(pancakes, k);

                String output = "IMPOSSIBLE";
                if (solution != -1) {
                    output = String.valueOf(solution);
                }

                // output
                System.out.println("Case #" + i + ": " + output);
            }
        }

        private int solveCase(String pc, int k) {
            BitSet pancakes = new BitSet(pc.length());

            char[] c = pc.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == '+') {
                    pancakes.set(i);
                }
            }

            int flips = 0;

            int i = pancakes.nextClearBit(0);
            while (i < c.length) {
                pancakes.flip(i, (i + k));
                flips++;
                i = pancakes.nextClearBit(i + 1);
            }

            if (pancakes.cardinality() == c.length) {
                return flips;
            }

            return -1;
        }
    }
}
