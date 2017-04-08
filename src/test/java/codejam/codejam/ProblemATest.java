package codejam.codejam;

import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProblemATest {

    @Test
    public void testAcross() throws Exception {
        CodeJamMain.ProblemA problemA = new CodeJamMain.ProblemA();
        assertTrue(problemA.chooseLeft(1, 1, BigInteger.ZERO));
        assertTrue(problemA.chooseLeft(1, 2, BigInteger.ONE));
        assertTrue(problemA.chooseLeft(3, 1, new BigInteger("3")));
        assertTrue(problemA.chooseLeft(3, 2, new BigInteger("3")));
        assertFalse(problemA.chooseLeft(3, 3, new BigInteger("3")));
    }

}