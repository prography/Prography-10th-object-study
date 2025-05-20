package commandquery;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {

    @Test
    void 이벤트가_일정_조건을_만족하는지_확인한다() {
        // given
        RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.TUESDAY, LocalTime.of(10, 30),
                Duration.ofMillis(30));
        Event meeting = new Event("회의", LocalDateTime.of(2025, 5, 20, 10, 30), Duration.ofMillis(30));

        // when
        boolean result = meeting.isSatisfied(schedule);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void isSatisfied_메서드를_두_번_호출하면_버그가_발생한다() {
        // given
        RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.TUESDAY, LocalTime.of(10, 30),
                Duration.ofMillis(30));
        Event meeting = new Event("회의", LocalDateTime.of(2025, 5, 21, 10, 30), Duration.ofMillis(30));

        // when
        boolean result1 = meeting.isSatisfied(schedule);
        boolean result2 = meeting.isSatisfied(schedule);

        // then
        assertThat(result1).isFalse();
        assertThat(result2).isTrue();
    }
}
