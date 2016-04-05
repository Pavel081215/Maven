/**
 * Created by Pavel on 05.04.2016.
 */
public interface Validator<T> {
    // Валидирует переданое значение
    boolean isValid(T result);

}
