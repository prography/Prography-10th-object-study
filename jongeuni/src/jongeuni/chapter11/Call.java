package jongeuni.chapter11;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Call {
    @Getter
    private LocalDateTime from;
    private LocalDateTime to;

    public Duration getDuration() {
        return Duration.between(from, to);
    }
}
