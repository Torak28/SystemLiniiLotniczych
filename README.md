# SystemLiniiLotniczych

Przygotowali
 * Jarosław Ciołek-Żelechowski, **218386**
 * Dominik Cecotka, **218339**

#Diagram Przypadków Użycia:

![alt text](http://i.imgur.com/OY9q05y.png "Logo Title Text 1")


#Wymagania Funkcjonalne i niefunkcjonalne:
1. Lista wymagań funkcjonalnych:
..* System zawiera rozkład lotów do którego można dodawać i usuwać poszczególne
elementy,
..* Można dokonać zakupu biletu lub jego rezerwacji,
..* Można wprowadzić wiele biletów o unikalnych numerach,
..* System dopuszcza anulowanie zamówienia jeśli spełnione są warunki,
..* Konsultant jest pracownikiem linii lotniczych, komunikuje się z klientami. Jego
praca jest wspierana za pomocą systemu,
..* Przeszukiwanie listy pasażerów danego Lotu w celu sprawdzenia czy
rezerwacja/zakup biletu jest możliwy,
..* Generowanie pełnej informacji o locie wraz z lista pasażerów i ich
rozmieszczeniem w samolocie.

2. Lista wymagań niefunkcjonalnych:
..* Dodawanie i usuwanie lotów obywa się tylko za pośrednictwem uprawnionych
osób,
..* Wstawianie nowych biletów oraz ich rezerwacja dokonywana jest przez
klientów/pasażerów,
..* Zakup oraz rezerwacja odbywają się za pośrednictwem Internetu lub specjalnie
przygotowanych aplikacji,
..* Rezerwacje należy potwierdzić maksymalnie dzień przed lotem.

#Założenia, uproszcznia:
Na etapie projektowym założyliśmy dwie kluczowe dla Naszego Diagramu Klas założenia:

###Nasza aplikacja na potrzeby pokazania funkcjonalności nie będzie wymagała systemu bazodanowego. Mając jednak w głowie „rozwój” Naszego systemy zdecydowaliśmy się poszczególne „rekordy” bazy danych przechowywać w wektorach. Tym samym sposób korzystania z nich wymaga używania indeksów, podobnie jak w przypadku Bazy Danych, a oprócz tego zamiana tych pól na takie wykorzystujące zapytania SQL nie będzie bolesny w implementacji

###Każde pole w Naszej aplikacji ma funkcję set() i get(). Mamy świadomość że tworzenie tych funkcji dla każdego atrybuty klasy jest zbędne. Wydaje się nam jednak że na etapie projektowym doszukiwanie się tej zbędności może powodować niepotrzebne komplikacje. Zakładamy że prościej będzie w etapie implementacyjnym usunąć te funkcje set() i get() dla których nie znaleźliśmy zastosowania.

#Diagram Klas:

![alt text](http://i.imgur.com/6BMgG7w.png "Logo Title Text 1")

###Komentarz do Diagramu:
Przede wszystkim podczas projektowania Klas kierowaliśmy się pełną enkapsulacją oraz maksymalnym ograniczeniem i uproszczeniem danych. Są jednak pewne elementy, które wymagają szczególnej uwagi oraz dodatkowego komentarza:
 * Klasa Lot posiada wektor Biletów, które do Niego przynależą. Wynika to z tego że Lot z Biletami jest szczególnie powiązany i bezsensowne byłoby chociażby osobne usuwanie Biletu w wypadku usuwania Lotu. Tym samym jednak dodawanie rezerwacji, czy zakup biletu kontrolowany jest z poziomu Klasy Lot, wywoływanej w Klasie Aplikacja,
 * Generowanie Raportu jest funkcją Klasy Lot co z jednej strony wynika z faktu że Klasa Lot przechowuje należące do konkretnego Lotu bilety, a z drugiej z firmy przechowywania danych, tj. wektora Lotów w postaci tablicowej,
 * Klasa Lot posiada również przypisany do niej Samolot oraz funkcje get() i set() w celu pobrania informacji o Samolocie oraz możliwość zmiany Samolotu, w przypadku np. awarii,
 * Klasa Samolot posiada atrybut: klasaOdleglosci, który to mówi jak daleko Nasz Samolot jest w stanie polecieć, oraz definiuje jego pojemność pasażerską
 * Klasa Aplikacja jest klasą-Fasadą. Jest sercem Aplikacji i głównym obiektem służącym do sterowania całością

#Diagramy Sekwencji:

###Zakup Biletu
![alt text](http://i.imgur.com/7EC6ncJ.png "Logo Title Text 1")

###Rezerwazcja Biletu
![alt text](http://i.imgur.com/6yvKdRk.png "Logo Title Text 1")

###Dodanie Lotu
![alt text](http://i.imgur.com/IfRCQzu.png "Logo Title Text 1")
