import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 05.04.2016.
 */
public class Cheks {
    public static void main(String[] args) throws Exception {

        List list = new ArrayList();
        Task<Long> longTask = new LongTask(-1l);
        Task<Long> longTask2 = new LongTask(2l);
        Task<Long> longTask3 = new LongTask(-30l);
        Task<Long> longTask4 = new LongTask(4l);
        list.add(longTask);
        list.add(longTask2);
        list.add(longTask3);
        list.add(longTask4);

        Cheks cheks = new Cheks();
        cheks.test(list);
    }

    public void test(List<Task<Long>> intTasks) throws Exception {
        Executor<Number> numberExecutor = new ExecutorImpl<>();

        for (Task<Long> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }
        numberExecutor.addTask(new LongTask(-1000L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }

}

