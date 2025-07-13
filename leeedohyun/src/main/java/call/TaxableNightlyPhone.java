package call;

import java.time.Duration;

import common.Money;

public class TaxableNightlyPhone extends NightlyDiscountPhone {
    private double taxRate;

    public TaxableNightlyPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
        super(nightlyAmount, regularAmount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    public Money calculateCallFee(Call call) {
        Money fee = super.calculateFee();
        return fee.plus(fee.times(taxRate));
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRate));
    }
}
