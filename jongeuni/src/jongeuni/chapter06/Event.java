package jongeuni.chapter06;

import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
public class Event {
    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public boolean isSatisfied(RecurringSchedule schedule) {
        if(from.getDayOfWeek() != schedule.getDayOfWeek() ||
        !from.toLocalDate().equals(schedule.getFrom()) ||
        !duration.equals(schedule.getDuration())) {
            reschedule(schedule);
            return false;
        }
        return true;
    }

    // 명령과 쿼리를 함께 쓰고 있음!! 주의!!
    private void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(
                from.toLocalDate().plusDays(dayDistance(schedule)),
                schedule.getFrom()
        );
        duration = schedule.getDuration();
    }

    private long dayDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }
}
