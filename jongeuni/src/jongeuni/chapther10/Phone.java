package jongeuni.chapther10;

import java.util.ArrayList;
import java.util.List;
import jongeuni.chapther02.Money;

public abstract class Phone {
    private double taxRate;
    private List<Call> calls = new ArrayList<Call>();

    public Phone(double taxRate) {
        this.taxRate = taxRate;
    }

    public Money calculateFee() {

        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    abstract protected Money calculateCallFee(Call call);
}
