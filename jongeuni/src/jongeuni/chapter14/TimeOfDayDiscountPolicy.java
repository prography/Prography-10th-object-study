package jongeuni.chapter14;


import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import jongeuni.chapter02.Money;
import jongeuni.chapter14.BasicRatePolicy;
import jongeuni.chapter14.Call;

public class TimeOfDayDiscountPolicy extends BasicRatePolicy {
    private List<LocalTime> starts = new ArrayList<>();
    private List<LocalTime> ends = new ArrayList<>();
    private List<Duration> durations = new ArrayList<>();
    private List<Money> amounts = new ArrayList<>();

    @Override
    protected Money calculateCallFee(Call call) {
        Money result = Money.ZERO;
        for(DateTimeInterval interval: call.splitByDay()) {
            for(int loop=0; loop<starts.size(); loop++) {
                result.plus(amounts.get(loop).times(
                        Duration.between(from(interval,starts.get(loop)), to(interval, ends.get(loop
                        ))).getSeconds()/durations.get(loop).getSeconds()
                ));
            }
        }
        return null;
    }

    private LocalTime from(DateTimeInterval interval, LocalTime from) {
        return interval.getFrom().toLocalTime().isBefore(from) ?
                from :
                interval.getFrom().toLocalTime();
    }

    private LocalTime to(DateTimeInterval interval, LocalTime to) {
        return interval.getTo().toLocalTime().isAfter(to) ?
                to :
                interval.getTo().toLocalTime();
    }
}
