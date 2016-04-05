/**
 * Created by Pavel on 05.04.2016.
 */
public class IntegerValidator implements Validator<Integer> {
    public boolean isValid(Integer s) {
        return s.doubleValue() > 0;
    }

}
