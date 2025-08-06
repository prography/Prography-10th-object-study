package jongeuni.chapter05;


import jongeuni.chapter03_04.Money;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.util.List;

@AllArgsConstructor
public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    public Money calculateMovieFee(Screening screening) {
        if(isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    // 다형성 패턴
    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream().anyMatch(
                condition -> condition.isSatisfiedBy(screening)
        );
    }

    abstract protected Money calculateDiscountAmount();

    protected Money getFee() {
        return fee;
    }
}
