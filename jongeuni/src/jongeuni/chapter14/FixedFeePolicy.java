package jongeuni.chapter14;

import java.time.Duration;
import jongeuni.chapter02.Money;
import jongeuni.chapter11.BasicRatePolicy;
import jongeuni.chapter11.Call;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FixedFeePolicy extends BasicRatePolicy {
    private Money amount;
    private Duration seconds;

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
