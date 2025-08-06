package jongeuni.chapter14;

import jongeuni.chapter02.Money;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FeeRule {
    private FeeCondition feeCondition;
    private FeePerDuration feePerDuration;

    public Money calculateFee(Call call) {
        return feeCondition.findTimeIntervals(call)
                .stream()
                .map(each -> feePerDuration.calculate(each))
                .reduce(Money.ZERO, (first, second) -> first.plus(second));
    }

}
