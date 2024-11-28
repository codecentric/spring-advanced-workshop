# Spring AOP (Aspect Oriented Programming)

Das Ziel dieser Übung soll es sein die Konzepte des Aspect Oriented Programmings (AOP) in Spring zu verstehen und
anzuwenden, Methodenaufrufe zu loggen und die Performance zu überwachen sowie Logs zur Fehlerbehandlung zu
implementieren.

## Aufgabe 1

1. Schaue dir den `FarmService` genauer an und mache dich mit der Geschäftslogik vertraut. Es soll im Folgenden darum
   gehen zu den hier implementierten Methoden Aspekte zu definieren.
2. Im `LoggingAspect` soll nun ein Aspekt implementiert werden, der **vor** jedem Methodenaufruf im Package
   `de.codecentric.app` die Ausführung dieser Methode loggt.
3. Ein weiterer Aspekt soll dazu dienen, **nach** jedem Methodenaufruf im Package `de.codecentric.app` die Ausführung
   der Methode zu loggen.
4. Nun implementieren wir ein Performance-Logging. Erstelle dazu einen Aspekt, der für Methoden in der Klasse
   `FarmService` die Zeit von Beginn bis Ende der Ausführung misst und die Dauer als Log ausgibt.

Ob du die Aufgaben korrekt gelöst hast, erfährst du, wenn du die Tests in der Klasse `FarmServiceTest` ausführst und
diese erfolgreich durchlaufen.

## Bonus

Einen Aspekt zu definieren ist auch hilfreich, wenn Fehler entsprechend behandelt werden sollen.

1. Implementiere einen Aspekt der **nach** Werfen einer Exception einen Error, unter Angabe des Methodennamens und der
   Fehlermeldung, loggt. 

Ob du die Aufgaben korrekt gelöst hast, erfährst du, wenn du den zusätzlichen Test in der Klasse `ApplicationTest` ausführst und
dieser erfolgreich durchläuft.