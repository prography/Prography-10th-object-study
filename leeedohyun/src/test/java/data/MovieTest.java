package data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import movie.Money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MovieTest {

    @Test
    void 금액_할인이_적용된_영화_요금을_계산한다() {
        // given
        Movie movie = new Movie("test", Money.wons(10000), MovieType.AMOUNT_DISCOUNT);
        movie.setDiscountAmount(Money.wons(1000));

        // when
        Money discountedFee = movie.calculateAmountDiscountedFee();

        // then
        assertThat(discountedFee).isEqualTo(Money.wons(9000));
    }

    @ParameterizedTest
    @EnumSource(value = MovieType.class, names = "AMOUNT_DISCOUNT", mode = EnumSource.Mode.EXCLUDE)
    void 금액_할인이_적용된_영화_요금을_계산_시_AMOUNT_DISCOUNT_타입이_아니면_예외가_발생한다(MovieType movieType) {
        // given
        Movie movie = new Movie("test", Money.wons(10000), movieType);

        // when & then
        assertThatThrownBy(() -> movie.calculateAmountDiscountedFee())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 비율_할인이_적용된_영화_요금을_계산한다() {
        // given
        Movie movie = new Movie("test", Money.wons(10000), MovieType.PERCENT_DISCOUNT);
        movie.setDiscountPercent(0.1);

        // when
        Money discountedFee = movie.calculatePercentDiscountedFee();

        // then
        assertThat(discountedFee).isEqualTo(Money.wons(9000));
    }

    @ParameterizedTest
    @EnumSource(value = MovieType.class, names = "PERCENT_DISCOUNT", mode = EnumSource.Mode.EXCLUDE)
    void 비율_할인이_적용된_영화_요금을_계산_시_PERCENT_DISCOUNT_타입이_아니면_예외가_발생한다(MovieType movieType) {
        // given
        Movie movie = new Movie("test", Money.wons(10000), movieType);

        // when & then
        assertThatThrownBy(() -> movie.calculatePercentDiscountedFee())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 할인이_적용되지_않은_영화_요금을_계산한다() {
        // given
        Movie movie = new Movie("test", Money.wons(10000), MovieType.NONE_DISCOUNT);

        // when
        Money discountedFee = movie.calculateNoneDiscountedFee();

        // then
        assertThat(discountedFee).isEqualTo(Money.wons(10000));
    }

    @ParameterizedTest
    @EnumSource(value = MovieType.class, names = "NONE_DISCOUNT", mode = EnumSource.Mode.EXCLUDE)
    void 할인이_적용되지_않은_영화_요금을_계산_시_NONE_DISCOUNT_타입이_아니면_예외가_발생한다(MovieType movieType) {
        // given
        Movie movie = new Movie("test", Money.wons(10000), movieType);
        movie.setDiscountAmount(Money.wons(1000));

        // when & then
        assertThatThrownBy(() -> movie.calculateNoneDiscountedFee())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
