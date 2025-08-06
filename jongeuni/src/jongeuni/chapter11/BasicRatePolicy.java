package jongeuni.chapter11;

import jongeuni.chapter02.Money;

public abstract class BasicRatePolicy implements RatePolicy {
    public Money calculateFee(Phone phone) {

        Money result = Money.ZERO;

        for(Call call : phone.getCalls()) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected abstract Money calculateCallFee(Call call);

}
