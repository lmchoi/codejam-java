package codejam;

import java.text.ParseException;
import java.util.Scanner;

public class CodeJamMainTemplateBasic {
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

                // output
                int ret = 0;
                System.out.println("Case #" + cn + ": " + ret);
            }

        }
    }
}
