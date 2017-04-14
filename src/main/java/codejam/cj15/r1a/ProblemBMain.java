package codejam.cj15.r1a;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

public class ProblemBMain {
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
                int B = in.nextInt();
                BigInteger N = in.nextBigInteger();
                in.nextLine();

                TreeMap<Integer, BigInteger> barbers = new TreeMap<>();
                BigInteger sumOfBarbers = BigInteger.ZERO;
                for (int i = 0; i < B; i++) {
                    BigInteger m = in.nextBigInteger();
                    sumOfBarbers = sumOfBarbers.add(m);
                    barbers.put(i, m);
                }

                BigInteger pos = N.subtract(BigInteger.ONE).mod(sumOfBarbers);
                System.out.println(pos);
                System.out.println(B);

                if (pos.compareTo(BigInteger.valueOf(B)) > 0) {
                    Stream<Map.Entry<Integer, BigInteger>> sortedBarbers = barbers.entrySet().stream().sorted(Map.Entry.comparingByValue());

                    Iterator<Map.Entry<Integer, BigInteger>> it = sortedBarbers.iterator();
                    BigInteger quickest = it.next().getValue();
                    while (it.hasNext()) {
                        it.next().getValue().mod(quickest).compareTo(BigInteger.ZERO);

                    }

                } else {
                    pos = pos.add(BigInteger.ONE);
                }

                // output
                System.out.println("Case #" + cn + ": " + pos);
            }

        }
    }
}
