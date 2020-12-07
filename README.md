# ueb6-docker-demo
Simpler REST-Service in Java + Spring Boot, um die Nutzung von Docker zu demonstrieren

## Inhalt
Das Repository nutzt **Spring Boot**, um mit minimalstem Aufwand einen primitiven REST-Service aufzusetzen, sowie
**Lombok**, um Getter- & Setter-Methoden automatisch zu generieren.

Die Anwendung stellt ein Repository von Objekten als HATEOAS-Hypermedia unter `localhost:8080` bereit: Wird diese Seite
z.B. mit Firefox aufgerufen, sollte das Ergebnis ein JSON-Baum mit Links zu anderen Orten in der Anwendung sein.

Die Objekte, die in dieser App verwaltet werden, sind `UserProfile`s. Zu finden unter `localhost:8080/users`,
sind in der Datenbank beispielhaft einige Nutzer bereits enthalten. Mit REST-Methoden können natürlich auch
Änderungen vorgenommen werden.

Der Zweck dieses Codes ist einfach nur, dass der im nächsten Schritt anzulegende Docker-Container auch etwas interessantes tut.
Falls dennoch Interesse an den hier verwendeten Konzepten aufkommt, stehe ich natürlich für Fragen zur Verfügung.

## Installation & Erstellen eines Docker-Images
1. `./mvnw install` weist das Maven-Buildsystem an, alle nötigen Abhängigkeiten herunterzuladen
   und das Programm zu kompilieren.  
   Das Ergebnis ist eine JAR-Datei in `./target`.
2. `docker build -t ueb4-docker-demo .` erstellt ein neues Docker-Image aus dem aktuellen Ordner (`.`),  
   mit dem Namen `ueb4-docker-demo`.
3. `docker run -p 8080:8080 ueb4-docker-demo` erzeugt einen neuen Container, der das gerade erstellte
   Image abbildet, und führt ihn aus.  
   Zu beachten ist `-p 8080:8080`: Dieses Flag weist Docker an, den Netzwerkport 8080 der echten Maschine auf den
   Netzwerkport 8080 des Containers zu mappen; nur so kann unsere Java-App weiterhin auf Netzwerkanfragen reagieren.
4. Beachte auch, dass der Realport nicht mit dem Container-Port übereinstimmen muss: Parallel zum laufenden Container
   kann man mit `docker run -p 420:8080 ueb4-docker-demo` einen äquivalenten Container erstellen, der aber auf
   Anfragen an Port 420 hört. Docker ermöglicht solch dynamisches Mapping, ohne den Programmcode ändern zu müssen.

## Multi-Container-Deployment
Standardmäßig verwendet die Anwendung eine In-Memory Datenbank. Um die Konzepte von Docker Compose
und das Zusammenspiel von Anwendungen mit mehreren Containern zu demonstrieren, wird als Datenbank jetzt ein
externer PostgreSQL-Container verwendet.

Die Konfigurationsdatei `docker-compose.yml` wird in der Übung genauer erklärt; dank dieser Vorkonfiguration ist
zum Aufsetzen der Anwendung nur der Befehl `docker-compose up` nötig.