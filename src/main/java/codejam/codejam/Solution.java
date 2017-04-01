package codejam.codejam;

public class Solution {
    private final boolean r;

    public Solution(boolean r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return r ? "ON" : "OFF";
    }

    // two ints, strings etc, careful with chars!
    //@Override
    //public String toString() {
    //    return a + " " + b;
    //}


    // char array
    //@Override
    //public String toString() {
    //    return String.valueOf(arr).replace("", " ").trim();
    //}
}
