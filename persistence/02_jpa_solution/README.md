# Spring und JPA

## Aufgabe 1

1. Erzeuge in der Konfigurationsklasse eine passende DataSource mit dem EmbeddedDatabaseBuilder. Nutze dabei die
   SQL-Skripte in `src/main/resources`
   zur Erzeugung der Test-DB.
2. Erzeuge mittels der `LocalContainerEntityManagerFactoryBean` das Objekt zur Rückgabe der Methode.
3. Setze im `FarmerRepository` die richtige Annotation für den `EntityManager`.
4. Nun wollen wir mittels des Nachnamen eines Farmers den zugehörigen Farmer aus der Datenbank laden. Ermittle unter
   Verwendung einer NamedQuery (Tipp: Schaue in der Klasse `Farmer`nach!) den Farmer.
5. Wir benötigen nun wieder eine Auflistung aller Farmer. Auch hier kannst du eine NamedQuery verwenden um die Liste
   aller Farmer zu bekommen.

Ob du die Aufgaben korrekt gelöst hast, erfährst du, wenn du die Tests in der Klasse `ApplicationTest` ausführst und
diese erfolgreich durchlaufen.