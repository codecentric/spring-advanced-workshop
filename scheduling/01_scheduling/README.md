# Spring und Quartz (Scheduling)

Das Ziel dieser Übung ist es, die Konfiguration des Quartz Schedulers in einer Spring Boot Anwendung zu implementieren.

## Aufgabe 1

Du findest im `FeedAnimalsJob` bereits die Implementierung eines Quartz Jobs, welcher dazu gedacht ist eine
Konsolenausgabe zu machen, dass die Fütterung der Tiere zum aktuellen Zeitpunkt stattfindet.

1. Damit dieser Job ausgeführt wird, müssen wir den Job in der `QuartzConfig` als JobDetail zur Verfügung stellen.
2. Erstelle einen Trigger in der Klasse `FeedAnimalsTrigger`, welcher für die Ausführung des JobDetails zuständig ist.
   Der Job soll alle 3 Sekunden ausgeführt werden.
3. In der Klasse `QuartzSchedulerConfig` passen wir die `SchedulerFactoryBean` nun so an, dass die JobDetails und der
   Trigger miteinander verknüpft werden.

Überprüfe die Konsolenausgabe, ob der Job zu den geplanten Zeiten ausgeführt worden ist.

## Bonus

Neben dem SimpleTrigger ist es auch möglich einen CronTrigger mit einer Cron Expression anzugeben.
Die Dokumentation zum CronTrigger für die notwendige Cron Expression kannst du hier
finden: https://www.quartz-scheduler.org/documentation/quartz-2.3.0/tutorials/crontrigger.html

1. Erstelle einen neuen Job, welcher eine Logausgabe macht mit der aktuellen Temperatur. Hierzu kannst du die Methode
   `CheckTemperatureJob#getFarmTemperature()` nutzen.
2. In der `QuartzConfig` wird nun ein weiteres JobDetail benötigt, welches als Typ unseren neu erstellten Job
   bekommt.
3. Erstelle eine neue Klasse, in der du den CronTrigger implementierst. Die Ausführung soll jede Minute passieren.
4. In der Klasse `QuartzSchedulerConfig` kannst du nun die `SchedulerFactoryBean` um das JobDetail und den Trigger zu
   ergänzen.

Überprüfe die Konsolenausgabe, ob der Job zu den geplanten Zeiten ausgeführt worden ist.