# Zmiany wprowadzone 10.01

* Porzuciłem pomysł Numeru Lotu jako informacji o całym locie, w sensie że teraz to jest jakis randomowy numer a nie coś wynikajacego z danych lotu
* W związku z tym dodałem do lotu:
```java
    private int miastoPoczatkowe;
    private int miastoKoncowe;
    private int data;
    private int godzina;
    //plus gettery i settery do kazdego
```
* W takim razie przy tworzeniu nowego lotu interesuje Nas miasto poczatkowe,, miasto koncowe
