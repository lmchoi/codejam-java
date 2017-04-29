package codejam.cj16.r1c;

import java.text.ParseException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

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
                int n = in.nextInt();
                TreeSet<Party> parties = new TreeSet<>(new Comparator<Party>() {
                    @Override
                    public int compare(Party o1, Party o2) {

                        int d = o2.count - o1.count;
                        if (d == 0) {
                            return o1.name - o2.name;
                        }
                        return d;
                    }
                });

                char name = 'A';
                int total = 0;
                for (int i = 0; i < n; i++) {
                    int p = in.nextInt();
                    parties.add(new Party(name, p));
                    name++;
                    total += p;
                }

                StringBuilder plan = new StringBuilder();
                while (total != 0) {
                    Party p1 = parties.first();
                    parties.remove(p1);

                    Party p2 = parties.first();

                    if (p1 == p2) {
                        parties.remove(p2);

                        plan.append(p1.name);
                        p1.count--;
                        total--;
                        parties.add(p1);

                        plan.append(p2.name);
                        p2.count--;
                        total--;
                        parties.add(p2);
                    } else {
                        plan.append(p1.name);
                        p1.count--;
                        total--;

                        parties.add(p1);
                    }
                }

                // output

                String s = plan.reverse().toString().replaceAll("..", "$0 ");
                String ret = new StringBuilder(s).reverse().toString().trim();
                System.out.println("Case #" + cn + ": " + ret);
            }

        }

        private class Party {
            private final char name;
            private int count;

            public Party(char name, int p) {
                this.name = name;
                this.count = p;
            }

            @Override
            public String toString() {
                return "Party{" +
                        "name=" + name +
                        ", p=" + count +
                        '}';
            }

            @Override
            public int hashCode() {
                int result = (int) name;
                result = 31 * result + count;
                return result;
            }
        }
    }
}
