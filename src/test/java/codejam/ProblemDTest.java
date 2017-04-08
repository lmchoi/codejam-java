package codejam;

import codejam.codejam.CodeJamMain;
import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProblemDTest {
    @Test
    public void testBlank1() throws Exception {
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(1, new LinkedList<>());
        CodeJamMain.Solution solution = show.optimiseTopRowOnly();
        assertThat(solution.getPoints(), is(2));
        assertThat(solution.getChanges().size(), is(1));
    }

    @Test
    public void testT1() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 1));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(1, models);
        CodeJamMain.Solution solution = show.optimiseTopRowOnly();
        assertThat(solution.getPoints(), is(2));
        assertThat(solution.getChanges().size(), is(1));
    }

    @Test
    public void testX1() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("x", 1, 1));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(1, models);
        CodeJamMain.Solution solution = show.optimiseTopRowOnly();
        assertThat(solution.getPoints(), is(2));
        assertThat(solution.getChanges().size(), is(1));
    }

    @Test
    public void testBlank2() throws Exception {
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(2, new LinkedList<>());
        CodeJamMain.Solution solution = show.optimiseTopRowOnly();
        assertThat(solution.getPoints(), is(4));
        assertThat(solution.getChanges().size(), is(2));
    }
}