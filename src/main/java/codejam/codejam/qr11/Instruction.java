package codejam.codejam.qr11;

public class Instruction {
    private final String robot;
    private final int position;

    public Instruction(String robot, int position) {
        this.robot = robot;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getRobot() {
        return robot;
    }
}
