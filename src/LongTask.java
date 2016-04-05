/**
 * Created by Pavel on 05.04.2016.
 */
public class LongTask implements Task<Long> {
    Long result;

    public LongTask(long result) {

        this.result = result;
    }


    @Override
    public void execute() {
        result = result + 1L;

    }

    @Override
    public Long getResult() {

        return result + 2L;
    }

}
