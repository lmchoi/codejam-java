package codejam.codejam.qr11;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ElementList {
    List<Integer> ret = new LinkedList<>();
    Map<String, Integer> combos = new HashMap<>();
    Map<Integer, Set<Integer>> opposites = new HashMap<>();

    public void addCombo(String combo) {
        IntStream c = combo.chars();
        Combo cc = new Combo(c);
        combos.put(cc.getKey(), cc.getResult());
    }

    public void addOpposed(String opposed) {
        int[] ops = opposed.chars().toArray();

        int a = ops[0];
        int b = ops[1];

        Set<Integer> av = opposites.getOrDefault(a, new HashSet<>());
        av.add(b);
        opposites.put(a, av);

        Set<Integer> bv = opposites.getOrDefault(b, new HashSet<>());
        bv.add(a);
        opposites.put(b, bv);
    }

    public void invoke(int e) {
        if (ret.isEmpty()) {
            ret.add(e);
            return;
        }

        int index = ret.size() - 1;
        int lastElement = ret.get(index);

        int a = lastElement;
        int b = e;

        if (lastElement > e) {
            a = e;
            b = lastElement;
        }

        String k = String.format("%c%c", a, b);
        Optional<Integer> r = getCombo(k);
        if (r.isPresent()) {
            ret.remove(index);
            invoke(r.get());
            return;
        } else if (opposites.containsKey(e)) {
            if (!Collections.disjoint(opposites.get(e), ret)) {
                ret.clear();
                return;
            }
        }

        ret.add(e);
    }

    private Optional<Integer> getCombo(String k) {
        if (combos.containsKey(k)) {
            return Optional.of(combos.get(k));
        } else {
            return Optional.empty();
        }
    }

    // char array
    @Override
    public String toString() {
        return String.valueOf(ret.stream().map(i -> (char)i.intValue()).collect(Collectors.toList()));
    }
}
