import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Pavel on 05.04.2016.
 */
public class ExecutorImplTest {
    private Validator<Number> validator;
    private Task<Long> task1;
    private Task<Long> task10;
    private ExecutorImpl<Number> executorImpl = new ExecutorImpl();
    private List<Long> expected = new ArrayList<>();

    @Test
    public void getValidResults() throws Exception {
        expected.clear();
        validator = new NumberValidator();
        task1 = new LongTask(10);
        task10 = new LongTask(110);
        executorImpl.addTask(task10);
        executorImpl.addTask(task1, validator);
        executorImpl.execute();
        List actuals = new ArrayList();
        expected.add(113L);
        expected.add(13L);
        // expected.add(-197L);

        actuals.addAll(executorImpl.getValidResults());

        // Assert.assertArrayEquals(expected, actuals);
        Assert.assertEquals(expected, actuals);
        // Assert.assertEquals(new HashSet(expected), new HashSet(actuals));

    }

    @Test
    public void getInvalidResults() throws Exception {

        expected.clear();
        validator = new NumberValidator();
        task1 = new LongTask(-10);
        task10 = new LongTask(110);
        executorImpl.addTask(task10);
        executorImpl.addTask(task1, validator);
        executorImpl.execute();
        List actuals = new ArrayList();
        expected.add(-7L);
        //expected.add(3);
        actuals.addAll(executorImpl.getInvalidResults());
        Assert.assertEquals(expected, actuals);

    }

}