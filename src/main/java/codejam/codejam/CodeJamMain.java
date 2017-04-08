package codejam.codejam;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CodeJamMain {
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

                System.out.println("input: n = " + n);
                Solution solution = solveCase(n, models);

                // output
                System.out.println("Case #" + i + ": " + solution);
                solution.printChanges();
            }

        }

        private Solution solveCase(int n, LinkedList<Model> models) {
            Show show = new Show(n, models);
            System.out.println(show);
            return show.optimise();
        }

        public static class Model {
            private final String type;
            private final int index;

            public Model(String type, int r, int c) {
                this.type = type;
                this.index = (r - 1) * n  + (c - 1);
            }

            public int getIndex() {
                return index;
            }

            public String getType() {
                return type;
            }
        }

        public static class Show {
            private final int n;
            private final BitSet gridO;
            private final BitSet gridT;
            private final BitSet gridX;
            private final char[][] grid;
            private final BitSet rowChecker;
            private final BitSet colChecker;

            // solution
            private int totalPoints;
            private final List<Change> changes;

            public Show(int n, LinkedList<Model> models) {
                this.n = n;
                changes = new ArrayList<>();
                this.gridO = new BitSet(n * n);
                this.gridT = new BitSet(n * n);
                this.gridX = new BitSet(n * n);
                this.grid = new char[n][n];
                rowChecker = new BitSet(n);
                colChecker = new BitSet(n);

                for (int i = 0; i < n; i++) {
                    Arrays.fill(grid[i], '.');
                    colChecker.set(n * i);
                }

                rowChecker.set(0, rowChecker.length());

                models.forEach(this::addToGrid);

                totalPoints = calculatePoints();
            }

            public void addToGrid(Model m) {
                int index = m.getIndex();
                int r = Math.floorDiv(index, n);
                int c = index % n;
                System.out.println("index : " + index + " -> " + r + " " + c + " ");

                char t = m.getType().charAt(0);
                switch (t) {
                    case 'o':
                        gridO.set(index);
                        break;
                    case '+':
                        gridT.set(index);
                        break;
                    case 'x':
                        gridX.set(index);
                        break;
                }

                grid[r][c] = t;
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

            public Solution optimise() {
                if (n == 1) {
                    int index = 0;
                    char c = getCell(index);

                    switch (c) {
                        case 'o' :
                            // do nothing
                            break;

                        case '+':
                            // check the following:
                            totalPoints++;
                            updateCell(index, 'o');
                            break;

                        case 'x':
                            // check the following:
                            totalPoints++;
                            updateCell(index, 'o');
                            break;

                        case '.':
                            totalPoints += 2;
                            updateCell(index, 'o');
                            // check the following:
                            // no other +/o in the diagonals
                            // no other x/o in the row/column
                            break;
                    }
                }

                // TODO for n > 1

                return new Solution(totalPoints, changes);
            }

            private void updateCell(int index, char type) {
                int r = Math.floorDiv(index, n);
                int c = index % n;
                grid[r][c] = type;
                changes.add(new Change(r, c, type));
            }

            private char getCell(int index) {
                int r = Math.floorDiv(index, n);
                int c = index % n;
                return grid[r][c];
            }

            private int calculatePoints() {
                return (gridO.cardinality() * 2) + gridT.cardinality() + gridX.cardinality();
            }
        }
    }

    public static class Change {

        private final int r;
        private final int c;
        private final char type;

        public Change(int r, int c, char type) {

            this.r = r;
            this.c = c;
            this.type = type;
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

        public void printChanges() {
            for (Change c : changes) {
                System.out.println(c.type + " " + c.r + " " + c.c);
            }
        }

        // two ints, strings etc, careful with chars!
        @Override
        public String toString() {
            return points + " " + changes.size();
        }
    }
}
