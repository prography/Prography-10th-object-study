package jongeuni.chapther10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import jongeuni.chapther02.Money;
import lombok.Getter;

@Getter
public class nighlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private double taxRate;
    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<Call>();

    public nighlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            } else {
                result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            }

        }

        return result.plus(result.times(taxRate));
    }
}
