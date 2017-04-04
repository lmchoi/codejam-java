package codejam.codejam.cj12.qra;

import java.util.Scanner;

// 22:27 skip to D
public class ProblemC {
    Scanner scanner = new Scanner(System.in);

    public void solve() {
        // read inputs
        int numOfCases = scanner.nextInt();
        scanner.nextLine(); // skip to next line
        for (int i = 1; i <= numOfCases; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // how many recycled pairs are there between A and B

            // find solution
            int solution = solveCase(a, b);

            // output
            System.out.println("Case #" + i + ": " + solution);
        }

    }

    private int solveCase(int a, int b) {
        int ret = 0;

        int[] A = String.valueOf(a).chars().map(c -> c -= '0').toArray();
        int[] B = String.valueOf(b).chars().map(c -> c -= '0').toArray();

        for (int i = 0; i < A.length; i++) {


        }



        return ret;
    }

}
