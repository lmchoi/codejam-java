package codejam.cj12.qr;

import java.util.HashMap;
import java.util.Scanner;

//21:50 3 April 2017

public class ProblemA {
    Scanner scanner = new Scanner(System.in);


    public void solve() {
        HashMap<Character, Character> gLookup = createLookup();
        //gLookup.values().stream().sorted().forEach(z -> System.out.println(z));

        // read inputs
        int numOfCases = scanner.nextInt();
        scanner.nextLine(); // skip to next line
        for (int i = 1; i <= numOfCases; i++) {

            // --- Parsing
            // read space separated lines
            String line = scanner.nextLine();

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < line.length(); j++) {
                sb.append(gLookup.get(line.charAt(j)));
            }

            // output
            System.out.println("Case #" + i + ": " + sb.toString());
        }

    }

    private HashMap<Character, Character> createLookup() {
        HashMap<Character, Character> gLookup = new HashMap<>();
        gLookup.put('y', 'a');
        gLookup.put('e', 'o');
        gLookup.put('q', 'z');
        gLookup.put('z', 'q');
        gLookup.put(' ', ' ');

        // training data
        String[] gWords = null;
        String gw = "ejp mysljylc kd kxveddknmc re jsicpdrysi " +
                "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd " +
                "de kr kd eoya kw aej tysr re ujdr lkgc jv";
        gWords = gw.split("\\s+");

        // read space separated lines
        String ew = "our language is impossible to understand " +
                "there are twenty six factorial possibilities " +
                "so it is okay if you want to just give up ";
        String[] eWords = ew.split("\\s+");

        for (int j = 0; j < eWords.length; j++) {
            String g = gWords[j];
            String e = eWords[j];
            for (int k = 0; k < g.length(); k++) {
                for (int l = 0; l < g.length(); l++) {
                    gLookup.put(g.charAt(l), e.charAt(l));
                }
            }
        }

        return gLookup;
    }

}
