package jongeuni.chapter14;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jongeuni.chapter02.Money;
import lombok.AllArgsConstructor;

// 구간별 정책
@AllArgsConstructor
public class DurationFeeCondition implements FeeCondition{
    private Duration from;
    private Duration to;


    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        if(call.getInterval().duration().compareTo(from) < 0) {
            return Collections.emptyList();
        }

        return List.of(DateTimeInterval.of(
                call.getInterval().getFrom().plus(from),
                call.getInterval().duration().compareTo(to) > 0 ?
                        call.getInterval().getFrom().plus(to) : call.getInterval().getFrom()
        ));
    }
}
