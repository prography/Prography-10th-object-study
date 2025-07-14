package jongeuni.chapther10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import jongeuni.chapther02.Money;
import lombok.Getter;

@Getter
public class Phone {
    private Money amount;
    private Duration seconds;
    private double taxRate;
    private List<Call> calls = new ArrayList<Call>();

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        return result.plus(result.times(taxRate));
    }
}
