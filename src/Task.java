/**
 * Created by Pavel on 05.04.2016.
 */
public interface Task<T> {
    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();

}
