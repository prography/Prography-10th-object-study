package jongeuni.chapter11;

import jongeuni.chapter02.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
