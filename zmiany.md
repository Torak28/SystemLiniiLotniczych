# Zmiany wprowadzone 10.01 i w sumie to 11.01 trochę też xd

* Porzuciłem pomysł Numeru Lotu jako informacji o całym locie, w sensie że teraz to jest jakis randomowy numer a nie coś wynikajacego z danych lotu
* W związku z tym dodałem do lotu:
```java
    private int miastoPoczatkowe;
    private int miastoKoncowe;
    private int data;
    private int godzina;
    //plus gettery i settery do kazdego
```
* W takim razie przy tworzeniu nowego lotu interesuje Nas miasto poczatkowe, miasto koncowe
* Dodałem też Formularz dodawania Nowego Lotu, ktory pyta i generuje nowe NL na podstawie otrzymanych odpowiedzi
* Bilet ma teraz miejsce ktore jest rowne jego indeksowi w tablicy biletow + 1
* Zmieniłem też sposób szukania lotu. Wczesniej musieliśmy z palca wszystko wklepać, a teraz w oparciu o konkretny numer Lotu, przezsukuje wszystkie loty i jak znajde to z tego konkretnego Lotu pobieram dane do szukania. Troche masło maślane ale działa xd
* Dodałem też generowanie raportu o wszystkich Lotach. 
* Mam też pomysł żeby na poczatku pytac o tryb w jakim odpalic nasz program. Czy dla klienta, czy dla zarzadzajacego systemem
* Pozbyle sie wszystkich boolow w setterach. W sumie to malo Nas obchodzi czy setter sie wykona. W sensie wykona sie na sto procent, a nawet jesli nie to i tak nie mamy obslug bledow wiec w sumie nie ma roznicy. A bez boolow sie prościej piszę więć odp. była prosta :)
* Zmieniłem tez usuwanie biletów. Po pierwsze teraz są faktycznie usuwane z Listy Bilety, a po druie to usuwam je po miejscu, które jest unikalnym numerem danego biletu
* Musiałem zmienić to losowe przydzielanie Samolotu do Lotu, teraz przed dodaniem lotu pyta który samlot chcesz dodać

