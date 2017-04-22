package codejam;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CodeJamMain {
    public static boolean DEBUG = true;
    public static void main (String[] args) throws ParseException {
        Problem problem = new Problem();
        problem.solve();
    }

    public static class Problem {
        Scanner in = new Scanner(System.in);
        BigDecimal POINT1 = BigDecimal.valueOf(0.1);
        BigDecimal POINT9 = BigDecimal.valueOf(0.9);
        BigDecimal POINT11 = BigDecimal.valueOf(1.1);

        public void solve() {

            // read inputs
            int numOfCases = in.nextInt();
            in.nextLine(); // skip to next line
            for (int cn = 1; cn <= numOfCases; cn++) {
                int n = in.nextInt();
                int p = in.nextInt();

                Ingredient[] ingredients = new Ingredient[n];
                for (int i = 0; i < n; i++) {
                    ingredients[i] = new Ingredient(in.nextLong());
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < p; j++) {
                        ingredients[i].addPackage(in.nextLong());
                    }
                }

                // output
                int numOfKits = 0;

                while (ingredients[0].hasNextPackage()) {
                    long[] servings = ingredients[0].servingsInNextPackage();

                    for (int ii = 1; ii < n; ii++) {
                        if (servings == null) {
                            break;
                        }
                        servings = ingredients[ii].hasPackageFor(servings);
                    }

                    if (servings != null) {
                        numOfKits++;
                    }
                }
                System.out.println("Case #" + cn + ": " + numOfKits);
            }

        }

        private class Ingredient {
            private final long gramsNeeded;
            private final BigDecimal minGrams;
            private final BigDecimal maxGrams;
            private final BigDecimal diffGrams;

            private final List<Long> packages;

            public Ingredient(long gramsNeeded) {
                this.gramsNeeded = gramsNeeded;
                minGrams = new BigDecimal(gramsNeeded).multiply(POINT9);
                maxGrams = new BigDecimal(gramsNeeded).multiply(POINT11);
                diffGrams = new BigDecimal(gramsNeeded).multiply(POINT1);
                packages = new LinkedList<>();
            }

            public void addPackage(long gramsInPackage) {
                packages.add(gramsInPackage);
                packages.sort((e1, e2) -> e1.compareTo(e2));
            }

            public long[] servingsInNextPackage() {
                Long grams = packages.remove(0);

                long high = (long) (grams / minGrams.doubleValue());
                long low = (long) (grams / maxGrams.doubleValue());



                if (high == 0) {
                    return null;
                }


                return new long[] {low, high};
            }

            public long[] hasPackageFor(long[] requiredServings) {
                while (!packages.isEmpty()) {
                    long[] possibleServings = servingsInNextPackage();

                    if (possibleServings[1] < requiredServings[0] ||
                            possibleServings[0] > requiredServings[1]) {
                        // continue;
                    } else {
                        if (possibleServings[0] > requiredServings[0]) {
                            requiredServings[0] = possibleServings[0];
                        }

                        if (possibleServings[1] < requiredServings[1]) {
                            requiredServings[1] = possibleServings[1];
                        }

                        return requiredServings;
                    }
                }
                return null;
            }

            public boolean hasNextPackage() {
                return !packages.isEmpty();
            }
        }
    }
}
