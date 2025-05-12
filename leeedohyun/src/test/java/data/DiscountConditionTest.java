package data;

import java.time.DayOfWeek;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DiscountConditionTest {

    @Test
    void 조건에_해당하는_요일과_시간이면_할인_가능하다() {
        // given
        DiscountCondition condition = new DiscountCondition(
                DiscountConditionType.PERIOD,
                0,
                DayOfWeek.MONDAY,
                LocalTime.of(10, 0),
                LocalTime.of(12, 0)
        );

        // when
        boolean result = condition.isDiscountable(DayOfWeek.MONDAY, LocalTime.of(11, 0));

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 요일은_같지만_시간이_범위를_벗어나면_할인이_불가능하다() {
        // given
        DiscountCondition condition = new DiscountCondition(
                DiscountConditionType.PERIOD,
                0,
                DayOfWeek.MONDAY,
                LocalTime.of(10, 0),
                LocalTime.of(12, 0)
        );

        // when
        boolean result = condition.isDiscountable(DayOfWeek.MONDAY, LocalTime.of(9, 59));

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 시간은_맞지만_요일이_다르면_할인이_불가능하다() {
        // given
        DiscountCondition condition = new DiscountCondition(
                DiscountConditionType.PERIOD,
                0,
                DayOfWeek.TUESDAY,
                LocalTime.of(10, 0),
                LocalTime.of(12, 0)
        );

        // when
        boolean result = condition.isDiscountable(DayOfWeek.MONDAY, LocalTime.of(11, 0));

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 조건_타입이_PERIOD가_아닌_경우_예외가_발생한다() {
        // given
        DiscountCondition condition = new DiscountCondition(
                DiscountConditionType.SEQUENCE,
                1,
                null,
                null,
                null
        );

        // when & then
        assertThatThrownBy(() -> condition.isDiscountable(DayOfWeek.MONDAY, LocalTime.of(11, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 순서가_일치하면_할인이_가능하다() {
        // given
        DiscountCondition condition = new DiscountCondition(
                DiscountConditionType.SEQUENCE,
                1,
                null,
                null,
                null
        );

        // when
        boolean result = condition.isDiscountable(1);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 순서가_일치하지_않으면_할인이_불가능하다() {
        // given
        DiscountCondition condition = new DiscountCondition(
                DiscountConditionType.SEQUENCE,
                1,
                null,
                null,
                null
        );

        // when
        boolean result = condition.isDiscountable(2);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 조건_타입이_PERIOD이면_예외가_발생한다() {
        // given
        DiscountCondition condition = new DiscountCondition(
                DiscountConditionType.PERIOD,
                1,
                null,
                null,
                null
        );

        // when & then
        assertThatThrownBy(() -> condition.isDiscountable(2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

