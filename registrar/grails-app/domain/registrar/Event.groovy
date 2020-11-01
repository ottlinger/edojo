package registrar

import java.time.LocalDateTime

class Event {

    String description;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Date createdAt;

    // TODO         startDate <= endDate
    static constraints = {
    }
}
