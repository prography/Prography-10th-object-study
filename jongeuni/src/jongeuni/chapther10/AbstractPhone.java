package jongeuni.chapther10;

import java.util.ArrayList;
import java.util.List;
import jongeuni.chapther02.Money;

public abstract class AbstractPhone {
    private List<Call> calls = new ArrayList<Call>();

    public Money calculateFee() {

        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    abstract protected Money calculateCallFee(Call call);
}
