package registrar

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

import java.time.LocalDateTime

@Integration
@Rollback
class EventServiceSpec extends Specification {

    EventService eventService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        Event event = new Event(description: "D1", startDate: LocalDateTime.now(), endDate: LocalDateTime.now(), wholeDay: true).save(flush: true, failOnError: true)

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
        assert false, "TODO: Provide a valid instance to save"
        Event event = new Event()
        eventService.save(event)

        then:
        event.id != null
    }
}
