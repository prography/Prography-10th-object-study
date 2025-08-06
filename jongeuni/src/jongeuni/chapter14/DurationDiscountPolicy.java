package jongeuni.chapter14;

import java.util.ArrayList;
import java.util.List;
import jongeuni.chapter02.Money;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DurationDiscountPolicy extends BasicRatePolicy{
    private List<DurationDiscountRule> rules = new ArrayList<>();

    @Override
    protected Money calculateCallFee(Call call) {
        Money result = Money.ZERO;
        for(DurationDiscountRule rule : rules){
            result.plus(rule.calculate(call));
        }
        return result;
    }
}
