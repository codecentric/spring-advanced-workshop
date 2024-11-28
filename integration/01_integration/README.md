# Spring Integration

Ziel dieser Übung ist es, eine Spring Integration-Anwendung zu entwickeln, die eine Nachricht von einem Eingangskanal
empfängt, diese Nachricht verarbeitet und dann die verarbeitete Nachricht an einen Ausgangskanal sendet.

## Aufgabe 1

1. Zunächst definieren wir die Nachrichtenkanäle. Implementiere hierzu in der `IntegrationConfig` zwei `DirectChannel`
   -Beans für den `inputChannel` und den `outputChannel`.
2. Im `MessageService` wollen wir nun eine Methode zur Verarbeitung der Nachricht implementieren. Die Nachricht soll in
   Großbuchstaben ausgegeben werden.
3. Nun müssen wir den IntegrationFlow definieren, der Nachrichten vom `inputChannel` empfängt, durch den
   `MessageService` verarbeitet und dann an den `OutputChannel` sendet.
4. Implementiere das Interface `MessageHandler` in unserer Klasse `OutputHandler`. Unser MessageHandler soll Nachrichten
   vom `outputChannel`empfangen und den Inhalt der Nachricht als Log ausgeben.

Ob du die Aufgaben korrekt gelöst hast, erfährst du, wenn du die Tests in der Klasse `IntegrationConfigTest` ausführst
und diese erfolgreich durchlaufen.

## Bonusaufgabe

Ziel ist es, eine Filter-Komponente hinzuzufügen, die nur Nachrichten, deren Länge größer als 5 Zeichen ist, an den
outputChannel weiterleitet.

1. Definiere zunächst zwei neue Nachrichtenkanäle, einen Input und einen OutputChannel.
2. Füge dann einen IntegrationFlow hinzu, welcher einen Filter enthält, der Nachrichten basierend auf der Länge ihres
   Textinhalts filtert. Nachrichten mit weniger oder gleich 5 Zeichen werden verworfen. Füge den Filter nach dem
   Transformer, aber vor dem `outputChannel` ein. Vergesse nicht den OutputHandler!
3. Schreibe eine neue Testklasse mit Testmethoden, die sicherstellen, dass Nachrichten, die die Filterbedingung nicht
   erfüllen, nicht
   weitergeleitet werden. Überprüfe auch, dass Nachrichten, die die Bedingung erfüllen, korrekt verarbeitet werden.