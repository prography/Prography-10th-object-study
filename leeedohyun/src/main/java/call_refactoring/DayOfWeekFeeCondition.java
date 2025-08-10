package call_refactoring;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class DayOfWeekFeeCondition implements FeeCondition {
    private List<DayOfWeek> dayOfWeeks = new ArrayList<>();

    public DayOfWeekFeeCondition(DayOfWeek... dayOfWeeks) {
        this.dayOfWeeks = List.of(dayOfWeeks);
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return call.getInterval()
                .splitByDay()
                .stream()
                .filter(each -> dayOfWeeks.contains(each.getFrom().getDayOfWeek()))
                .toList();
    }
}
