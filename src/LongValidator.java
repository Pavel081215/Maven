/**
 * Created by Pavel on 05.04.2016.
 */
public class LongValidator implements Validator<Long> {
    @Override
    public boolean isValid(Long s) {
        if (s > 0) {
            return false;
        } else {
            return true;
        }
    }
}
