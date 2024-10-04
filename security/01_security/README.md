# Spring Security

Wir wollen die Webanwendung absichern und den Zugriff auf bestimmte Rollen beschränken.
## Aufgabe 1

1. Starten Sie die Anwendung und öffnen Sie den Browser. Oh, haben wir Zugriff? Wir wollen die Webanwendung nutzen!
2. Erstellen Sie zwei Benutzer in der UserDetailsService-Bean. Tipp: Verwenden Sie den InMemoryUserDetailsManager.
   Ein Benutzer sollte die Rolle "USER" und ein anderer die Rolle "ADMIN" haben.
3. Konfigurieren Sie, dass der Zugriff auch ohne Login auf die statischen Ressourcen, die URLs "/" und "/index" funktioniert.
4. Erlauben Sie den Zugriff auf "/farmer/index" nur Benutzern mit der Rolle "USER" und auf "/farmer/edit" nur Benutzern mit der Rolle "ADMIN".
   Jede andere Anfrage sollte authentifiziert werden.
 
## Bonus

1. Wir wollen die benutzerdefinierte Login-Seite verwenden, nach erfolgreichem Login zu "/farmer/index" weiterleiten und im Falle eines Fehlers zu "/login-error".
2. Wir wollen uns abmelden und die aktuelle Sitzung für ungültig erklären, den "JSESSIONID"-Cookie löschen und nach "/" weiterleiten.
3. Debug-Informationen aktivieren - was können Sie sehen?
