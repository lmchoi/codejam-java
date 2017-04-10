package codejam.cj09.qr;

import java.util.Scanner;

public class ProblemA1 {
    Scanner scanner = new Scanner(System.in);

    //North, West, East, South
    //DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");

    public void solve() {
        int numOfCases = scanner.nextInt();

        for (int i = 1; i <= numOfCases; i++) {
            int h = scanner.nextInt();
            int w = scanner.nextInt();

            int[][] altitudes = new int[h][w];
            char[][] map = new char[h][w];

            char basin = '-';

            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    altitudes[j][k] = scanner.nextInt();
                    map[j][k] = basin;
                }
            }

            int[][] climbW = new int[h][w-1];
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < (w - 1); k++) {
                    climbW[j][k] = altitudes[j][k+1] - altitudes[j][k];
                    System.out.print(climbW[j][k]);
                    System.out.print(" ");
                }
                System.out.println();
            }

            int[][] climbS = new int[h-1][w];
            for (int j = 0; j < (h-1); j++) {
                for (int k = 0; k < w; k++) {
                    climbS[j][k] = altitudes[j+1][k] - altitudes[j][k];
                    System.out.print(climbS[j][k]);
                    System.out.print(" ");
                }
                System.out.println();
            }

            int x = 0;
            int y = 0;
            basin = 'a';
            map[x][y] = basin;

            if (climbS.length > 1) { // more than one level

                if (x > 0) {

                }


                if (climbS[x][y] < 0 &&
                        (climbS[x][y] < climbW[x][y])) {
                    map[x+1][y] = basin;
                }

            } else if (climbW.length > 1) {

                if (climbW[x][y] < 0) {
                    map[x][y+1] = basin;
                }
            }


            //
            //for (int j = x; j < h; j++) {
            //    for (int k = y; k < w; k++) {
            //        // consider top row,
            //
            //    }
            //
            //}
            // flows to right
            //  value j, k+1 is lower than:
            // j-1, k (n)
            // j, k-1 (w)
            // j+1, k (s)

            // flows to bottom
            //  value j+1, k is lower than:
            // j-1, k (n)
            // j, k-1 (w)
            // j+1, k (s)

            // flows from left
            // flows to right


            System.out.println("Case #" + i + ":");
            for (int j = 0; j < h; j++) {
                System.out.println(String.valueOf(map[j]).replace("", " ").trim());
                //System.out.println(climbW[j]).replace("", " ").trim());
            }
        }
    }
}
