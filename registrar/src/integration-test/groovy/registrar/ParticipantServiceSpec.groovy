package registrar

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ParticipantServiceSpec extends Specification {

    ParticipantService participantService
    SessionFactory sessionFactory

    private Long setupData() {
        /*
            String firstName;
    String name;
    String telephoneContact;
    String emailContact;
         */

        //new Participant(...).save(flush: true, failOnError: true)
        //new Participant(...).save(flush: true, failOnError: true)
        //new Participant(...).save(flush: true, failOnError: true)
        //new Participant(...).save(flush: true, failOnError: true)

        Participant participant = new Participant(firstName: "D.J.", name: "Trumpet", email: "fake@news.org", telephoneContact: "+440987").save(flush: true, failOnError: true)
        participant.id
    }

    void "test get"() {
        setupData()

        expect:
        participantService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Participant> participantList = participantService.list(max: 2, offset: 2)

        then:
        participantList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        participantService.count() == 5
    }

    void "test delete"() {
        Long participantId = setupData()

        expect:
        participantService.count() == 5

        when:
        participantService.delete(participantId)
        sessionFactory.currentSession.flush()

        then:
        participantService.count() == 4
    }

    void "test save"() {
        when:
        Participant participant = new Participant(firstName: "Борат Маргарет", name: "Сағдиев", email: "nonews@fake.org").save(flush: true, failOnError: true)
        participantService.save(participant)

        then:
        participant.id != null
    }
}
