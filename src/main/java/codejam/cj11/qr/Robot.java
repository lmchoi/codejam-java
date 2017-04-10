package codejam.cj11.qr;

public class Robot {
    int pos = 1;
    int movement = 0;

    public void update(int timeTaken) {
        movement += timeTaken;
    }

    // returns time taken
    public int pushButton(int buttonPos) {
        int distance = Math.abs(buttonPos - pos) - movement;
        movement = 0;
        pos = buttonPos;

        if (distance < 0) {
            distance = 0;
        }

        return distance + 1;
    }
}
