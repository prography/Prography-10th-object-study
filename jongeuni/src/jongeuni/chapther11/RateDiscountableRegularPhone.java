package jongeuni.chapther11;

import java.time.Duration;
import jongeuni.chapther02.Money;

public class RateDiscountableRegularPhone extends RegularPhone{
    private Money discountAmount;

    public RateDiscountableRegularPhone(Money amount, Duration seconds, Money discountAmount) {
        super(amount, seconds);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
