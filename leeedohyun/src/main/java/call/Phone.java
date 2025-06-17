package call;

import java.util.ArrayList;
import java.util.List;

import common.Money;

public abstract class Phone {
    private double taxRate;
    private List<Call> calls = new ArrayList<>();

    protected Phone(double taxRate) {
        this.taxRate = taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    abstract protected Money calculateCallFee(Call call);
}
