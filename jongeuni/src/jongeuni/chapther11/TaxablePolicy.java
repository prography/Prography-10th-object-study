package jongeuni.chapther11;

import jongeuni.chapther02.Money;

public class TaxablePolicy extends AdditionalRatePolicy{
    private double taxRate;

    public TaxablePolicy(double taxRate, RatePolicy next){
        super(next);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRate));
    }
}
