package registrar

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import org.hibernate.SessionFactory
import spock.lang.Specification

@Integration
@Rollback
class ParticipantServiceSpec extends Specification {

    ParticipantService participantService
    SessionFactory sessionFactory

    private Long setupData() {
        new Participant(firstName: "Joe", name: "Bydkowicz", emailContact: "joe@news.org", telephoneContact: "+4409876").save(flush: true, failOnError: true)
        new Participant(firstName: "Joanna", name: "Bydkowicz", emailContact: "joa@news.org", telephoneContact: "+44098765").save(flush: true, failOnError: true)
        new Participant(firstName: "Jill", name: "Bydkowicz", emailContact: "jill@news.org", telephoneContact: "+44098764").save(flush: true, failOnError: true)
        new Participant(firstName: "J.R.", name: "Bydkowicz", emailContact: "jr@news.org", telephoneContact: "+44098763").save(flush: true, failOnError: true)

        Participant participant = new Participant(firstName: "D.J.", name: "Trumpet", emailContact: "fake@news.org", telephoneContact: "+440987").save(flush: true, failOnError: true)
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
        participantList.get(0).firstName == "Jill"
        participantList.get(0).name == "Bydkowicz"
        participantList.get(1).firstName == "J.R."
        participantList.get(1).name == "Bydkowicz"
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
        Participant participant = new Participant(firstName: "Борат Маргарет", name: "Сағдиев", emailContact: "nonews@fake.org", telephoneContact: "+43120").save(flush: true, failOnError: true)
        participantService.save(participant)

        then:
        participant.id != null
    }
}
