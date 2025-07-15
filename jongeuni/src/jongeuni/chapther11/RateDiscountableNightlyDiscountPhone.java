package jongeuni.chapther11;

import java.time.Duration;
import jongeuni.chapther02.Money;

public class RateDiscountableNightlyDiscountPhone extends NightlyDiscountPhone{
    private Money discountAmount;

    public RateDiscountableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount,
            Duration seconds, Money discountAmount) {
        super(nightlyAmount, regularAmount, seconds);
        this.discountAmount = discountAmount;
    }


    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
