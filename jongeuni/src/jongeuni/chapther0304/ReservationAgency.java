package jongeuni.chapther0304;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = false;

        // 할인 가능 여부 체크
        for(DiscountCondition condition : movie.getDiscountConditions()) {
            if(condition.getType() == DiscountConditionType.PERIOD) {
                discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
                        !condition.getStartTime().isAfter(screening.getWhenScreened().toLocalTime()) &&
                        !condition.getEndTime().isBefore(screening.getWhenScreened().toLocalTime());
            } else {
                discountable = condition.getSequence() == screening.getSequence();
            }

            if(discountable) {
                break;
            }
        }

        Money fee;

        // 할인 정책에 따라 예매 요금 계산
        if(discountable) {
            Money discountAmount = switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT -> movie.getDiscountAmount();
                case PERCENT_DISCOUNT -> movie.getFee().times(movie.getDiscountPercent());
                case NONE_DISCOUNT -> Money.ZERO;
            };
            fee = movie.getFee().minus(discountAmount);
        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
