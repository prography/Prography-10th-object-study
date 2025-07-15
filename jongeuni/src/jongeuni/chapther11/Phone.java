package jongeuni.chapther11;

import java.util.ArrayList;
import java.util.List;
import jongeuni.chapther02.Money;

public abstract class Phone {
    private List<Call> calls = new ArrayList<Call>();

    public Money calculateFee() {

        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected Money afterCalculated(Money fee) {
        return fee;
    }

    protected abstract Money calculateCallFee(Call call);

}
