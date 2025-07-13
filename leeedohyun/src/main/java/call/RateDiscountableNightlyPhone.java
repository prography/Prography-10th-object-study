package call;

import java.time.Duration;

import common.Money;

public class RateDiscountableNightlyPhone extends NightlyDiscountPhone {
    private Money discountAmount;

    public RateDiscountableNightlyPhone(Money amount, Money regularAmount, Duration seconds, Money discountAmount) {
        super(amount, regularAmount, seconds);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
