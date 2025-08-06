package call_refactoring;

import java.util.List;

public class FixedFeePolicy implements FeeCondition {
    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return List.of(call.getInterval());
    }
}
