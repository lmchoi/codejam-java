package codejam.cj17.r1b;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CodeJamMainB {
    public static boolean DEBUG = true;
    public static void main (String[] args) throws ParseException {
        Problem problem = new Problem();
        problem.solve();
    }

    public static class Problem {
        Scanner in = new Scanner(System.in);

        public static final int R = 0;
        public static final int O = 1;
        public static final int Y = 2;
        public static final int G = 3;
        public static final int B = 4;
        public static final int V = 5;
        public static final String IMPOSSIBLE = "IMPOSSIBLE";

        public void solve() {
            // read inputs
            int numOfCases = in.nextInt();
            in.nextLine(); // skip to next line
            for (int cn = 1; cn <= numOfCases; cn++) {

                // output
                String solution = solveCase();
                System.out.println("Case #" + cn + ": " + solution);
            }
        }

        private String solveCase() {

            // RYB
            int n = in.nextInt();

            String colours[] = {"R", "O", "Y", "G", "B", "V"};
            //6 2 0 1 1 2 0

            HorseType[] horseTypes = new HorseType[6];

            for (int i = 0; i < 6; i++) {
                int count = in.nextInt();
                horseTypes[i] = new HorseType(colours[i], count);
            }

            try {
                horseTypes[0].update(n, horseTypes[3]);
                horseTypes[2].update(n, horseTypes[5]);
                horseTypes[4].update(n, horseTypes[1]);
            } catch (Exception e) {
                return IMPOSSIBLE;
            }

            horseTypes[1].count = 0;
            horseTypes[3].count = 0;
            horseTypes[5].count = 0;

            Arrays.sort(horseTypes, new Comparator<HorseType>() {
                @Override
                public int compare(HorseType o1, HorseType o2) {
                    return o2.count - o1.count;
                }
            });

            int nn = Arrays.stream(horseTypes).mapToInt(h -> h.count).sum();

            if (horseTypes[0].count * 2 > nn && horseTypes[0].count != 1) {
                return IMPOSSIBLE;
            }

            char[] stalls = new char[nn];
            int s = 0;

            for (int i = 0; i < 6; i++) {
                HorseType h = horseTypes[i];
                while (h.count > 0) {
                    while (stalls[s] != '\0') {
                        s++;
                        s %= nn;
                    }

                    stalls[s] = h.colour.charAt(0);
                    s += 2;
                    s %= nn;
                    h.count--;
                }
            }

            String ret = new String(stalls);
            for (int i = 0; i < 6; i++) {
                HorseType h = horseTypes[i];
                ret = ret.replaceFirst(h.colour, h.combo);
            }

            return ret;
        }

        private class HorseType {
            private final String colour;
            private int count;
            private String combo;

            public HorseType(String colour, int count) {
                this.colour = colour;
                this.count = count;
                this.combo = colour;
            }

            public void update(int totalNumberOfHorses, HorseType archType) throws Exception {
                if (archType.count > 0) {
                    if (totalNumberOfHorses == (archType.count + this.count)) {
                        int remaining = this.count - archType.count;
                        if (remaining != 0) {
                            throw new Exception("IMPOSSIBLE");
                        }
                        combo = createCombo(archType);
                        count = 1;

                    } else {
                        int remaining = this.count - archType.count;
                        if (remaining < 1) {
                            throw new Exception("IMPOSSIBLE");
                        }

                        combo = createCombo(archType).concat(colour);

                        count = remaining;
                    }
                }
            }

            private String createCombo(HorseType archType) {
                return String.join("", Collections.nCopies(archType.count, colour.concat(archType.colour)));
            }

            @Override
            public String toString() {
                return "HorseType{" +
                        "colour='" + colour + '\'' +
                        ", count=" + count +
                        ", combo='" + combo + '\'' +
                        '}';
            }
        }
    }
}
