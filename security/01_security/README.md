# Spring Security

Wir wollen die Webanwendung absichern und den Zugriff auf bestimmte Rollen beschränken.

## Aufgabe 1

1. Starte die Anwendung und öffnen Sie den Browser. Oh, haben wir Zugriff? Wir wollen die Webanwendung nutzen!
2. Erstelle zwei Benutzer in der UserDetailsService-Bean. Tipp: Verwende dafür den InMemoryUserDetailsManager.
   Ein Benutzer sollte die Rolle "USER" und ein anderer die Rolle "ADMIN" haben.
3. Konfiguriere, dass der Zugriff auch ohne Login auf die statischen Ressourcen, die URLs "/" und "/index" funktioniert.
4. Erlaube den Zugriff auf "/farmer/index" nur Benutzern mit der Rolle "USER" und auf "/farmer/edit" nur Benutzern mit
   der Rolle "ADMIN".
   Jede andere Anfrage sollte authentifiziert werden.

## Bonus

1. Wir wollen die benutzerdefinierte Login-Seite verwenden, nach erfolgreichem Login zu "/farmer/index" weiterleiten und
   im Falle eines Fehlers zu "/login-error".
2. Wir wollen uns abmelden und die aktuelle Sitzung für ungültig erklären, den "JSESSIONID"-Cookie löschen und nach "/"
   weiterleiten.
3. Auf "/status" sollen nur Benutzer mit der Rolle "USER" zugreifen können. Nutze hierfür die Methoden-Autorisierung
   mithilfe der Annotationen.
4. Schreibe zwei Testfälle: Einen der überprüft, dass nur Benutzer mit der Rolle "USER" auf "/status" zugreifen können
   und einen anderen, der prüft, dass bei Zugriff durch einen anonymen Benutzer (Tipp: @WithAnonymousUser) eine
   AuthorizationDeniedException geworfen wird. 
