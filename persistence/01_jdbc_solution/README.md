# Spring und JDBC

## Aufgabe 1

1. Erzeuge in der Configurationsklasse eine passende DataSource mit dem EmbeddedDatabaseBuilder. Nutze dabei die SQL-Skripte in `src/main/resources`
   zur Erzeugung der Test-DB.
2. Erstelle ein Feld für das JdbcTemplate im `FarmerRepository`.
3. Erzeuge eine neue Instanz des JdbcTemplates mittels der übergebenen DataSource.
4. Nun wollen wir mittels des Nachnamen eines Farmers den zugehörigen Farmer aus der Datenbank laden. Ermittle unter
   Verwendung eines RowMappers den Farmer.
5. Wir benötigen nun eine Auflistung aller Farmer. Ermittle unter Verwendung eines RowMappers alle Farmer.

Ob du die Aufgaben korrekt gelöst hast, erfährst du, wenn du die Tests in der Klasse `ApplicationTest` ausführst und
diese erfolgreich durchlaufen.