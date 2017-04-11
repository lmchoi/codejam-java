package codejam.cj10.r1;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemAMain {
    public static boolean DEBUG = true;
    public static void main (String[] args) throws ParseException {
        Problem problem = new Problem();
        problem.solve();
    }

    public static class Problem {
        Scanner scanner = new Scanner(System.in);

        public void solve() {
            // read inputs
            int numOfCases = scanner.nextInt();
            scanner.nextLine(); // skip to next line

            for (int i = 1; i <= numOfCases; i++) {

                int n = scanner.nextInt();
                int k = scanner.nextInt();
                scanner.nextLine();

                char[][] board = new char[n][n];
                for (int j = 0; j < n; j++) {
                    String s = scanner.nextLine();

                    // gravity!
                    Arrays.fill(board[j], '.');
                    char[] gs = s.replace(".", "").toCharArray();
                    System.arraycopy(gs, 0, board[j], (n - gs.length), gs.length);
                }

                char[][] boardR = new char[n][n];
                for (int y = 0; y < n; y++) {
                    for (int x = 0; x < n; x++) {
                        boardR[n - y - 1][x] = board[n - x - 1][n - y - 1];
                    }
                }

                System.out.println(print(boardR));

                // find solution
                Solution solution = solveCase(k, boardR);

                // output
                System.out.println("Case #" + i + ": " + solution);
            }

        }

        private Solution solveCase(int k, char[][] board) {
            // check horizontal

            boolean wr = false, wb = false;
            for (int i = 0; i < board.length; i++) {
                int r = 0, b = 0;
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 'R') {
                        r++;
                        b = 0;

                        if (r == k) {
                            wr = true;
                        }
                    } else if (board[i][j] == 'B') {
                        b++;
                        r = 0;

                        if (b == k) {
                            wb = true;
                        }
                    } else {
                        b = 0;
                        r = 0;
                    }
                }
            }

            for (int j = 0; j < board.length; j++) {
                int r = 0, b = 0;
                for (int i = 0; i < board.length; i++) {
                    if (board[i][j] == 'R') {
                        r++;
                        b = 0;

                        if (r == k) {
                            wr = true;
                        }
                    } else if (board[i][j] == 'B') {
                        b++;
                        r = 0;

                        if (b == k) {
                            wb = true;
                        }
                    } else {
                        b = 0;
                        r = 0;
                    }
                }
            }

            //for (int j = 0; j < board.length; j++) {
            //    int r = 0, b = 0;
            //    for (int i = 0; i < board.length; i++) {
            //        if (board[i][i+1] == 'R') {
            //            r++;
            //            b = 0;
            //
            //            if (r == k) {
            //                wr = true;
            //            }
            //        } else if (board[i][j] == 'B') {
            //            b++;
            //            r = 0;
            //
            //            if (b == k) {
            //                wb = true;
            //            }
            //        } else {
            //            b = 0;
            //            r = 0;
            //        }
            //    }
            //}
            return new Solution(wr, wb);
        }

        public String print(char[][] board) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    sb.append(board[i][j]);
                }

                sb.append("\n");
            }

            return sb.toString();
        }

    }

    public static class Solution {
        private final boolean wr;
        private final boolean wb;

        public Solution(boolean wr, boolean wb) {
            this.wr = wr;
            this.wb = wb;
        }

        @Override
        public String toString() {
            if (wr && wb) {
                return "Both";
            } else if (wr) {
                return "Red";
            } else if (wb) {
                return "Blue";
            } else {
                return "Neither";
            }
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
