package jongeuni.chapter14;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jongeuni.chapter02.Money;
import lombok.AllArgsConstructor;

// 요일별 정책
public class DayOfWeekFeeCondition implements FeeCondition{
    private List<DayOfWeek> dayOfWeeks = new ArrayList<>();

    public DayOfWeekFeeCondition(DayOfWeek... dayOfWeek) {
        this.dayOfWeeks = Arrays.asList(dayOfWeek);
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return call.getInterval()
                .splitByDay()
                .stream().filter(each -> dayOfWeeks.contains(each
                        .getFrom().getDayOfWeek()))
                .toList();
    }
}
