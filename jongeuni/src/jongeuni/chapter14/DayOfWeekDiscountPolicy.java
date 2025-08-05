package jongeuni.chapter14;

import java.util.ArrayList;
import java.util.List;
import jongeuni.chapter02.Money;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DayOfWeekDiscountPolicy extends BasicRatePolicy{
    private List<DayOfWeekDiscountRule> rules = new ArrayList<>();

    @Override
    protected Money calculateCallFee(Call call) {
        Money result = Money.ZERO;
        for(DateTimeInterval interval: call.getInterval().splitByDay()) {
            for(DayOfWeekDiscountRule rule: rules) {
                result.plus(rule.calculate(interval));
            }
        }
        return result;
    }
}
