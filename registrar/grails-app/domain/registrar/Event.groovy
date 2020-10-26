package registrar

class Event {

/*
BRANDENBURG
https://bravors.brandenburg.de/verordnungen/sars_cov_2_umgv#9


BERLIN
https://www.berlin.de/corona/massnahmen/verordnung/
§3 (2)...
 (2) Die Anwesenheitsdokumentation darf ausschließlich zum Vollzug infektionsschutzrechtlicher Vorschriften, insbesondere zur Kontaktnachverfolgung genutzt werden und muss die folgenden Angaben enthalten:

    Vor- und Familienname,
    Telefonnummer,
    Bezirk oder Gemeinde des Wohnortes oder des Ortes des ständigen Aufenthaltes
    vollständige Anschrift oder E-Mail-Adresse,
    Anwesenheitszeit und
    Platz- oder Tischnummer, sofern vorhanden.

Die Anwesenheitsdokumentation nach Satz 1 ist für die Dauer von vier Wochen nach Ende der Veranstaltung oder Inanspruchnahme einer Dienstleistung geschützt vor Einsichtnahme durch Dritte aufzubewahren oder zu speichern. Die Anwesenheitsdokumentation ist den zuständigen Behörden zur Kontrolle der Verpflichtungen nach Absatz 1, 3 und 4 auf Verlangen zugänglich zu machen. Darüber hinaus ist den zuständigen Behörden auf Verlangen die Anwesenheitsdokumentation auszuhändigen oder ihnen auf sonstige geeignete Weise der Zugriff zu ermöglichen, wenn festgestellt wird, dass eine Person zum Zeitpunkt der Veranstaltung, des Besuchs oder der Inanspruchnahme der Dienstleistung krank, krankheitsverdächtig, ansteckungsverdächtig oder Ausscheiderin oder Ausscheider im Sinne des Infektionsschutzgesetzes war. Nach Ablauf der Aufbewahrungsfrist ist die Anwesenheitsdokumentation zu löschen oder zu vernichten. 

*/

    def name;
    def firstName;
    def Date startDate;
    def Date endDate;
    def Date createdAt;

    // TODO         startDate <= endDate
    static constraints = {
    }
}
