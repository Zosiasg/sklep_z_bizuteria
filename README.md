Dokumentacja projektu
Sparkling Horizons: Sklep internetowy z biżuterią 
Autorzy: [Zofia Syrek-Gerstenkorn, Alena Mikhalkevich] Data: [06.06.2023]

Wprowadzenie
Projekt "Sklep internetowy z biżuterią" jest aplikacją internetową, która umożliwia użytkownikom przeglądanie  i zakup biżuterii. Aplikacja została napisana w języku Java przy użyciu środowiska IntelliJ IDEA. Wykorzystane technologie to Spring (Spring Boot, Spring MVC) do implementacji warstwy webowej, Hibernate jako framework ORM oraz Thymeleaf jako silnik szablonów.
Uruchamianie projektu:
Aby uruchomić projekt, postępuj zgodnie z poniższymi krokami:
1.	Sklonuj repozytorium projektu na swój lokalny system.
2.	Otwórz projekt w IntelliJ IDEA.
3.	Skonfiguruj połączenie z bazą danych MS SQL Server, dostosowując parametry połączenia w pliku konfiguracyjnym ( application.properties). Tabele danych potrzebne dla funkcjonowania aplikacji zostaną utworzone automatycznie przy jej pierwszym uruchomieniu.
4.	Uruchom projekt, a następnie przejdź do wybranej przeglądarki. Strona główna aplikacji (wyświetlanie listy produktów dostępnych w sklepie i dodawanie ich do koszyka) jest dostępna pod adresem localhost:8080. Strona główna dla administratora (umożliwiająca oglądanie i modyfikowanie listy produktów) jest dostępna pod adresem localhost:8080/ItemIndex. Aby przejść do strony logowania/rejestracji, należy wpisać w pasku wyszukiwarki adres: http://localhost:8080/login.

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

Opis klas i metod
W folderze model zawarte są klasy definiujące struktury danych (tabele w bazie danych) używane w projekcie:
•	Item – tabela przechowująca pozycje asortymentu
•	User – tabela przechowująca identyfikatory użytkowników i ich zaszyfrowane hasła 
•	Order – zawiera zamówienia (wraz z danymi do wysyłki) 
•	OrderItem – tabela zawierająca powiązania pomiędzy zamówieniami i pozycjami asortymentu

Folder repository zawiera definicje interfejsów do używanych struktur danych rozszerzające interfejs JpaRepository z biblioteki Spring Data JPA w celu umożliwienia wykorzystania podstawowych metod do wykonywania operacji na bazie danych. 

Folder controllers zawiera definicje klas obsługujących akcje takie jak wyświetlanie stron oraz edytowanie danych dotyczących zamówień i pozycji asortymentu administratora.

AdminController:
1.	Metoda ShowCreateItemForm – wyświetla formularz (adminview/addItem) do wprowadzenia nowej pozycji asortymentu,
2.	Metoda addItem- zapisuje nowy produkt do bazy danych,
3.	Metoda showOrders - zwraca listę wszystkich zamówień, 
4.	Metoda deleteItem- usuwa element o podanym identyfikatorze z koszyka zamówień

ItemController:
Kontroler ItemController zawiera metody służące do zarządzania asortymentem sklepu -  
1.	Metoda showItemsList- obsługuje wyświetlanie listy produktów (w formularzu adminview/ItemIndex),
2.	Metoda deleteItem- umożliwia usuwanie produktów,
3.	Metoda showUpdateForm – wyświetla formularz (adminview/updateItem) do edycji wybranej pozycji asortymentu.
4.	Metoda updateItem – zapisuje zmodyfikowaną pozycję do bazy danych

HomeController:
1.	Metoda home- pobiera listę wszystkich produktów i przekazuje ją do strony home.html
2.	Metoda addItemToCart- dodaje wybrany produkt do  koszyka zamówień

OrderController obsługuje wyświetlanie koszyka, zwiększanie i zmniejszanie ilości elementów w koszyku, usuwanie elementów z koszyka, wyświetlanie podsumowania zamówienia oraz zapisywanie zamówienia.
1.	Metoda showCart zwraca widok koszyka (cartView).
2.	Metoda increaseItem zwiększa ilość danego produktu w koszyku. Wywołuje metodę itemOperation na cartService z przekazanym itemId i operacją ItemOperation.INCREASE i zwraca widok koszyka (cartView).
3.	Metoda decreaseItem zmniejsza ilość danego produktu w koszyku. Wywołuje metodę itemOperation na cartService z przekazanym itemId i operacją ItemOperation.DECREASE i zwraca widok koszyka (cartView).
4.	Metoda removeItemsFromCart usuwa dany produkt z koszyka. Wywołuje metodę itemOperation na cartService z przekazanym itemId i operacją ItemOperation.REMOVE i zwraca widok koszyka (cartView).
5.	Metoda showSummary pokazuje podsumowanie koszyka
6.	Metoda saveOrder zapisuje zamówienie

AuthenticationController obsługuje akcje takie jak wyświetlanie formularza logowania, logowanie, wyświetlanie formularza rejestracji oraz rejestrację użytkownika.
1.	Metoda showLoginForm wyświetla formularz do logowania 
2.	Metoda login obsługuje proces logowania. 
•	Przyjmuje parametry username i password przekazane jako parametry żądania.
•	Wywołuje metodę login na authenticationService w celu uwierzytelnienia użytkownika na podstawie podanych danych logowania.
•	Jeśli uwierzytelnienie zakończyło się sukcesem, przekierowuje na ścieżkę "/".
•	W przeciwnym razie, dodaje atrybut "error" do modelu z informacją o błędnych danych logowania i zwraca nazwę widoku "login".
3.	Metoda showRegistrationForm wyświetla formularz do rejestracji nowego użytkownika 
4.	Metoda register obsługuje proces rejestracji nowego użytkownika
•	Przyjmuje parametry username i password przekazane jako parametry żądania.
•	Wywołuje metodę register na authenticationService w celu zarejestrowania nowego użytkownika na podstawie podanych danych rejestracji.
•	Jeśli rejestracja zakończyła się sukcesem, przekierowuje na ścieżkę "/login".
•	W przeciwnym razie, dodaje atrybut "error" do modelu z informacją o zajętej nazwie użytkownika i zwraca nazwę widoku "register".

Folder dto zawiera klasę OrderDto służącą do przenoszenia danych wysyłkowych klienta związanych z zamówieniem z formularza zamówienia do usługi obsługującej zamówienia. 

Folder mapper zawiera klasę OrderMapper, która pełni rolę mapera, który umożliwia konwersję obiektów związanych z zamówieniem na obiekty DTO i odwrotnie. 

Folder service zawiera klasy:
Cart reprezentuje koszyk zakupowy w sklepie internetowym i zapewnia metody do dodawania, usuwania, zmniejszania ilości przedmiotów oraz przeliczania sumy i licznika.
1.	Metoda addItem:
•	Dodaje przedmiot do koszyka.
•	Sprawdza, czy przedmiot jest już w koszyku. Jeśli tak, zwiększa jego licznik. W przeciwnym razie tworzy nowy obiekt CartItem i dodaje go do koszyka.
•	Wywołuje metodę recalculatePriceAndCounter w celu przeliczenia sumy i licznika.
2.	Metoda decreaseItem:
•	Zmniejsza licznik przedmiotu w koszyku.
•	Jeśli licznik spada do zera, usuwa cały przedmiot z koszyka za pomocą metody removeAllItems.
•	W przeciwnym razie wywołuje metodę recalculatePriceAndCounter.
3.	Metoda removeAllItems:
•	Usuwa wszystkie wystąpienia danego przedmiotu z koszyka za pomocą metody removeIf.
•	Wywołuje metodę recalculatePriceAndCounter.
4.	Metoda recalculatePriceAndCounter:
•	Przelicza sumę wartości wszystkich elementów w koszyku poprzez zsumowanie cen przedmiotów za pomocą strumienia stream i metody reduce.
•	Przelicza liczbę elementów w koszyku poprzez zsumowanie liczników przedmiotów za pomocą strumienia stream i metody reduce.
5.	Metoda getCartItemByItem:
•	Zwraca opcjonalny obiekt CartItem, który odpowiada danemu przedmiotowi.
•	Wykorzystuje strumień stream, metodę filter do wyszukania odpowiedniego przedmiotu i findFirst do zwrócenia pierwszego znalezionego elementu.
6.	Metoda cleanCart:
•	Czyści koszyk, usuwając wszystkie elementy.
•	Zeruje licznik i sumę.

CartItem reprezentuje pojedynczy przedmiot w koszyku zakupowym i zapewnia metody do zwiększania, zmniejszania licznika, sprawdzania czy liczba przedmiotów wynosi zero, a także przeliczania ceny przedmiotu.
1.	Metoda increaseCounter:
•	Zwiększa licznik przedmiotu o 1.
•	Wywołuje metodę recalculate w celu przeliczenia ceny.
2.	Metoda decreaseCounter:
•	Zmniejsza licznik przedmiotu o 1, jeśli jest większy od zera.
•	Wywołuje metodę recalculate w celu przeliczenia ceny.
3.	Metoda hasZeroItems:
•	Sprawdza, czy licznik przedmiotu wynosi 0.
•	Zwraca wartość logiczną true, jeśli licznik wynosi 0, w przeciwnym razie false.
4.	Metoda recalculate:
•	Przelicza cenę przedmiotu na podstawie ceny jednostkowej i aktualnego licznika.
•	Mnoży cenę jednostkową przez licznik i przypisuje wynik do zmiennej price.
5.	Metoda idEquals:
•	Porównuje identyfikator (ID) przedmiotu z identyfikatorem przedmiotu przekazanym jako argument.
•	Zwraca wartość logiczną true, jeśli identyfikatory są sobie równe, w przeciwnym razie false.

ItemOperation, definiuje typ wyliczeniowy (enum) ItemOperation reprezentujący operacje wykonywane na przedmiotach w koszyku zakupowym, składa się z trzech wartości:
•	INCREASE: Reprezentuje operację zwiększania ilości przedmiotów w koszyku.
•	DECREASE: Reprezentuje operację zmniejszania ilości przedmiotów w koszyku.
•	REMOVE: Reprezentuje operację usuwania przedmiotu z koszyka.

ShopApplication definiuje klasę główną aplikacji Spring Boot, uruchamiającą serwer aplikacji i rozpoczynającą jej działanie.

Klasa AuthenticationService pełni rolę pośrednika między kontrolerem a repozytorium, zarządzając logiką uwierzytelniania i rejestracji użytkowników w systemie.
1.	Metoda login(): Ta metoda przyjmuje nazwę użytkownika i hasło jako parametry i sprawdza, czy istnieje użytkownik o podanej nazwie w bazie danych. Jeśli istnieje, porównuje podane hasło z zaszyfrowanym hasłem użytkownika przy użyciu metody matches() z BCryptPasswordEncoder. Jeśli hasła się zgadzają, zwraca true, w przeciwnym razie zwraca false.
2.	Metoda register(): Ta metoda przyjmuje nazwę użytkownika i hasło jako parametry i sprawdza, czy istnieje już użytkownik o podanej nazwie w bazie danych. Jeśli nie istnieje, tworzy nowy obiekt User, ustawia podaną nazwę użytkownika i zaszyfrowane hasło przy użyciu BCryptPasswordEncoder, a następnie zapisuje użytkownika do bazy danych za pomocą metody save() z UserRepository. Zwraca true, jeśli rejestracja przebiegła pomyślnie, a użytkownik został zapisany w bazie danych. W przeciwnym razie zwraca false.

Klasa CartService pełni rolę pośrednika między kontrolerem a repozytorium oraz zarządza logiką operacji na koszyku, takich jak dodawanie, usuwanie i zmniejszanie liczby przedmiotów w koszyku.
1.	Metoda getAllItems(): Ta metoda pobiera wszystkie przedmioty z bazy danych za pomocą itemRepository.findAll() i zwraca listę przedmiotów.
2.	Metoda itemOperation(): Ta metoda wykonuje operacje na przedmiotach w koszyku na podstawie przekazanych parametrów itemId i itemOperation. Najpierw pobiera przedmiot o określonym itemId z bazy danych za pomocą itemRepository.findById(itemId). Jeśli przedmiot istnieje, w zależności od wartości itemOperation wykonuje odpowiednią operację na koszyku (Cart). Może to być zwiększenie liczby przedmiotów w koszyku, zmniejszenie liczby przedmiotów lub usunięcie przedmiotu z koszyka.

Klasa OrderService pełni rolę koordynatora procesu składania zamówienia. Przyjmuje dane zamówienia, tworzy obiekty encji zamówienia i pozycji zamówienia, zapisuje je w bazie danych, a następnie czyści koszyk.
1.	Metoda saveOrder(): Ta metoda przyjmuje obiekt OrderDto, który reprezentuje dane zamówienia, a następnie przekształca go na obiekt Order za pomocą klasy OrderMapper. Następnie zamówienie jest zapisywane do bazy danych za pomocą orderRepository.save(order). Ponadto, pozycje zamówienia są zapisywane do bazy danych za pomocą orderItemRepository.saveAll(OrderMapper.mapToOrderItemList(cart, order)). Na koniec koszyk jest czyszczony za pomocą metody cart.cleanCart(), aby usunąć przedmioty z koszyka.

Klasa SecurityConfig pozwala na skonfigurowanie BCryptPasswordEncoder jako mechanizmu szyfrowania haseł w aplikacji.

Folder resources zawiera definicje arkuszy stylów (w katalogu static.css) używane przez formularze html aplikacji znajdujące się w katalogu templates oraz plik application.properties używany do konfiguracji aplikacji.

cartView.html – zwraca widok koszyka 
home.html – główna strona sklepu służąca do przeglądania produktów i dodawania ich do koszyka
login.html – strona do logowania użytkownika
register.html – strona do rejestracji nowych użytkowników
summary.html – strona z podsumowaniem zamówienia 
addItem.html – strona dla administratora do dodawania nowych produktów
ItemIndex.html – strona dla administratora do przeglądania i edycji listy produktów
updateItem.html – strona dla administratora do edycji wybranego produktu

application.properties jest używany do konfiguracji aplikacji Spring i musi znajdować się w odpowiednim katalogu zgodnie z konwencją aplikacji Spring.
•	spring.datasource.driverClassName - definiuje klasę sterownika dla bazy danych SQL Server.
•	spring.datasource.url - definiuje adres URL do bazy danych SQL Server, w tym lokalizację (localhost), nazwę bazy danych (shop_db) i opcje połączenia (encrypt=false).
•	spring.datasource.username i spring.datasource.password - definiują dane uwierzytelniające do bazy danych (nazwa użytkownika: sa, hasło: student).
•	spring.jpa.hibernate.ddl-auto=update - wskazuje, że Hibernate powinien aktualizować schemat bazy danych na podstawie modelu encji. (Uwaga: Ta opcja powinna być używana ostrożnie w środowiskach produkcyjnych. Podczas pierwszego uruchomienia aplikacji zostaną automatycznie utworzone we wskazanej bazie potrzebne dla jej działania tabele danych). 
•	spring.jpa.show-sql=true - włącza wyświetlanie generowanych zapytań SQL w logach aplikacji.
•	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServerDialect - definiuje dialekt Hibernate dla bazy danych SQL Server.
•	spring.jpa.database-platform=org.hibernate.dialect.SQLServerDialect - definiuje platformę bazy danych dla Hibernate.
•	spring.thymeleaf.suffix=.html - definiuje rozszerzenie plików szablonów Thymeleaf (HTML).
•	spring.thymeleaf.mode=HTML - wskazuje, że szablony Thymeleaf są w trybie HTML.

