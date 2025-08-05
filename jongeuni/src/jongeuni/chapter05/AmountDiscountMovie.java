package jongeuni.chapter05;

import jongeuni.chapter03_04.Money;

import java.time.Duration;
import java.util.List;

public class AmountDiscountMovie extends Movie{
    private Money discountAmount;

    public AmountDiscountMovie(String title, Duration runningTIme,
                               Money fee, Money discountAmount, List<DiscountCondition> discountConditions){
        super(title, runningTIme, fee, discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return discountAmount;
    }
}
