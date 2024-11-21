# Spring und Konfigurationen

Die Übung zielt darauf ab, die verschiedenen Konfigurationsmechanismen von Spring zu verstehen und anzuwenden,
insbesondere die Nutzung von @ConfigurationProperties, @Value, und Environment. Außerdem sollen Umgebungsvariablen und
Kommandozeilenargumente (CLI) verwendet und über Tests überprüft werden.

Eine einfache Anwendung modelliert eine Farm mit verschiedenen Tieren. Zu den Tieren ist nur die Anzahl dieser
konfigurierbar.

## Aufgabe 1

1. Schaue dir die `FarmConfig` an. Ergänze in der `application.properties` die notwendige Konfiguration für die hier
   angegebenen Felder.
2. Ergänze die `FarmConfig`, um auf die Konfigurationswerte zuzugreifen. Nutze hierfür die Möglichkeit auf Klassenebene,
   du brauchst dafür nur eine einzige Annotation!
3. Ergänze und passe den `FarmConfigServiceTest` an, sodass du deine angegebene Konfiguration vollständig abgetestet
   hast.

Ob du die Aufgaben korrekt gelöst hast, erfährst du, wenn du die Tests in der Klasse `FarmConfigServiceTest` ausführst
und diese erfolgreich durchlaufen.

## Aufgabe 2

Nun wollen wir die @Value-Annotation nutzen, um Konfiguration zu laden und uns profilspezifische Konfigurationsdateien
anschauen.

1. Schaue in den `FarmValueService` und implementiere die durch das Interface `FarmService` vorgegebenen Methoden.
   Natürlich soll auch hier auf die Konfiguration zugegriffen werden. Nutze jedoch nicht die Klasse `FarmConfig`.
2. Erstelle eine profilspezifische Properties-Datei, im selben Ordner, in dem die `application.properties` liegen.
3. Aktiviere im `FarmValueServiceTest` das Profile mittels Annotation auf Klassenebene.
4. Ergänze die Testklasse, sodass du deine angegebene Konfiguration vollständig abgetestet hast.

Ob du die Aufgaben korrekt gelöst hast, erfährst du, wenn du die Tests in der Klasse `FarmValueServiceTest` ausführst
und diese erfolgreich durchlaufen.

## Aufgabe 3

Zu guter Letzt wollen wir uns das, durch Spring zur Verfügung gestellte, `Environment`-Interface näher anschauen und
mithilfe dessen die Konfigurationsdaten laden.

1. Schaue in den `FarmEnvironmentService` und implementiere die durch das Interface `FarmService` vorgegebenen Methoden.
   Natürlich soll auch hier auf die Konfiguration zugegriffen werden. Nutze jedoch dieses Mal das `Environment`
   -Interface, indem du es als Bean einbindest.
2. Erstelle noch eine profilspezifische Properties-Datei, im selben Ordner, in dem die `application.properties` liegen.
3. Aktiviere im `FarmEnvironmentServiceTest` das Profile mittels Annotation auf Klassenebene.
4. Ergänze die Testklasse, sodass du deine angegebene Konfiguration vollständig abgetestet hast.

Ob du die Aufgaben korrekt gelöst hast, erfährst du, wenn du die Tests in der Klasse `FarmEnvironmentServiceTest`
ausführst
und diese erfolgreich durchlaufen.

## Bonus #1

Das Ziel der Bonusaufgabe besteht darin auch die Möglichkeiten der Konfiguration mittels Kommandozeilenargumenten auszuprobieren.

1. Ergänze die Testklasse `ApplicationCommandLineTest` um die notwendigen Zeilen, damit die Konfiguration aus der
   Kommandozeile genutzt werden anstelle der Standard-Konfiguration.

## Bonus #2
Nun wollen wir Konfiguration über Umgebungsvariablen mitgeben.

1. Passe die `application.properties` so an, dass Umgebungsvariablen anstelle der Standardkonfiguration genutzt werden können.
2. Ergänze die Testklasse `ApplicationEnvironmentVariablesTest` um die notwendigen Zeilen, damit die Konfiguration aus den Umgebungsvariablen
   genutzt wird.

### Hinweise (Achtung: Spoiler!)

Zu Bonus #1:
- Die Annotation `@SpringBootTest` besitzt einen Parameter `args` zum Mitgeben von Kommandozeilenargumenten im Test.

Zu Bonus #2:
- Der Annotation `@TestPropertySource` können `properties`als Parameter mitgegeben werden.
- Umgebungsvariablen können wie folgt mit Standardwert in der `application.properties` angegeben werden: `app.version=${APP_VERSION:1.0.0}`.
