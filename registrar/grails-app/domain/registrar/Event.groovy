package registrar

import java.time.LocalDateTime

class Event {

    String description
    LocalDateTime startDate
    LocalDateTime endDate
    Boolean wholeDay = false

    // TODO         startDate <= endDate
    static constraints = {
        description blank: false, unique: true
        startDate nullable: false
        endDate:
        nullable: false // validator: {startDate, endDate -> startDate<=endDate || endDate == startDate}
    }
}
