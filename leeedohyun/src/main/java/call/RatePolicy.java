package call;

import common.Money;

public interface RatePolicy {

    Money calculateFee(Phone phone);
}
