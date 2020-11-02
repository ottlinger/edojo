package registrar

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import org.hibernate.SessionFactory
import spock.lang.Specification

import java.time.LocalDateTime

@Integration
@Rollback
class EventServiceSpec extends Specification {

    EventService eventService
    SessionFactory sessionFactory

    private Long setupData() {
        Event event = new Event(description: "D1", startDate: LocalDateTime.now(), endDate: LocalDateTime.now(), wholeDay: true)
        event.save(flush: true, failOnError: true)

        //new Event(...).save(flush: true, failOnError: true)
        //new Event(...).save(flush: true, failOnError: true)
        //Event event = new Event(...).save(flush: true, failOnError: true)
        //new Event(...).save(flush: true, failOnError: true)
        //new Event(...).save(flush: true, failOnError: true)

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
        assert false, "TODO: Verify the correct instances are returned"
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
