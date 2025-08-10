package jongeuni.chapter05;

import jongeuni.chapter03_04.Money;

import java.time.Duration;
import java.util.List;

public class NoneDiscountMovie extends Movie{
    public NoneDiscountMovie(String title, Duration runningTIme,
                             Money fee, List<DiscountCondition> discountConditions){
        super(title, runningTIme, fee, discountConditions);
    }

    @Override
    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
