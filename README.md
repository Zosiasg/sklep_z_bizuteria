# sklep_z_bizuteria
Dokumentacja projektu
Sparkling Horizons: Sklep internetowy z biżuterią 
Autorzy: [Zofia Syrek-Gerstenkorn, Alena Mikhalkiewicz] Data: [06.06.2023]

Wprowadzenie
Projekt "Sklep internetowy z biżuterią" jest aplikacją internetową, która umożliwia użytkownikom przeglądanie  i zakup biżuterii. Aplikacja została napisana w języku Java przy użyciu środowiska IntelliJ IDEA. Wykorzystane technologie to Spring (Spring Boot, Spring MVC) do implementacji warstwy webowej, Hibernate jako framework ORM oraz Thymeleaf jako silnik szablonów.
Uruchamianie projektu:
Aby uruchomić projekt, postępuj zgodnie z poniższymi krokami:
1.	Sklonuj repozytorium projektu na swój lokalny system.
2.	Otwórz projekt w IntelliJ IDEA.
3.	Skonfiguruj połączenie z bazą danych MS SQL Server, dostosowując parametry połączenia w pliku konfiguracyjnym ( application.properties).
4.	Uruchom projekt, a następnie przejdź do wybranej przeglądarki localhost:8080

Wykorzystane biblioteki:
•	Spring Boot: Framework Java, który ułatwia tworzenie aplikacji webowych.
•	Spring MVC: Warstwa kontrolerów i widoków w frameworku Spring.
•	Hibernate: Framework ORM do mapowania obiektowo-relacyjnego.
•	Thymeleaf: Silnik szablonów służący do generowania dynamicznych widoków HTML.
•	MS SQL Server: System zarządzania bazą danych relacyjnych wykorzystany jako baza danych w projekcie.

Strona dla użytkownika:
Aplikacja "Sklep internetowy z biżuterią" zawiera stronę dla użytkownika, która umożliwia logowanie i przeglądanie asortymentu sklepu. Aby przejść do strony logowania, należy wpisać w pasku wyszukiwarki adres: http://localhost:8080/login. Na tej stronie użytkownik ma możliwość wprowadzenia swoich danych logowania.
Jeśli użytkownik odwiedza stronę po raz pierwszy, ma możliwość przejścia do strony rejestracji, gdzie może utworzyć nowe konto użytkownika.
Po pomyślnym zalogowaniu, użytkownik zostaje przekierowany na stronę sklepu internetowego z biżuterią, gdzie może przeglądać dostępne produkty. Użytkownik ma możliwość dodawania wybranych produktów do koszyka.
Po przejściu do koszyka, użytkownik widzi podsumowanie zamówienia oraz ma możliwość modyfikacji zamówienia. Może zwiększyć lub zmniejszyć ilość produktów w koszyku lub usunąć wybrane pozycje. Po kliknięciu przycisku "Dalej", użytkownik przechodzi do strony podsumowania, gdzie wprowadza swoje dane w celu zrealizowania zamówienia. Zamówienie zostaje zapisane w bazie danych.
Panel administratora:
Aplikacja zawiera również panel dla administratora strony. Po przejściu do strony http://localhost:8080/ItemIndex, administrator ma możliwość edycji asortymentu sklepu. Może edytować istniejące pozycje biżuterii, usunąć je lub dodać nowe pozycje.
Dzięki temu panelowi administrator ma pełną kontrolę nad asortymentem sklepu i może aktualizować go zgodnie z bieżącymi potrzebami.


Historia zmian projektu:
Wersja 1.0 
•	Inicjalna wersja projektu.
•	Dodano strukturę projektu i skonfigurowano środowisko IntelliJ IDEA.
•	Stworzono podstawowe modele danych dla użytkowników, produktów i zamówień.
•	Utworzono formularze logowania i rejestracji użytkowników.
•	Zaimplementowano funkcję dodawania produktów do koszyka.
Wersja 1.1 
•	Ulepszono wygląd strony logowania i rejestracji.
•	Poprawiono błędy związane z manipulacją zawartością koszyka.
Wersja 1.2 
•	Wprowadzono integrację z bazą danych MS SQL Server.
•	Utworzono tabelę "users" w bazie danych i zaimplementowano mechanizm zapisu użytkowników do bazy.
•	Dodano możliwość pobierania listy produktów z bazy danych i wyświetlania ich na stronie sklepu.
Wersja 1.3 
•	Zaimplementowano funkcję modyfikacji koszyka - możliwość zmiany ilości produktów oraz usuwania pozycji z koszyka.
•	Dodano stronę podsumowania zamówienia, gdzie użytkownik może wprowadzić dane do zrealizowania zamówienia.
Wersja 1.4 
•	Dodano panel administratora strony.
•	Stworzono stronę dla administratora umożliwiającą edycję asortymentu sklepu.
•	Zaimplementowano funkcje dodawania, edycji i usuwania produktów przez administratora.
•	Poprawiono wygląd strony sklepu i panelu administratora.

