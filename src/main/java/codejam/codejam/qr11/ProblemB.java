package codejam.codejam.qr11;

import java.util.Scanner;

public class ProblemB {
    Scanner scanner = new Scanner(System.in);

    public void solve() {
        // read inputs
        int numOfCases = scanner.nextInt();

        for (int i = 1; i <= numOfCases; i++) {
            ElementList result = solveCase();

            // output
            System.out.println("Case #" + i + ": " + result);
        }

    }

    private ElementList solveCase() {
        ElementList elementList = new ElementList();

        int c = scanner.nextInt();
        for (int i = 0; i < c; i++) {
            // 3 letters
            String combo = scanner.next();
            elementList.addCombo(combo);
        }

        int d = scanner.nextInt();
        for (int i = 0; i < d; i++) {
            // 2 letters
            String opposed = scanner.next();
            elementList.addOpposed(opposed);
        }

        int n = scanner.nextInt();
        String invokeList = scanner.next();

        invokeList.chars().forEach(elementList::invoke);

        return elementList;
    }
}
