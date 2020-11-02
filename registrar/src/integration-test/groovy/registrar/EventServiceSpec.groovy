package registrar

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import org.hibernate.SessionFactory
import spock.lang.Specification

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Integration
@Rollback
class EventServiceSpec extends Specification {

    EventService eventService
    SessionFactory sessionFactory

    private Long setupData() {
        new Event(description: "D1", startDate: LocalDateTime.now(), endDate: LocalDateTime.now(), wholeDay: true).save(flush: true, failOnError: true)
        new Event(description: "D2", startDate: LocalDateTime.parse("2020-10-31T01:02:03", DateTimeFormatter.ISO_LOCAL_DATE_TIME), endDate: LocalDateTime.now(), wholeDay: true).save(flush: true, failOnError: true)
        new Event(description: "D3", startDate: LocalDateTime.parse("2020-10-30T01:02:03", DateTimeFormatter.ISO_LOCAL_DATE_TIME), endDate: LocalDateTime.now(), wholeDay: true).save(flush: true, failOnError: true)
        new Event(description: "D4", startDate: LocalDateTime.parse("2020-10-29T01:02:03", DateTimeFormatter.ISO_LOCAL_DATE_TIME), endDate: LocalDateTime.now(), wholeDay: true).save(flush: true, failOnError: true)

        Event event = new Event(description: "D0", startDate: LocalDateTime.now(), endDate: LocalDateTime.now())
        event.save(flush: true, failOnError: true)
        event.id
    }

    void "test get"() {
        setupData()

        expect:
        eventService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Event> eventList = eventService.list(max: 2, offset: 2)

        then:
        eventList.size() == 2
        eventList.get(0).description == "D1"
        eventList.get(1).description == "D2"
    }

    void "test count"() {
        setupData()

        expect:
        eventService.count() == 5
    }

    void "test delete"() {
        Long eventId = setupData()

        expect:
        eventService.count() == 5

        when:
        eventService.delete(eventId)
        sessionFactory.currentSession.flush()

        then:
        eventService.count() == 4
    }

    void "test save"() {
        when:
        Event event = new Event(description: "readyForSaving", startDate: LocalDateTime.now(), endDate: LocalDateTime.now(), wholeDay: true)
        eventService.save(event)

        then:
        event.id != null
    }
}
