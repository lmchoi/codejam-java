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
                String row = in.next();
                char[] rowAbove = row.toCharArray();

                char pc = rowAbove[0];

                for (int i = 1; i < c; i++) {
                    char cp = rowAbove[i];
                    if (pc == '?') {
                        if (cp != pc) {
                            rowAbove[i - 1] = cp;
                        }
                    } else {
                        if (cp == '?') {
                            rowAbove[i] = pc;
                        }
                    }

                    pc = rowAbove[i];
                }

                cake[0] = rowAbove;

                for (int i = 1; i < r; i++) {
                    row = in.next();
                    cake[i] = row.toCharArray();

                    char previousPiece = cake[i][0];

                    for (int j = 1; j < c; j++) {
                        char cPiece = cake[i][j];

                        if (previousPiece == '?') {
                            if (cPiece != previousPiece) {
                                for (int k = j - 1; k > -1; k--) {
                                    if (cake[i][k] == '?' &&
                                            rowAbove[k] != cPiece) {
                                        cake[i][k] = cPiece;
                                    } else {
                                        break;
                                    }
                                }
                            }
                        } else {
                            if (cPiece == '?') {
                                cPiece = previousPiece;
                            }
                        }

                        cake[i][j] = cPiece;

                        previousPiece = cPiece;
                    }

                    for (int j = 0; j < c; j++) {
                        if (rowAbove[j] == '?') {
                            for (int k = i - 1; k > -1; k--) {
                                if (cake[k][j] == '?') {
                                    cake[k][j] = cake[i][j];
                                } else {
                                    break;
                                }
                            }
                        } else {
                            if (cake[i][j] == '?') {
                                cake[i][j] = cake[i - 1][j];
                            }
                        }
                    }

                    rowAbove = cake[i];
                }

                // output
                System.out.print("Case #" + cn + ":");
                printMatrix(cake);
            }
        }

        public void printMatrix(char[][] board) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < board.length; i++) {
                sb.append("\n");

                for (int j = 0; j < board[i].length; j++) {
                    sb.append(board[i][j]);
                }

            }

            System.out.println(sb.toString());
        }
    }
}
