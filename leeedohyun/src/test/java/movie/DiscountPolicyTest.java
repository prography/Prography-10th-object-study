package movie;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountPolicyTest {

    @Test
    void 금액_할인_정책을_적용한다() {
        // given
        SequenceCondition sequenceCondition = new SequenceCondition(10);
        DefaultDiscountPolicy discountPolicy = new AmountDiscountPolicy(Money.wons(1000), sequenceCondition);
        Movie movie = new Movie("아바타", Duration.ofMinutes(100), Money.wons(10000), discountPolicy);
        Screening screening = new Screening(movie, 10, LocalDateTime.of(2025, 4, 21, 10, 0));

        // when
        Money money = discountPolicy.calculateDiscountAmount(screening);

        // then
        assertThat(money).isEqualTo(Money.wons(1000));
    }

    @Test
    void 비율_할인_정책을_적용한다() {
        // given
        SequenceCondition sequenceCondition = new SequenceCondition(2);
        DefaultDiscountPolicy discountPolicy = new PercentDiscountPolicy(0.1, sequenceCondition);
        Movie movie = new Movie("타이타닉", Duration.ofMinutes(100), Money.wons(10000), discountPolicy);
        Screening screening = new Screening(movie, 2, LocalDateTime.of(2025, 4, 21, 10, 0));

        // when
        Money money = discountPolicy.calculateDiscountAmount(screening);

        // then
        assertThat(money).isEqualTo(Money.wons(1000));
    }

    @Test
    void 할인_정책을_적용하지_않는다() {
        // given
        DiscountPolicy discountPolicy = new NoneDiscountPolicy();
        Movie movie = new Movie("스타워즈", Duration.ofMinutes(100), Money.wons(10000), discountPolicy);
        Screening screening = new Screening(movie, 2, LocalDateTime.of(2025, 4, 21, 10, 0));

        // when
        Money money = discountPolicy.calculateDiscountAmount(screening);

        // then
        assertThat(money).isEqualTo(Money.wons(0));
    }
}
