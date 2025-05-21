package jongeuni.chapther05;

import lombok.AllArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

@AllArgsConstructor
public class PeriodCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    private boolean isSatisfiedByPeriod(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
                !startTime.isAfter(screening.getWhenScreened().toLocalTime()) &&
                endTime.isAfter(screening.getWhenScreened().toLocalTime());
    }
}
