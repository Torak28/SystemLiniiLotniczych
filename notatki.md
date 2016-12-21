#Do poprawy
 * Unikalny numer biletu(miejsce siedzenia)
 * Poprawa kupowania biletu(sprawdzanie uniklanego numeru)
 * Trzeba sprawdzac poprawnosc i mozliwosc lotu
 * Poprawic przydzielanie Samolotu do lotu
 * Po locie trzeba sprawdzic stan samolotu
 * Doliczyc do samolotu czas serwisowania
 * Usuwanie Lotu i usuwanie Samolotu(Lotu nie ingeruje w Samoloty, Samolotu ingeruje w Loty)



plain texxt
Samolot:
	Kazdy Lot ma Samolot
	Aplikacja moze dodac Samolot
	Aplikacja moze szukac Samolotu
	Lot ma getter i setter

Aplikacja dodaje Samolot
Aplikacja usuwa Samolot
Aplikacja dodaje lot, sprawdza czy jest Samolot i dodaje Samolot
Aplikacja usuwa lot, ale nie Samolot
Po odbytym Locie Smolot ma sprawdzany stan

Bilet
	Lot moze dodawac bilety
	Lot moze szukac biletow
	Kazdy Lot ma bilety
	Bilet ma getter i setter

Lot kupuje bilet
Lot usuwa kupiony bilet
Lot rezerwuje bilet
Lot usuwa zarezerwowany bilet
Lot szuka Biletu
Lot zmienia bilet zerezerwowany na kupiony

Lot:
	Aplikacja moze dodac Lot	
	Aplikacja moze usunac Lot
	Aplikacja moze wyszukac Lot

Aplikacja dodaje Lot, ustawia w nim ... wszystko
Aplikacja usuwa Lot ale nie przypisany do niego Samolot
Aplikacja dodajac Lot musi go wpier wyszukac
