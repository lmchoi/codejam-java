package codejam.cj12.r1a;

import java.text.ParseException;
import java.util.Scanner;
import java.util.TreeSet;

public class CodeJamMainB {
    public static boolean DEBUG = true;
    public static void main (String[] args) throws ParseException {
        System.out.println("B");
        Problem problem = new Problem();
        problem.solve();
    }

    public static class Problem {
        Scanner in = new Scanner(System.in);

        public void solve() {
            // read inputs
            int numOfCases = in.nextInt();
            in.nextLine(); // skip to next line
            TreeSet<Level> levels = new TreeSet<>();
            for (int cn = 1; cn <= numOfCases; cn++) {
                int n = in.nextInt(); // # of levels
                for (int i = 0; i < n; i++) {
                    int a = in.nextInt(); // # of stars to get 1-star rating
                    int b = in.nextInt(); // " 2-star rating
                    Level level = new Level(a, b);
                    levels.add(level);
                }

                int stars = 0;
                int plays = 0;
                int levelsPlayed = 0;
                //levels.stream().
                //stars++;


                while (levelsPlayed != n) {
                    for (Level level : levels) {
                        if (stars >= level.b) {
                            plays++;
                            //stars += level.play();
                        }
                    }

                    for (Level level : levels) {
                        if (stars >= level.a) {

                        }
                    }
                }


                // # min completed levels or "Too Bad"
                String y;
                if (stars > 0) {
                    y = String.valueOf(plays);
                } else {
                    y = "Too Bad";
                }

                // output
                System.out.println("Case #" + cn + ": " + y);
            }

        }

        public class Level implements Comparable<Level> {
            private final int a;
            private final int b;
            private boolean ca;
            private boolean cb;

            public Level(int a, int b) {
                this.a = a;
                this.b = b;
                ca = false;
                cb = false;
            }

            @Override
            public int compareTo(Level other) {
                int c = this.b - other.b;
                if (c == 0) {
                    return this.a - other.a;
                }
                return c;
            }

            @Override
            public String toString() {
                return "Level{" +
                        "a=" + a +
                        ", b=" + b +
                        '}';
            }

            public int play(boolean b) {
                if (b) {
                    cb = true;
                    if (ca) {
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    ca = true;
                    return 1;
                }
            }

            public boolean doneA() {
                return ca;
            }

            public boolean doneB() {
                return cb;
            }
        }
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
