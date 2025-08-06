package jongeuni.chapter14;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FixedFeeCondition implements FeeCondition{

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return Collections.singletonList(call.getInterval());
    }
}
