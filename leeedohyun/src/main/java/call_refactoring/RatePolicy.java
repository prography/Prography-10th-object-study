package call_refactoring;

import common.Money;

public interface RatePolicy {

    Money calculateFee(Phone phone);
}
