# Spring und Transaktionen

In dieser Übung entwickeln wir eine Anwendung zur Verwaltung von Bauernhöfen entwickeln. Das Ziel ist es, eine Funktion
zur Übertragung von Produkten zwischen Bauernhöfen zu implementieren,
wobei das Transaktionsmanagement verwendet wird, um die Integrität der Daten sicherzustellen.

## Aufgabe 1

1. Mache dich mit dem existierenden Modell im package `de.codecentric.app.model` vertraut.
2. Im `FarmService` wollen wir nun die eigentliche Geschäftslogik implementieren. Implementiere hierzu die Methode
   `transferProducts`, die Produkte zwischen zwei Bauernhöfen überträgt. Diese Methode sollte sicherstellen, dass die
   Transaktion erfolgreich abgeschlossen oder bei einem Fehler vollständig zurückgesetzt wird. Verwende die `
   @Transactional-Annotation, um das Transaktionshandling zu aktivieren.
3. Werfe eine `ProductNotAvailableException`, wenn das Produkt im Ausgangsbauernhof nicht verfügbar ist, oder die Produktmenge nicht ausreicht.

Ob du die Aufgaben korrekt gelöst hast, erfährst du, wenn du die Tests in der Klasse `ApplicationTest` ausführst und
diese erfolgreich durchlaufen.

## Bonus
Implementiere eine Methode `transferProductsWithException`, um ein Fehler-Szenario zu simulieren und so die Rücknahme der Transaktion zu testen.

##  Hilfestellung (Achtung: Spoiler!)
Für die Übertragung der Produkte von einem Bauernhof zum anderen sind die folgenden Schritte notwendig:
- Überprüfe, ob das Produkt im Ausgangsbauernhof vorhanden ist.
- Überprüfe, ob die angegebene Menge des Produkts im Ausgangsbauernhof vorhanden ist.
- Wenn beides erfüllt ist, reduziere die Menge des Produkts im Ausgangsbauernhof.
- Überprüfe, ob das Produkt im Zielbauernhof vorhanden ist.
- Wenn ja, erhöhe die Menge des Produkts um die angegebene.
- Wenn nicht, erzeuge ein neues Produkt mit der angegebenen Menge.
- Speichere beide Bauernhöfe.