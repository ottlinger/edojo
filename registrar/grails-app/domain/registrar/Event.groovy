package registrar

import java.time.LocalDateTime

class Event {

    String description
    // https://github.com/blemoine/java8-temporal-grails-plugin / https://plugins.grails.org/plugin/grails/grails-java8
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
