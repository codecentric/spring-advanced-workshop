# Microservices mit Spring
 Ziel ist es eine Farm-Verwaltungsplattform zu entwickeln, bestehend aus mehrere Microservices. 

 Die Plattform umfasst die folgenden Komponenten:

 1. **Field Service**: Verwaltung der Felder und angebauten Pflanzen. 
 2. **Order Service**: Verwaltung der Bestellungen für Farmprodukte.
 3. **Eureka Server** als Service Discovery: Ermöglicht dynamische Service-Lokalisierung.
 4. **Spring Cloud Gateway** als API Gateway: Routing und zentraler Zugangspunkt.

## Aufgabe 1: Konfiguration der Service Discovery mit Eureka
Im Ordner `01_eureka_server` findest du bereits das Grundgerüst für unseren Eureka Server.

1. Füge der Hauptklasse die notwendige Annotation hinzu, um unsere Anwendung als Eureka Server zu kennzeichnen.
2. Füge die folgenden Zeilen der `application.yml` hinzu. Sie dient dazu, dass sich der Eureka Server nicht bei einem anderen Eureka Server registriert und keine Registry-Informationen von einem anderen Server abruft.

```yml
eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
```

## Aufgabe 2: Implementierung der Microservices
Schaue in den Ordner `02_field_service`. Dort findest du bereits ein Spring Boot-Projekt für unseren `Field Service`. Es ist bereits eine JPA-Entität für ein Feld definiert. 

1. Implementiere im `FieldController` eine Methode, die per HTTP-Methode GET alle Felder, eine Methode, die mit der ID ein einzelnes Feld zurückgibt und eine Methode mit POST die der Erstellung eines Feldes dienen soll. 
2. Damit unser Microservice sich beim Eureka Server registrieren kann, benötigen wir noch die Konfiguration in der `application.yml`. Füge hier die folgende Konfiguration hinzu:
```yml
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

Nun haben wir unseren ersten Microservice entwickelt.

Da ein Microservice selten allein kommt, wollen wir einen zweiten Microservice implementieren, der sich um die Verwaltung der Bestellungen unserer Produkte kümmert. Schaue hierzu in den Ordner `03_order_service`.

3. Implementiere unsere JPA-Entität `Order` indem du ihr Attribute hinzufügst, damit der Produktname als `String`, die Product Id als `Long` und die Quantity als `int` gespeichert werden können.
4. Im `OrderController` wird nun eine Methode benötigt um alle Bestellungen abzuholen und eine um eine Bestellung anzulegen.

## Aufgabe 3: API-Gateway konfigurieren mit Spring Cloud Gateway
Das API-Gateway dient als Anlaufstelle für den Client, um Anfragen an den entsprechenden Microservice weiterzuleiten. Dafür benötigen wir einige Konfiguration.

1. Ergänze die `application.yml` um die Konfiguration unserer Routes, die dafür sorgen, dass Requests an einen bestimmten Pfad auch am richtigen Microservice landen. Für den Field Service sähe die Konfiguration wie folgt aus:
```yml
spring:
  cloud:
    gateway:
      routes:
        - id: field-service
          uri: lb://field-service
          predicates:
            - Path=/fields/**
```
Dabei entspricht die `uri` dem Namen unseres Microservices, wie wir in in der application.yml unter `spring.application.name=field-service` definiert haben.
Die eindeutige ID wird benötigt um bspw. im FeignClient den richtigen Service anzusprechen. 
Bei den Predicates kann angegeben werden, welche Requests an diesen Service weitergeleitet werden.

## Testen der Anwendung
Starte den Eureka Server, das API-Gateway und die Microservices.
Du findest unter `localhost:8761/` die Konsole des Eureka-Servers, wo du den aktuellen Systemstatus sowie die registrierten Services einsehen kannst.

Stelle sicher, dass sich alle Dienste beim Eureka Server registrieren.

Du kannst über das API-Gateway nun auch auf die folgenden Endpunkte zugreifen. Prüfe, z.B. mittels Postman, ob die Endpunkte aufrufbar sind.

- http://localhost:8080/fields
- http://localhost:8080/orders

## Bonus: Dein eigener Microservice

1. Erstelle deinen eigenen Microservice. Erstelle hierfür ein neues Spring-Boot-Projekt mit dem Spring Initalizr. Du kannst dies direkt in IntelliJ nutzen oder du nutzt https://start.spring.io/ und lädst dir das Projekt runter. Du brauchst dafür die Abhängigkeiten zu JPA, Web und Eureka.
2. Nun kannst du dir überlegen, was dein Microservice machen soll. Vielleicht wird es ein AnimalService, der Tiere auf unserer Farm verwaltet?
3. Dein Microservice muss nun wissen, wo der Eureka Server liegt, bei dem er sich registrieren kann. Passe die Konfiguration in der `application.yml` an, äquivalent zu den anderen Microservices.
4. Dein API-Gateway benötigt außerdem die Information darüber, wo er Requests hin routen soll, die an deinen neuen Microservice gehen sollen. Ergänze im API-Gateway eine Route für deinen neuen Service.

Wenn du nun alle deine Komponenten startest, kannst du überprüfen, ob sich dein neuer Microservice am Eureka-Server registriert hat.

Du kannst über das API-Gateway nun auch deinen, im API-Gateway, definierten Endpunkt aufrufen. 

