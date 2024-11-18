# Spring und Exception Handling

In dieser Übung entwickeln wir eine Anwendung zur Verwaltung von Tieren entwickeln. Das Ziel ist die Implementierung des
Exceptions Handlings auf Controller-Ebene.

## Aufgabe 1

1. Im `AnimalService` wollen wir nun die eigentliche Geschäftslogik implementieren. Implementiere hierzu Methoden um
   eine Liste aller Tiere zu bekommen, ein Tier anzulegen und zu löschen und einzelne Tiere mit der ID abzufragen.
2. Werfe eine `AnimalNotFoundException`, wenn kein Tier mit der angegebenen ID existiert.
3. Falls ein Tier gelöscht werden soll, welches nicht existiert, soll ebenfalls eine `AnimalNotFoundException` geworfen
   werden.
4. Nun wollen wir erreichen, dass die `AnimalNotFoundException` global behandelt wird. Implementiere die Behandlung
   hierfür im `GlobalExceptionHandler`. Wenn ein Tier nicht gefunden werden kann, soll als Rückmeldung der HTTP-Status
   "404 - Not Found" gesendet werden.

Ob du die Aufgaben korrekt gelöst hast, erfährst du, wenn du die Tests in der Klasse `ApplicationTest` ausführst und
diese erfolgreich durchlaufen.

## Aufgabe 2

Nun soll es darum gehen, dass wir Exceptions behandeln, die spring-spezifisch sind.
1. Lasse den `GlobalExceptionHandler` die Klasse `ResponseEntityExceptionHandler` erweitern.
2. Überschreibe die Methode `handleHttpMessageNotReadable()` und gebe neben einer Fehlermeldung den HTTP-Status "400 - Bad Request" zurück.
3. Schreibe einen Test, der bei der fehlerhaften Eingabe eines Tiertyps den erwarteten HTTP-Status zurückgibt.

## Bonus

Das Ziel der Bonusaufgabe besteht darin sicherzustellen, dass ein Tier in unserer Verwaltung korrekt angelegt wird.

1. Wenn ein Tier ohne Namen angelegt wird, soll eine Exception geworfen werden. Implementiere die Exception und werfe
   sie im entsprechenden Fall.
2. Ergänze den `GlobalExceptionHandler` um die Behandlung der eben implementierten Exception. Wenn diese geworfen wird,
   soll als Antwort der HTTP-Status "400 - Bad Request" zurückgegeben werden.
3. Implementiere den Testfall `testInvalidAnimalData()` in der Klasse `ApplicationTest` um die Funktionalität der
   Fehlerbehandlung sicherzustellen.
