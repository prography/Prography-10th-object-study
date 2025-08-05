package jongeuni.chapter05;

import jongeuni.chapter03_04.Money;

import java.time.Duration;
import java.util.List;

public class PercentDiscountMovie extends Movie{
    private double percent;

    public PercentDiscountMovie(String title, Duration runningTIme,
                                Money fee, double percent, List<DiscountCondition> discountConditions){
        super(title, runningTIme, fee, discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(percent);
    }
}
