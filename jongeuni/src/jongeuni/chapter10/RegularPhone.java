package jongeuni.chapter10;

import java.time.Duration;
import jongeuni.chapter02.Money;
import lombok.Getter;

@Getter
public class RegularPhone extends Phone{

    private Money amount;
    private Duration seconds;

    public RegularPhone(Money amount, Duration seconds, double taxRate) {
        super(taxRate);
        this.amount = amount;
        this.seconds = seconds;
    }


    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
