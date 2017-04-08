package codejam.codejam;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Scanner;

public class CodeJamMain {
    public static void main (String[] args) throws ParseException {
        ProblemA problem = new ProblemA();
        problem.solve();
    }

    public static class ProblemA {
        BigInteger TWO = new BigInteger("2");

        Scanner scanner = new Scanner(System.in);

        public void solve() {
            // read inputs
            int numOfCases = scanner.nextInt();
            scanner.nextLine(); // skip to next line
            for (int i = 1; i <= numOfCases; i++) {

                BigInteger n = scanner.nextBigInteger();
                BigInteger k = scanner.nextBigInteger();

                BigInteger[] solution = solveCase(n, k);

                //System.out.println("Input n = " + n + ", k = " + k);
                // output
                System.out.println("Case #" + i + ": " + solution[0] + " " + solution[1]);
            }

        }

        private BigInteger[] solveCase(BigInteger n, BigInteger k) {
            // find which layer
            int i = k.bitLength();
            //System.out.println("Level: " + i);
            BigInteger a = k.clearBit(i - 1);
            //System.out.println("Across: " + a);

            BigInteger[] ret = new BigInteger[2];
            BigInteger x = n;
            while (i != 0) {
                ret = nextLevel(x);

                if (a.equals(BigInteger.ZERO)) {
                    x = ret[0];
                } else {
                    x = ret[1];
                }
                i--;
            }

            return ret;
        }

        private BigInteger[] nextLevel(BigInteger n) {
            BigInteger[] ret = new BigInteger[2];

            if (n.equals(BigInteger.ZERO)) {
                ret[0] = BigInteger.ZERO;
                ret[1] = BigInteger.ZERO;
                return ret;
            }

            BigInteger[] d2 = n.divideAndRemainder(TWO);

            ret[0] = d2[0];

            if (d2[1].equals(BigInteger.ZERO)) {
                ret[1] = d2[0].subtract(BigInteger.ONE);
            } else {
                ret[1] = d2[0];
            }

            return ret;
        }
    }
}
