package jongeuni.chapther11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jongeuni.chapther02.Money;

public class Phone {
    // 이것이 합성
    private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<Call>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }

    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls);
    }


}
