package codejam.cj17.qr;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProblemCMain {
    public static void main (String[] args) throws ParseException {
        ProblemC problem = new ProblemC();
        problem.solve();
    }

    public static class ProblemC {
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
            int requiredLevel = k.bitLength();
            //System.out.println("Level: " + i);
            //BigInteger a = k.clearBit(requiredLevel - 1);
            //System.out.println("Across: " + a);

            BigInteger[] ret = new BigInteger[2];
            int i = 0;

            // top level
            TreeMap<TPair, BigInteger> allValues = new TreeMap<>();
            TPair biPair = nextLevel(n);
            allValues.put(biPair, BigInteger.ONE);

            TreeMap<TPair, BigInteger> nextValues = allValues;
            while (i < requiredLevel) {
                nextValues = getValuesForNextLevel(nextValues);
                allValues.putAll(nextValues);
                i++;
            }

            BigInteger x = k;
            for(Map.Entry<TPair,BigInteger> entry : allValues.descendingMap().entrySet()) {
                x = x.subtract(entry.getValue());
                if (x.compareTo(BigInteger.ZERO) > 0) {
                    continue;
                }
                return entry.getKey().lr;
            }

            return ret;
        }

        private TreeMap<TPair, BigInteger> getValuesForNextLevel(TreeMap<TPair, BigInteger> valuesAtLevel) {
            TreeMap<TPair, BigInteger> nextValues = new TreeMap<>();

            for(Map.Entry<TPair,BigInteger> entry : valuesAtLevel.entrySet()) {
                TPair lr = entry.getKey();
                BigInteger count = entry.getValue();

                //System.out.println(lr + " count: " + count);

                TPair lChild = nextLevel(lr.getL());
                if (nextValues.containsKey(lChild)) {
                    nextValues.put(lChild, count.add(nextValues.get(lChild)));
                } else {
                    nextValues.put(lChild, count);
                }

                TPair rChild = nextLevel(lr.getR());
                if (nextValues.containsKey(rChild)) {
                    nextValues.put(rChild, count.add(nextValues.get(rChild)));
                } else {
                    nextValues.put(rChild, count);
                }
            }

            return nextValues;
        }

        private TPair nextLevel(BigInteger n) {
            BigInteger[] ret = new BigInteger[2];

            if (BigInteger.ONE.compareTo(n) >= 0) {
                ret[0] = BigInteger.ZERO;
                ret[1] = BigInteger.ZERO;
                return new TPair(ret);
            }

            BigInteger[] d2 = n.divideAndRemainder(TWO);

            ret[0] = d2[0];

            if (d2[1].equals(BigInteger.ZERO)) {
                ret[1] = d2[0].subtract(BigInteger.ONE);
            } else {
                ret[1] = d2[0];
            }

            return new TPair(ret);
        }
    }

    private static class TPair implements Comparable<TPair> {
        private final BigInteger[] lr;

        public TPair(BigInteger[] lr) {
            this.lr = lr;
        }

        public BigInteger getL() {
            return lr[0];
        }

        public BigInteger getR() {
            return lr[1];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TPair)) return false;

            TPair tPair = (TPair) o;

            if (!Arrays.equals(lr, tPair.lr)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return lr != null ? Arrays.hashCode(lr) : 0;
        }

        @Override
        public int compareTo(TPair o) {
            int ct = getL().compareTo(o.getL());
            if (ct == 0) {
                ct = getR().compareTo(o.getR());
            }
            return ct;
        }

        @Override
        public String toString() {
            return "TPair{" +
                    "lr=" + Arrays.toString(lr) +
                    '}';
        }
    }
}
