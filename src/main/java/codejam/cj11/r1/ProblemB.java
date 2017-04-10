package codejam.cj11.r1;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeMap;

public class ProblemB {
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");

    public void solve() {
        // read inputs
        int numOfCases = scanner.nextInt();
        scanner.nextLine(); // skip to next line
        for (int i = 1; i <= numOfCases; i++) {
            int n = scanner.nextInt();  // words in dictionary
            int m = scanner.nextInt(); // number of lists

            // dictionary
            List<String> dictionary = new ArrayList<>();
            TreeMap<Integer, List<String>> dd = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                String d = scanner.next();
                dictionary.add(d);

                int len = d.length();
                dd.put(len, dd.getOrDefault(len, Arrays.asList(d)));
            }

            // find solution
            for (int j = 0; j < m; j++) {
                String l = scanner.next();
                String ret = solve(dd, l);
            }

            // output
            System.out.println("Case #" + i + ": " + "blah");
        }

    }

    private String solve(TreeMap<Integer, List<String>> dictionary, String l) {
        NavigableSet<Integer> wordLens = dictionary.descendingKeySet();
        Iterator<Integer> it = wordLens.iterator();

        return null;
    }

}
