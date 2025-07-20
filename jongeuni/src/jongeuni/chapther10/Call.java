package jongeuni.chapther10;

import java.time.Duration;
import java.time.LocalDateTime;
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
