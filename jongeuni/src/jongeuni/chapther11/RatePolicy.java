package jongeuni.chapther11;

import jongeuni.chapther02.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
