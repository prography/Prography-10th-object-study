package jongeuni.chapter14;

import jongeuni.chapter02.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
