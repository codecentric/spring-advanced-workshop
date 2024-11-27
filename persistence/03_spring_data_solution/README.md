# Spring Data JPA

## Aufgabe 1

1. Zunächst müssen wir dafür sorgen, dass unsere Klasse `Farmer` als Entität erkannt wird. Annotiere hierfür die Klasse
   mit JPA-Annotationen, damit sie persistiert werden kann.
2. Starte die Anwendung. Öffne die H2-Konsole unter `localhost:8080/h2-console`. Nutze die Informationen aus der Konsole
   um die korrekte Datenbank-URL und die `application.properties` um Username und Password herauszufinden.

Wenn du die Entity korrekt annotiert hast, solltest du in deiner Datenbank in der Tabelle `Farmers` zwei Einträge finden.

## Aufgabe 2

1. Damit wir die Spring-Magie für die Abfrage unserer Datenbanktabellen nutzen können, muss das `FarmerRepository` vom
   korrekten Spring Data JPA-Interface erben.
2. Wir wollen einzelne Farmer finden, indem wir nach ihrem Nachnamen suchen. Schreibe im `FarmerRepository` eine Query,
   welche dir für den Nachnamen einen Farmer zurückgibt.
3. Schreibe im `FarmerService` Methoden um alle Farmer abzufragen und um einen Farmer mit seinem Nachnamen zu finden.

Ob du die Aufgaben korrekt gelöst hast, erfährst du, wenn du die Tests in der Klasse `ApplicationTest` ausführst und
diese erfolgreich durchlaufen.