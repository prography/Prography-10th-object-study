package jongeuni.chapther11;

import jongeuni.chapther02.Money;

// 부가 정책
public abstract class AdditionalRatePolicy implements RatePolicy{
    private RatePolicy next;

    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee);
    }

    abstract protected Money afterCalculated(Money fee);
}
