package codejam.cj16.r1c;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Scanner;

public class CodeJamMainB {
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

                int b = in.nextInt(); // # of buildings
                BigInteger m = in.nextBigInteger();

                BigInteger lim = BigInteger.valueOf(2).pow(b - 2);

                if (m.compareTo(lim) > 0) {
                    System.out.println("Case #" + cn + ": IMPOSSIBLE");
                    continue;
                }

                int[][] slides = new int[b][b];

                String s = m.toString(2);
                long[] ls = s.chars().map(c -> c - '0').asLongStream().toArray();

                int ii = 1;
                if (lim.equals(m)) {
                    ii = 0;
                } else {
                    int os = b - ls.length - 1;
                    for (int i = 0; i < ls.length; i++) {
                        slides[0][i + os] = (int) ls[i];
                    }
                }

                for (int i = ii; i < b; i++) {
                    int x = 1 + i;
                    for (int j = x; j < b; j++) {
                        slides[i][j] = 1;
                    }
                }

                System.out.println("Case #" + cn + ": POSSIBLE");
                printResults(slides);
            }

        }

        public void printResults(int[][] m) {
            for (int i = 0; i < m.length; i++) {
                System.out.print(m[i][0]);
                for (int j = 1; j < m[i].length; j++) {
                    System.out.print(m[i][j]);
                }
                System.out.println();
            }

        }
    }
}
