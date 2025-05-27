package movie;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import common.Money;

import static org.assertj.core.api.Assertions.assertThat;

class PeriodConditionTest {

    @Test
    void 기간에_해당하는_요일과_시간일_경우_할인_조건을_만족한다() {
        // given
        Movie movie = new Movie("아바타", Duration.ofMinutes(100), Money.wons(10000), null);
        PeriodCondition condition = new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0));
        Screening screening = new Screening(movie, 1, LocalDateTime.of(2023, 10, 2, 11, 0));

        // when
        boolean result = condition.isSatisfiedBy(screening);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 요일이_다르면_할인_조건을_만족하지_않는다() {
        Movie movie = new Movie("아바타", Duration.ofMinutes(100), Money.wons(10000), null);
        PeriodCondition condition = new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0));
        Screening screening = new Screening(movie, 1, LocalDateTime.of(2025, 4, 23, 11, 0)); // Monday

        boolean result = condition.isSatisfiedBy(screening);

        assertThat(result).isFalse();
    }

    @Test
    void 시작시간_이전이면_할인_조건을_만족하지_않는다() {
        Movie movie = new Movie("아바타", Duration.ofMinutes(100), Money.wons(10000), null);
        PeriodCondition condition = new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0));
        Screening screening = new Screening(movie, 1, LocalDateTime.of(2025, 4, 23, 9, 59, 59));

        boolean result = condition.isSatisfiedBy(screening);

        assertThat(result).isFalse();
    }

    @Test
    void 종료시간_이후면_할인_조건을_만족하지_않는다() {
        Movie movie = new Movie("아바타", Duration.ofMinutes(100), Money.wons(10000), null);
        PeriodCondition condition = new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0));
        Screening screening = new Screening(movie, 1, LocalDateTime.of(2023, 10, 2, 12, 1));

        boolean result = condition.isSatisfiedBy(screening);

        assertThat(result).isFalse();
    }
}
