package codejam.codejam.cj12.qra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//22:23
//skip to C
// return at 22:47
// back again! 19:42 next day
// stop at 21:05
public class ProblemB {
    Scanner scanner = new Scanner(System.in);

    public void solve() {
        // read inputs
        int numOfCases = scanner.nextInt();
        scanner.nextLine(); // skip to next line
        for (int i = 1; i <= numOfCases; i++) {

            // --- Parsing
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int p = scanner.nextInt();

            ArrayList<Integer> tp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                tp.add(scanner.nextInt());
            }

            Collections.sort(tp, Collections.reverseOrder());

            int ret = solveCase(s, p, tp);
            
            // output
            System.out.println("Case #" + i + ": " + ret);
        }

    }

    private int solveCase(int s, int p, ArrayList<Integer> tp) {
        int ret = 0;
        return ret;
    }
}
