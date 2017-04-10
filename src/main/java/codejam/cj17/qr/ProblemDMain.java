package codejam.cj17.qr;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProblemDMain {
    public static boolean DEBUG = true;
    public static void main (String[] args) throws ParseException {
        ProblemD problem = new ProblemD();
        problem.solve();
    }

    public static class ProblemD {

        Scanner scanner = new Scanner(System.in);
        static int n;
        public void solve() {
            // read inputs
            int numOfCases = scanner.nextInt();
            scanner.nextLine(); // skip to next line
            for (int i = 1; i <= numOfCases; i++) {
                n = scanner.nextInt();
                int m = scanner.nextInt();
                scanner.nextLine(); // skip to next
                LinkedList<Model> models = new LinkedList<>();
                for (int j = 0; j < m; j++) {
                    String model = scanner.next();
                    int r = scanner.nextInt();
                    int c = scanner.nextInt();

                    models.push(new Model(model, r, c));
                }

                if (DEBUG) {
                    System.out.println("input: n = " + n + " " + models.size());
                }
                Solution solution = solveCase(n, models);

                if (DEBUG) {
                    if (n > 1) {
                        int x = 3 * (n - 2) + 4;
                        if (solution.getPoints() != x) {
                            System.out.println("Case #" + i + ": " + solution);
                            System.exit(-1);
                        }
                    }
                }

                // output
                System.out.println("Case #" + i + ": " + solution);
                //if (!DEBUG) {
                    solution.printChanges();
                //}
            }
        }

        private Solution solveCase(int n, LinkedList<Model> models) {
            Show show = new Show(n, models);

            return show.optimise();
        }

        public static class Model {
            private final char type;
            private final int r;
            private final int c;

            public Model(String type, int r, int c) {
                this.type = type.charAt(0);
                this.r = r - 1;
                this.c = c - 1;
            }
        }

        public static class Show {
            private final static Map<Character, Integer> SCORE_CARD = new HashMap<>();

            private final int n;
            private final char[][] grid;

            // solution
            private final int basePoints;
            private final List<Change> changes;

            public Show(int n, LinkedList<Model> models) {
                SCORE_CARD.put('o', 2);
                SCORE_CARD.put('+', 1);
                SCORE_CARD.put('x', 1);
                SCORE_CARD.put('.', 0);

                changes = new ArrayList<>();

                this.n = n;

                this.grid = new char[n][n];

                for (int i = 0; i < n; i++) {
                    Arrays.fill(grid[i], '.');
                }

                models.forEach(this::addToGrid);

                basePoints = calculatePoints();

                if (DEBUG) {
                    //if (models.size() > 50) {
                        System.out.println(this);
                    //}
                }
            }

            public void addToGrid(Model m) {
                grid[m.r][m.c] = m.type;
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        sb.append(grid[i][j]);
                    }

                    sb.append("\n");
                }

                return sb.toString();
            }

            private void updateCell(int r, int c, char type) {
                char previousType = grid[r][c];

                // add or upgrade
                if (previousType == '.' || type == 'o') {
                    if (previousType != type) {
                        grid[r][c] = type;
                        changes.add(new Change(r, c, type));
                    }
                } else {
                    if (previousType != type) {
                        System.out.println("updating: " + r + " " + c + " replacing " + previousType + " with " + type);
                        System.exit(-1);
                    }
                }
            }

            private int calculatePoints() {
                int pts = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        char type = grid[i][j];
                        pts += SCORE_CARD.get(type);
                    }
                }
                return pts;
            }

            public Solution optimise() {
                // TODO implement for large test!!
                int crowdedRow = 0;

                // find x
                int xo = 0;
                for (int i = 1; i < n; i++) {
                    if (grid[crowdedRow][i] == 'x' || grid[crowdedRow][i] == 'o') {
                        xo = i;
                    } else {
                        updateCell(crowdedRow, i, '+');
                    }
                }

                if (xo != 0) {
                    updateCell(crowdedRow, xo, 'o');
                    updateCell(crowdedRow, 0, '+');
                } else {
                    updateCell(crowdedRow, 0, 'o');
                }

                for (int i = 1; i < (n - 1); i++) {
                    int xc = (i + xo) % n;
                    updateCell(i, xc, 'x');
                }

                // bottom row
                if (n > 1) {
                    int br = n - 1;

                    // TODO if xo is at 0, 0
                    if (xo == 0) {
                        for (int i = 1; i < (n - 1); i++) {
                            updateCell(br, i, '+');
                        }

                        updateCell(br, br, 'x');
                    } else {
                        if (n == 2) {
                            updateCell(br, 0, 'x');
                        } else {
                            int xc = (br + xo) % n;
                            boolean addedO = false;
                            for (int i = 1; i < (n - 1); i++) {
                                if (i == xc) {
                                    addedO = true;
                                    updateCell(br, xc, 'o');
                                } else {
                                    updateCell(br, i, '+');
                                }
                            }

                            if (!addedO) {
                                updateCell(br, 0, 'x');
                            }
                        }
                    }
                }

                if (DEBUG) {
                    //if (n < 10) {
                        System.out.println(this);
                    //}
                }

                return new Solution(calculatePoints(), changes);
            }
        }
    }

    public static class Change {
        // 0 ... (n - 1)
        private final int r;
        private final int c;
        private final char type;

        public Change(int r, int c, char type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }

        @Override
        public String toString() {
            return type + " " + (r + 1) + " " + (c + 1);
        }
    }

    public static class Solution {
        private int points;
        private final List<Change> changes;

        public Solution(int totalPoints, List<Change> changes) {
            points = totalPoints;
            this.changes = changes;
        }

        public int getPoints() {
            return points;
        }

        public List<Change> getChanges() {
            return changes;
        }

        public void printChanges() {
            if (DEBUG) {
                if (changes.size() < 20) {
                    changes.forEach(System.out::println);
                }
            } else {
                changes.forEach(System.out::println);
            }
        }

        // two ints, strings etc, careful with chars!
        @Override
        public String toString() {
            return points + " " + changes.size();
        }
    }
}
