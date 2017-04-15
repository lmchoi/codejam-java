package codejam.cj17.r1a;

import java.text.ParseException;
import java.util.Scanner;

public class CodeJamMainA {
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
                int r = in.nextInt();
                int c = in.nextInt();

                char[][] cake = new char[r][c];
                for (int i = 0; i < r; i++) {
                    String row = in.next();
                    cake[i] = row.toCharArray();

                    int qs = -1;
                    char name = '?';
                    for (int j = 0; j < c; j++) {
                        if (cake[i][j] == '?') {
                            if (name == '?') {
                                if (qs == -1) {
                                    qs = j;
                                }
                            } else {
                                cake[i][j] = name;
                            }
                        } else {
                            if (qs != -1) {
                                for (int k = qs; k < j; k++) {
                                    cake[i][k] = cake[i][j];
                                }
                                qs = -1;
                            }

                            name = cake[i][j];
                        }
                    }
                }


                for (int j = 0; j < c; j++) {
                    int qs = -1;
                    char name = '?';
                    for (int i = 0; i < r; i++) {
                        if (cake[i][j] == '?') {
                            if (name == '?') {
                                if (qs == -1) {
                                    qs = i;
                                }
                            } else {
                                cake[i][j] = name;
                            }
                        } else {
                            if (qs != -1) {
                                for (int k = qs; k < i; k++) {
                                    cake[k][j] = cake[i][j];
                                }
                                qs = -1;
                            }

                            name = cake[i][j];
                        }
                    }
                }

                // output
                System.out.println("Case #" + cn + ":");
                printMatrix(cake);
            }

        }

        public void printMatrix(char[][] board) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < board.length; i++) {
                int c = board[i].length;
                for (int j = 0; j < c; j++) {
                    sb.append(board[i][j]);
                }

                sb.append("\n");
            }

            System.out.print(sb.toString());
        }
    }
}
