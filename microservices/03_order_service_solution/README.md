# Spring und Feign Client

Ziel der Übung soll es sein, eine Kommunikation zwischen unseren zwei Microservices `FieldService` und `OrderService`
über den Feign Client herzustellen.

## Voraussetzungen

- Übung zu **Microservices** ist bereits absolviert worden

## Aufgabe 1: Implementierung Feign Client

1. Füge dem Interface `FieldClient` die notwendige Annotation hinzu, um es als Feign Client zu kennzeichnen. Der
   übergebene Name für den Feign Client muss mit der ID übereinstimmen, die wir unserem `FieldService` in der
   Konfiguration unseres API-Gateways als ID hinterlegt haben.
2. Unser `FieldClient` benötigt nun eine Methode, die äquivalent zu der Methode im `FieldController` mittels der ID ein
   Field abfragt. Annotiere die Methode wie im Controller mit `@GetMapping`.
3. Nun wollen wir mithilfe des `FieldClients` bei Erstellung einer Bestellung im `OrderController` prüfen, ob es zu der
   übergebenen ProductId im übergebenen Order-Objekt ein zugehöriges Field gibt und als Productname in der Order der
   CropType des Fields gesetzt werden.

## Aufgabe 2: Implementierung eines Error Decoders

Aber was passiert, wenn kein Field mit der übergebenen ID gefunden werden kann? Dann bekommen wir einen Fehler aus
dem FeignClient. Das ist natürlich unschön und wir wollen am liebsten eine fachliche Meldung zurückgeben. Dazu
benötigen wir einen **ErrorDecoder**.

1. Sorge dafür, dass die Klasse `FieldClientErrorDecoder` das Interface `ErrorDecoder` implementiert und als Spring Bean
   zur Verfügung steht.
2. Nun implementiere die Methode `decode`, indem du prüfst, ob der Status des Response = "Not Found" entspricht und
   werfe
   in diesem Fall eine `FieldNotFoundException`.
3. Der `GlobalExceptionHandler` wird sich dann darum kümmern diese Exception global in einen Response mit dem Status
   "404 - Not Found" zu transformieren.

## Testen der Anwendung

Starte den Eureka Server, das API-Gateway und die Microservices.
Du findest unter `localhost:8761/` die Konsole des Eureka-Servers, wo du den aktuellen Systemstatus sowie die
registrierten Services einsehen kannst.

Stelle sicher, dass sich alle Dienste beim Eureka Server registrieren.

Du kannst über das API-Gateway nun auch auf die folgenden Endpunkte zugreifen. Prüfe, z.B. mittels Postman, ob die
Endpunkte aufrufbar sind.

- http://localhost:8080/fields
- http://localhost:8080/orders

Versuche nun eine neue Bestellung anzulegen und übergib im Body eine ProductId, zu der ein Field existiert und versuche
eine anzulegen mit einer ProductId, zu der kein Field existiert. Es sollte nun anstelle des FeignClient-Fehlers die von
dir angegebene Fehlermeldung angezeigt werden mit dem HTTP-Status "404 Not Found".