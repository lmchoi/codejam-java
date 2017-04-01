package codejam.codejam;

import java.util.Scanner;

public class ProblemA {
    Scanner scanner = new Scanner(System.in);

    public void solve() {
        // read inputs
        int numOfCases = scanner.nextInt();

        for (int i = 1; i <= numOfCases; i++) {
            Case c = parseCase();

            // find solution
            Solution solution = c.solve();

            // output
            System.out.println("Case #" + i + ": " + solution);
        }

    }

    private Case parseCase() {
        return null;
    }
}
