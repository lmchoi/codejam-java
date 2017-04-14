package codejam.cj12.r1a;

import java.text.ParseException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ProblemCMain {
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
                LinkedList<Car> cars = new LinkedList<>();
                LinkedList<Car> laneL = new LinkedList<>();
                LinkedList<Car> laneR = new LinkedList<>();
                int n = in.nextInt(); // number of cars
                for (int i = 0; i < n; i++) {
                    String c = in.next(); //lane
                    int s = in.nextInt(); //speed
                    int p = in.nextInt(); //position
                    if ("L".equals(c)) {
                        Car cl = new Car(s, p, true);
                        cars.add(cl);
                        laneL.add(cl);
                    } else {
                        Car cr = new Car(s, p, false);
                        cars.add(cr);
                        laneR.add(cr);
                    }

                    cars.sort(new Comparator<Car>() {
                        @Override
                        public int compare(Car o1, Car o2) {
                            return o1.p - o2.p;
                        }
                    });

                    Iterator<Car> carIt = cars.descendingIterator();
                    Car ahead = null;
                    Car aheadOtherLane = null;
                    while (carIt.hasNext()) {
                        Car car = carIt.next();

                        if (ahead == null) {
                            ahead = car;
                            continue;
                        }

                        // same lane
                        if (car.leftLane != ahead.leftLane) {
                            //moveToSameLane();
                        }

                        // will catch up
                        if (car.s > ahead.s) {
                            // get cars in the other lane
                            // is there space to switch
                            // switch car to other lane
                        } else {
                            ahead = car;
                        }
                    }
                    //
                    //Optional<Double> timeBeforeCollision = Optional.empty();// seconds before collision
                    //
                    //// consider left lane first, and update car for potential collision
                    //
                    //
                    //
                    //if (!cars.isEmpty()) {
                    //    Car behind = carIt.next();
                    //    Car behindInOtherLane = null;
                    //    while (carIt.hasNext()) {
                    //        Car ahead = carIt.next();
                    //
                    //        // same lane
                    //        if (ahead.leftLane == behind.leftLane) {
                    //            doStuff(cars, ahead, behind);
                    //
                    //        } else { // different lane
                    //            if (behindInOtherLane == null) {
                    //                behindInOtherLane = ahead;
                    //            } else {
                    //                doStuff(cars, ahead, behindInOtherLane);
                    //
                    //
                    //            }
                    //        }
                    //    }
                    //}
                }

                String solution = "Possible";
                // output
                System.out.println("Case #" + cn + ": " + solution);
            }

        }
        //
        //private Optional<Double> doStuff(LinkedList<Car> cars, Car ahead, Car behind) {
        //    Optional<Double> timeBeforeCollision = Optional.empty();
        //
        //    // will catch up
        //    if (behind.s > ahead.s) {
        //        timeBeforeCollision = performSwitch(cars, ahead, behind);
        //        if (timeBeforeCollision.isPresent()) {
        //            // switch lane??
        //        } else {
        //            // save time before collision?
        //            // find the minimum if there is another that exist already
        //        }
        //    } else {
        //        // everything is well
        //        behind = ahead;
        //    }
        //    return timeBeforeCollision;
        //}
        //
        //private Optional<Double> performSwitch(LinkedList<Car> cars, Car ahead, Car behind) {
        //    // can we change lane?
        //    int distance = ahead.p - behind.p;
        //    int sd = behind.s - ahead.s;
        //
        //    double timeBeforeCollision = distance / sd;
        //
        //
        //}

        private class Car {
            private final int s;
            private final int p;
            private final boolean leftLane;

            public Car(int s, int p, boolean left) {
                this.s = s;
                this.p = p;
                this.leftLane = left;
            }

            @Override
            public String toString() {
                return "Car{" +
                        "s=" + s +
                        ", p=" + p +
                        '}';
            }
        }


    }
}
