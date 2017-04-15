package codejam;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.util.Scanner;

public class CodeJamMainTemplate {
    public static boolean DEBUG = true;
    public static void main (String[] args) throws ParseException {
        Problem problem = new Problem();
        problem.solve();
    }

    public static class Problem {
        Scanner in = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");

        public void solve() {
            // read inputs
            int numOfCases = in.nextInt();
            in.nextLine(); // skip to next line
            for (int cn = 1; cn <= numOfCases; cn++) {

                // find solution
                Solution solution = null;

                // output
                System.out.println("Case #" + cn + ": " + solution);
            }

        }

        //convert 123 to [1, 2, 3]
        private int[] toIntArray(String numStr) {
            return String.valueOf(numStr).chars().map(c -> c -= '0').toArray();
        }

        // read space separated lines
        private String[] readStringArray() {
            String line = in.nextLine();
            return line.split("\\s+");
        }

        private DateTime readDate() {
            String timeString = in.next();
            return formatter.parseDateTime(timeString);
        }

        private char[][] rotateMatrix90(char[][] board) {
            int n = board.length;
            char[][] boardR = new char[n][n];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    boardR[n - y - 1][x] = board[n - x - 1][n - y - 1];
                }
            }

            return boardR;
        }

        public void printMatrix(char[][] board) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    sb.append(board[i][j]);
                }

                sb.append("\n");
            }

            System.out.println(sb.toString());
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

    //// Create a simple weighted directed graph with Hipster where
    //// vertices are Strings and edge values are just doubles
    //HipsterDirectedGraph<String,Double> graph =
    //        GraphBuilder.<String,Double>create()
    //                .connect("A").to("B").withEdge(4d)
    //                .connect("A").to("C").withEdge(2d)
    //                .connect("B").to("C").withEdge(5d)
    //                .connect("B").to("D").withEdge(10d)
    //                .connect("C").to("E").withEdge(3d)
    //                .connect("D").to("F").withEdge(11d)
    //                .connect("E").to("D").withEdge(4d)
    //                .createDirectedGraph();
    //
    //// Create the search problem. For graph problems, just use
    //// the GraphSearchProblem util class to generate the problem with ease.
    //SearchProblem p = GraphSearchProblem
    //        .startingFrom("A")
    //        .in(graph)
    //        .takeCostsFromEdges()
    //        .build();
    //
    //// Search the shortest path from "A" to "F"
    //Algorithm.SearchResult ret = Hipster.createDijkstra(p).search("F");
    //System.out.println(ret.getOptimalPaths());
}
