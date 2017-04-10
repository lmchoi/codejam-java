package codejam.cj11.qr;

import java.util.stream.IntStream;

public class Combo {
    private String key;
    private int result;

    public Combo(IntStream c) {
        int a, b;
        int[] combo = c.toArray();
        if (combo[0] > combo[1]) {
            a = combo[1];
            b = combo[0];
        } else {
            a = combo[0];
            b = combo[1];
        }

        key = String.format("%c%c", a, b);
        result = combo[2];
    }

    public int getResult() {
        return result;
    }

    public String getKey() {
        return key;
    }
}
