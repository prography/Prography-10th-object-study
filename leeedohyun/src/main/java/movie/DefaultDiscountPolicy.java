package movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import common.Money;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {

    private List<DisCountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DisCountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for (DisCountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
