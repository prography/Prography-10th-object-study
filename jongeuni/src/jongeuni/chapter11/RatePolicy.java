package jongeuni.chapter11;

import jongeuni.chapter02.Money;
import jongeuni.chapter11.Phone;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
