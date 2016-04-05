/**
 * Created by Pavel on 05.04.2016.
 */
public class NumberValidator implements Validator<Number> {
    @Override
    public boolean isValid(Number n) {
        if (n.intValue() > 0) {
            return true;
        } else {
            return false;
        }


    }

}
