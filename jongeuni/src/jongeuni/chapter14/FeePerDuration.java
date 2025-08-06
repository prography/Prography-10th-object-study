package jongeuni.chapter14;

import java.time.Duration;
import jongeuni.chapter02.Money;
import lombok.AllArgsConstructor;

// 단위 시간당 요금 개념 표현
@AllArgsConstructor
public class FeePerDuration {
    private Money fee;
    private Duration duration;

    public Money calculate(DateTimeInterval interval) {
        return fee.times(interval.duration().getSeconds() / duration.getSeconds());
    }
}
