import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Pavel on 05.04.2016.
 */
public class ExecutorImpl<T> implements Executor<T> {
    List<Task<? extends T>> taskExecutor = new ArrayList<>();

    List<T> number = new ArrayList<>();

    Map<Task<? extends T>, Validator<? super T>> selectionNumberValidator = new HashMap<>();

    boolean flag = false;

    @Override
    public void addTask(Task<? extends T> task) throws MethodHasBeenStartedException {
        addTask(task, null);
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) throws MethodHasBeenStartedException {

        if (!flag) {
            taskExecutor.add(task);
            selectionNumberValidator.put(task, validator);
        } else {
            throw new MethodHasBeenStartedException("Метод execute был запущен раньше ");
        }

    }

    @Override
    public void execute() {
        flag = true;

        for (int i = 0; i < taskExecutor.size(); i++) {

            taskExecutor.get(i).execute();
        }
    }

    @Override
    public List<T> getValidResults() {
        number.clear();

        for (int i = 0; i < taskExecutor.size(); i++) {

            if (getValidator(selectionNumberValidator, taskExecutor, i) != null) {
                if (getValidator(selectionNumberValidator, taskExecutor, i).isValid(getTaskL(taskExecutor, i).getResult())) {
                    number.add(taskExecutor.get(i).getResult());
                }
            } else {
                number.add(taskExecutor.get(i).getResult());
            }
        }
        return number;
    }

    @Override
    public List<T> getInvalidResults() {
        number.clear();
        for (int i = 0; i < taskExecutor.size(); i++) {

            if (getValidator(selectionNumberValidator, taskExecutor, i) != null) {
                if (!(getValidator(selectionNumberValidator, taskExecutor, i)).isValid(getTaskL(taskExecutor, i).getResult())) {
                    number.add(taskExecutor.get(i).getResult());
                }
            }

        }
        return number;
    }

    public Validator<? super T> getValidator(Map<Task<? extends T>, Validator<? super T>> selection, List<Task<? extends T>> task, int index) {
        return selection.get(task.get(index));
    }

    public Task<? extends T> getTaskL(List<Task<? extends T>> task, int index) {
        return task.get(index);
    }

}
