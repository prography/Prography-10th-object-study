package responsibility;

import java.time.Duration;
import java.util.List;

import movie.Money;

public class NoneDiscountMovie extends Movie {

    public NoneDiscountMovie(String title, Duration runningTime, Money fee,
                             List<DiscountCondition> discountConditions) {
        super(title, runningTime, fee, discountConditions);
    }

    @Override
    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
