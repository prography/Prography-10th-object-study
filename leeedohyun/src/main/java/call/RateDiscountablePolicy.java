package call;

import common.Money;

public class RateDiscountablePolicy extends AdditionalRatePolicy {
    private double discountAmount;

    public RateDiscountablePolicy(double discountAmount, RatePolicy next) {
        super(next);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(Money.wons(discountAmount));
    }
}
