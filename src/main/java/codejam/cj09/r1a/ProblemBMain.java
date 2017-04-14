package codejam.cj09.r1a;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Scanner;

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

                int n = in.nextInt();
                int m = in.nextInt();
                int bottomRow = n * 2 - 1;
                int rightColumn = m * 2 - 1;

                Intersection[][] intersections = new Intersection[n][m];
                Node[][] nodes = new Node[n * 2][m * 2];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        BigInteger s = in.nextBigInteger();
                        BigInteger w = in.nextBigInteger();
                        BigInteger t = in.nextBigInteger();

                        intersections[i][j] = new Intersection(s, w, t);

                        int i2 = i * 2;
                        int j2 = j * 2;
                        nodes[i2][j2] = new Node(i2, j2, intersections[i][j]);
                        nodes[i2][j2 + 1] = new Node(i2, j2 + 1, intersections[i][j]);
                        nodes[i2 + 1][j2] = new Node(i2 + 1, j2, intersections[i][j]);
                        nodes[i2 + 1][j2 + 1] = new Node(i2 + 1, j2 + 1, intersections[i][j]);
                    }
                }

                Node endNode = nodes[0][rightColumn];
                Node startingNode = nodes[bottomRow][0];

                //startingNode.considerNeighbours(endNode);

                int d = endNode.distanceBetween(startingNode);
                System.out.println(d);
                String solution = null;
                // output
                System.out.println("Case #" + cn + ": " + solution);
            }

        }

        private class Node {
            private final int x;
            private final int y;
            private final Intersection intersections;

            public Node(int x, int y, Intersection intersections) {
                this.x = x;
                this.y = y;
                this.intersections = intersections;
            }

            public int distanceBetween(Node other) {
                int dx = Math.abs(other.x - this.x);
                int dy = Math.abs(other.y - this.y);
                return dx + dy;
            }

            //public List<Path> considerNeighbours(Node destination) {
            //    if (y % 2 != 0) {
            //        // check boundary
            //        // consider up intersection
            //        // down grass
            //    }
            //
            //    if (x % 2 == 0) {
            //        // check boundary
            //        // consider going west at intersection
            //        // east grass
            //    }
            //}
        }

        private class Intersection {
            private final BigInteger s;
            private final BigInteger w;
            private final BigInteger t;

            public Intersection(BigInteger s, BigInteger w, BigInteger t) {
                this.s = s;
                this.w = w;
                this.t = t;
            }
        }
    }
}
