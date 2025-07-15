package jongeuni.chapther10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import jongeuni.chapther02.Money;
import lombok.Getter;

@Getter
public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();


    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.regularAmount = regularAmount;
        this.nightlyAmount = nightlyAmount;
        this.seconds = seconds;
    }

    public Money calculateFee() {

        Money result = Money.ZERO;

        for(Call call : getCalls()) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    private Money calculateCallFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().getSeconds() / getSeconds().getSeconds());
        } else {
            return regularAmount.times(call.getDuration().getSeconds() / getSeconds().getSeconds());
        }
    }
}
