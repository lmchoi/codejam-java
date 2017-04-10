package codejam;

import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProblemDTest {
    @Test
    public void testBlank1() throws Exception {
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(1, new LinkedList<>());
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(2));
        assertThat(solution.getChanges().size(), is(1));
    }

    @Test
    public void testT1() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 1));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(1, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(2));
        assertThat(solution.getChanges().size(), is(1));
    }

    @Test
    public void testX1() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("x", 1, 1));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(1, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(2));
        assertThat(solution.getChanges().size(), is(1));
    }

    @Test
    public void testBlank2() throws Exception {
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(2, new LinkedList<>());
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(4));
        assertThat(solution.getChanges().size(), is(3));
    }

    @Test
    public void testWithModelX() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("x", 1, 1));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(2, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(4));
        assertThat(solution.getChanges().size(), is(3));
        System.out.println(solution.getChanges());
    }

    @Test
    public void testWithModelO() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("o", 1, 1));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(2, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(4));
        assertThat(solution.getChanges().size(), is(2));
    }

    @Test
    public void testWithModelOr() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("o", 1, 2));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(2, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(4));
        assertThat(solution.getChanges().size(), is(2));
    }

    @Test
    public void testWithModels2() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("o", 1, 1));
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 2));
        models.add(new CodeJamMain.ProblemD.Model("x", 2, 2));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(2, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(4));
        assertThat(solution.getChanges().size(), is(0));
    }

    @Test
    public void testWithModelsAddO() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 1));
        models.add(new CodeJamMain.ProblemD.Model("x", 1, 2));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(2, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(4));
        assertThat(solution.getChanges().size(), is(2));
    }

    @Test
    public void testWithModelsAddOb() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("x", 1, 1));
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 2));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(2, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(4));
        assertThat(solution.getChanges().size(), is(2));
    }

    @Test
    public void testWithModelsAddO2() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 1));
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 2));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(2, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(4));
        assertThat(solution.getChanges().size(), is(2));
    }

    @Test
    public void testWithModelsAddO3l() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("x", 1, 1));
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 2));
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 3));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(3, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(7));
        assertThat(solution.getChanges().size(), is(4));
    }

    @Test
    public void testWithModelsAddO3() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 1));
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 2));
        models.add(new CodeJamMain.ProblemD.Model("x", 1, 3));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(3, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(7));
        assertThat(solution.getChanges().size(), is(3));
    }

    @Test
    public void testWithModelsAddO3m() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 1));
        models.add(new CodeJamMain.ProblemD.Model("x", 1, 2));
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 3));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(3, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(7));
        assertThat(solution.getChanges().size(), is(4));
    }

    @Test
    public void testWithModelsPlus() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 1));
        models.add(new CodeJamMain.ProblemD.Model("x", 1, 2));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(3, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(7));
        assertThat(solution.getChanges().size(), is(5));
    }

    @Test
    public void testWithModelsO1() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("o", 1, 1));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(3, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(7));
        assertThat(solution.getChanges().size(), is(5));
    }

    @Test
    public void testWithModelsO2() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("o", 1, 2));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(3, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(7));
        assertThat(solution.getChanges().size(), is(5));
    }

    @Test
    public void testWithModelsO3() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("o", 1, 3));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(3, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(7));
        assertThat(solution.getChanges().size(), is(4));
    }


    @Test
    public void testWithModelsAllP() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 1));
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 2));
        models.add(new CodeJamMain.ProblemD.Model("+", 1, 3));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(3, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(7));
        assertThat(solution.getChanges().size(), is(4));
    }

    @Test
    public void testWithModels4() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(4, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(10));
        assertThat(solution.getChanges().size(), is(9));
    }

    @Test
    public void testWithModels5() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(5, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(13));
        assertThat(solution.getChanges().size(), is(12));
    }

    @Test
    public void testWithModels10() throws Exception {
        LinkedList<CodeJamMain.ProblemD.Model> models = new LinkedList<>();
        models.add(new CodeJamMain.ProblemD.Model("x", 1, 2));
        CodeJamMain.ProblemD.Show show = new CodeJamMain.ProblemD.Show(10, models);
        CodeJamMain.Solution solution = show.optimise();
        assertThat(solution.getPoints(), is(28));
        assertThat(solution.getChanges().size(), is(27));
    }
}