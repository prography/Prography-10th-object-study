package commandquery;

import java.time.LocalDateTime;

public class Event {

    private String subject;
    private LocalDateTime from;
    private LocalDateTime duration;

    public Event(String subject, LocalDateTime from, LocalDateTime duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }
}
