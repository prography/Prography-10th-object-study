package movie;

import common.Money;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);
}
