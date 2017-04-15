package codejam.cj17.r1a;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Scanner;

public class CodeJamMainC {
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
                BigInteger Hd = in.nextBigInteger();
                BigInteger Ad = in.nextBigInteger();
                BigInteger Hk = in.nextBigInteger();
                BigInteger Ak = in.nextBigInteger();
                BigInteger B = in.nextBigInteger();
                BigInteger D = in.nextBigInteger();

                BigInteger toKillD = hitsToKill(Hd, Ak);
                BigInteger toKillK = hitsToKill(Hk, Ad);

                BigInteger turns = null;
                if (toKillD.compareTo(toKillK) < 0) {
                    BigInteger healthSave = (toKillD.subtract(BigInteger.ONE)).multiply(D);
                    BigInteger increaseAttack = (toKillD.subtract(BigInteger.ONE)).multiply(B);


                } else {
                    turns = toKillK;
                }

                System.out.println(toKillD);
                System.out.println(toKillK);

                String solution;
                if (turns != null) {
                    solution = turns.toString();
                } else {
                    solution = "IMPOSSIBLE";
                }
                // output
                System.out.println("Case #" + cn + ": " + solution);
            }

        }
        
        

        private BigInteger hitsToKill(BigInteger h, BigInteger a) {

            BigInteger[] hits = h.divideAndRemainder(a);
            if (hits[1].compareTo(BigInteger.ZERO) > 0) {
                return hits[0].add(BigInteger.ONE);
            } else {
                return hits[0];
            }
        }
    }
}
