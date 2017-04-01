package codejam.codejam;

import java.math.BigInteger;

public class Case {
    private final Integer n;
    private final BigInteger k;

    public Case(Integer n, BigInteger k) {
        this.n = n;
        this.k = k;
    }

    public Solution solve() {
        return new Solution(((k.add(BigInteger.ONE)).mod(BigInteger.valueOf(2).pow(n))).equals(BigInteger.ZERO));
    }

    // sorts list
    //void sort(List<Trip> l) {
    //    l.sort((t, o) -> {
    //        int res = t.getDeparture().compareTo(o.getDeparture());
    //        if (res == 0) {
    //            res = t.getArrival().compareTo(o.getArrival());
    //        }
    //        return res;
    //    });
    //}
}
