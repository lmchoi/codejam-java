package codejam.cj17.r1b;

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

                int n = in.nextInt();
                int q = in.nextInt(); // stops

                // horses
                Horse[] horses = new Horse[n];
                for (int i = 0; i < n; i++) {
                    double e = in.nextLong(); // distance
                    int s = in.nextInt();

                    horses[i] = new Horse(e, s);
                }

                // between cities
                long[][] distances = new long[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        long d = in.nextLong();
                        distances[i][j] = d;
                    }
                }

                // start and destination
                double[] result = new double[q];
                for (int i = 0; i < q; i++) {
                    int u = in.nextInt();
                    int v = in.nextInt();

                    result[i] = calculateMinimumTime(u, v, horses, distances);
                }

                // output
                System.out.print("Case #" + cn + ":");
                for (int i = 0; i < q; i++) {
                    System.out.print(" " + result[i]);
                }
                System.out.println();
            }

        }

        private double calculateMinimumTime(int u, int v, Horse[] horses, long[][] distances) {
            double mt = 0;
            int p = u;
            while (p != v) {
                // TODO find next stop
                int nextStop = u + 1;

                Horse currentHorse = getHorseAt(p, horses);
                mt += minTimeToNextStop(currentHorse, p, nextStop, distances);

                p = nextStop;
            }

            return mt;
        }

        private double minTimeToNextStop(Horse horse, int start, int end, long[][] distances) {

            long routeLength = getRouteLength(start, end, distances);


            return routeLength / horse.s;
        }

        private Horse getHorseAt(int u, Horse[] horses) {
            return horses[u - 1];
        }

        private long getRouteLength(int a, int b, long[][] distances) {
            return distances[a - 1][b - 1];
        }

        private class Horse {
            private final double e;
            private final int s;

            public Horse(double e, int s) {

                this.e = e;
                this.s = s;
            }
        }
    }
}
