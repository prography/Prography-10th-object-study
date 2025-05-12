package data;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import movie.Money;

import static org.assertj.core.api.Assertions.assertThat;

class ReservationAgencyTest {

    private Movie movie;
    private Screening screening;
    private Customer customer;

    @BeforeEach
    void setUp() {
        movie = new Movie("MovieTitle", Money.wons(10000), MovieType.PERCENT_DISCOUNT);
        customer = new Customer("John Doe", "id");
        screening = new Screening(movie, 1, LocalDateTime.of(2025, 5, 5, 11, 0));
    }

    @Test
    void 상영_요일과_시간이_할인_조건과_일치하면_퍼센트_할인이_적용된다() {
        // given
        DiscountCondition condition = new DiscountCondition(
                DiscountConditionType.PERIOD,
                0,
                DayOfWeek.MONDAY,
                LocalTime.of(10, 0),
                LocalTime.of(12, 0)
        );
        movie.setDisCountConditions(List.of(condition));
        movie.setDiscountPercent(0.1);
        ReservationAgency reservationAgency = new ReservationAgency();

        // when
        Reservation result = reservationAgency.reserve(screening, customer, 2);

        // then
        assertThat(result.getFee()).isEqualTo(Money.wons(18000));
    }

    @Test
    void 상영_순번이_할인_조건과_일치하면_퍼센트_할인이_적용된다() {
        // given
        DiscountCondition condition = new DiscountCondition(
                DiscountConditionType.SEQUENCE,
                1,
                null,
                null,
                null
        );
        movie.setDisCountConditions(List.of(condition));
        movie.setDiscountPercent(0.1);
        ReservationAgency reservationAgency = new ReservationAgency();

        // when
        Reservation result = reservationAgency.reserve(screening, customer, 2);

        // then
        assertThat(result.getFee()).isEqualTo(Money.wons(18000));
    }

    @Test
    void 정액_할인_영화인_경우_할인_금액이_차감된다() {
        // given
        movie = new Movie("정액영화", Money.wons(10000), MovieType.AMOUNT_DISCOUNT);
        DiscountCondition condition = new DiscountCondition(
                DiscountConditionType.SEQUENCE,
                1,
                null,
                null,
                null
        );
        movie.setDisCountConditions(List.of(condition));
        movie.setDiscountAmount(Money.wons(1000));
        screening = new Screening(movie, 1, LocalDateTime.of(2025, 5, 5, 14, 0));
        ReservationAgency reservationAgency = new ReservationAgency();

        // when
        Reservation result = reservationAgency.reserve(screening, customer, 2);

        // then
        assertThat(result.getFee()).isEqualTo(Money.wons(18000));
    }

    @Test
    void 할인_유형이_없을_경우_정가가_적용된다() {
        // given
        movie = new Movie("일반영화", Money.wons(10000), MovieType.NONE_DISCOUNT);
        movie.setDisCountConditions(List.of());
        screening = new Screening(movie, 1, LocalDateTime.of(2025, 5, 5, 14, 0));
        ReservationAgency reservationAgency = new ReservationAgency();

        // when
        Reservation result = reservationAgency.reserve(screening, customer, 3);

        // then
        assertThat(result.getFee()).isEqualTo(Money.wons(30000));
    }
}

