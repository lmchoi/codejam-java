package codejam;

import java.text.ParseException;
import java.util.Scanner;

public class CodeJamMainB {
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

                // RYB
                int n = in.nextInt();

                //TreeMap<String, Integer> horses = new TreeMap<>();
                int[] horses = new int[6];
                for (int i = 0; i < 6; i++) {
                    //int r = in.nextInt();
                    //int o = in.nextInt();
                    //int y = in.nextInt();
                    //int g = in.nextInt();
                    //int b = in.nextInt();
                    //int v = in.nextInt();
                    //
                    //horses.put("R", r);
                    //int antiR = y + g + b + v;
                    //
                    //horses.put("O", o);
                    //int antiO = v + g + b + v;
                    //
                    //horses.put("Y", y);
                    //int antiY = v + r + b + v;
                    //
                    //horses.put("G", g);
                    //int antiG = v + r + y + v;
                    //
                    //horses.put("B", b);
                    //int antiB = v + r + o + y;
                    //
                    //horses.put("V", v);
                    //int antiV = o + y + g + b;

                    horses[i] = in.nextInt();
                }

                String colours[] = {"R", "O", "Y", "G", "B", "V"};

                String solution = null;
                StringBuilder ring = new StringBuilder();
                int i = 0;
                int currentColour = -1;
                while (n != 0) {

                    if (horses[i] == 0) {
                        i = nextColour(currentColour, i);

                        if (i == -1) {
                            solution = "IMPOSSIBLE";
                            break;
                        }
                    } else {
                        

                        currentColour = i;
                        ring.append(colours[i]);
                        horses[i] -= 1;
                        i = i + 2;
                        i = i % 6;
                        n--;
                    }
                }

                if (n == 0) {
                    solution = ring.toString();
                    int len = solution.length();
                    String s = String.valueOf(solution.charAt(0));
                    String e = String.valueOf(solution.charAt(len - 1));

                    int si = -1;
                    int ei = -1;

                    for (int j = 0; j < colours.length; j++) {
                        if (colours[j].equals(s)) {
                            si = j;
                        }

                        if (colours[j].equals(e)) {
                            ei = j;
                        }
                    }

                    if (badCombo(si, ei)) {
                        solution = "IMPOSSIBLE";
                    }

                }

                // output
                System.out.println("Case #" + cn + ": " + solution);
            }


        }

        private int nextColour(int currentColour, int i) {
            i++;
            i = i % 6;

            if (currentColour == -1) {
                return i;
            }

            if (currentColour == 0) {
                if (i == 5) {
                    return -1;
                }
            } else {
                int before = currentColour - 1;

                if (i == before) {
                    return -1;
                }
            }

            return i;
        }

        private boolean badCombo(int si, int ei) {
            int before = si - 1;
            int after = si + 1;

            if (si == 0) {
                before = 5;

            } else if (si == 5) {
                after = 0;
            }

            return (ei == before || ei == after || ei == si);
        }
    }
}
