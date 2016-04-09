

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 05.04.2016.
 */
public class ExecutorImplTestNG {

    private Validator<Number> validator;
    private Task<Long> task1;
    private Task<Long> task10;
    private ExecutorImpl<Number> executorImpl = new ExecutorImpl();
    private List<Long> expected = new ArrayList<>();

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