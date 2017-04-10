package codejam.cj11.qr;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ProblemD {
    Scanner scanner = new Scanner(System.in);

    public void solve() {
        // read inputs
        int numOfCases = scanner.nextInt();

        for (int i = 1; i <= numOfCases; i++) {
            int result = solveCase();

            // output
            System.out.println("Case #" + i + ": " + result);
        }

    }

    private int solveCase() {
        Integer n = scanner.nextInt();

        Robot o = new Robot();
        Robot b = new Robot();
        LinkedList<Instruction> instructions = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String robot = scanner.next();
            int button = scanner.nextInt();
            Instruction instruction = new Instruction(robot, button);
            instructions.add(instruction);
        }

        Iterator<Instruction> nextInstruction = instructions.iterator();
        int ret = 0;

        while (nextInstruction.hasNext()) {
            Instruction instruction = nextInstruction.next();
            int position = instruction.getPosition();

            int timeTaken;
            if (instruction.getRobot().equals("O")) {
                timeTaken = o.pushButton(position);
                b.update(timeTaken);
            } else {
                timeTaken = b.pushButton(position);
                o.update(timeTaken);
            }

            ret += timeTaken;
        }

        return ret;
    }
}
