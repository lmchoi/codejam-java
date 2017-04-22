package codejam;

import java.text.ParseException;
import java.util.Scanner;

public class CodeJamMainC {
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

                // dragon
                long hD = in.nextLong();
                long aD = in.nextLong();

                // knight
                long hK = in.nextLong();
                long aK = in.nextLong();

                long b = in.nextLong();
                long d = in.nextLong();

                long ret = play(hD, aD, hK, aK, b, d);
                String solution;
                if (ret == -1) {
                    solution = "IMPOSSIBLE";
                } else {
                    solution = String.valueOf(ret);
                }

                // output
                System.out.println("Case #" + cn + ": " + solution);
            }

        }

        private long play(long hD, long aD, long hK, long aK, long b, long d) {
            long hitsToKillDragon = hitsRequired(hD, aK);
            long hitsToKillKnight = hitsRequired(hK, aD);

            // buff before attacking
            // debuff before getting hit
            // cure to max when about to die

            return -1;
        }

        private long hitsRequired(long health, long attack) {
            return Double.valueOf(Math.ceil(health / attack)).longValue();
        }
    }
}
