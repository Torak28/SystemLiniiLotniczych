### Komenda do posatwienia fitnessa
```
java -jar fitnesse-stanalone.jar -p 8090
```

### Sam kod testów
```
!*< Hidden
!define TEST_SYSTEM {slim}
*!

!path D:\Dropbox\Studiowanie\git\SystemLiniiLotniczych\out\production\IO\
|Lot|
| miastoPoczatkowe | miastoKoncowe | data | godzina |generujNumerLotu?|
| 1 | 2 | 10 | 10 | 23 |
| 2 | 1 | 10 | 10 | 23 |
| 1 | 3 | 10 | 10 | 24 |
| 3 | 1 | 10 | 10 | 24 |
| 1 | 2 | 11 | 10 | 24 |
| 1 | 2 | 12 | 10 | 25 |
| 1 | 2 | 10 | 11 | 24 |
| 1 | 2 | 10 | 12 | 25 |


|Bilet|
| numerLotu | typ | miastoPoczatkowe | miastoKoncowe | data | godzina | miejsce | getNumerLotu? | getTyp? | getMiastoPoczatkowe? | getMiastoKoncowe? | getData? | getGodzina? | getMiejsce? |
| 23 | 1 | 1 | 2 | 10 | 10 | 1 | 23 | 1 | 1 | 2 | 10 | 10 | 1 |
| 24 | 1 | 1 | 3 | 10 | 10 | 1 | 24 | 1 | 1 | 3 | 10 | 10 | 1 |
| 25 | 2 | 1 | 3 | 11 | 10 | 1 | 25 | 2 | 1 | 3 | 11 | 10 | 1 |
| 26 | 2 | 1 | 3 | 11 | 11 | 1 | 26 | 2 | 1 | 3 | 11 | 11 | 1 |
| 27 | 1 | 2 | 3 | 12 | 10 | 1 | 27 | 1 | 2 | 3 | 12 | 10 | 1 |
| 28 | 1 | 2 | 3 | 12 | 11 | 1 | 28 | 1 | 2 | 3 | 12 | 11 | 1 |

|Samolot|
| nazwa | klasaOdleglosci | iloscMiejsc | numerLotu | getNazwa? | getKlasaOdleglosci? | getIloscMiejsc? | getNumerLotu? |
| Erbas | 1 | 100 | 23 | Erbas | 1 | 100 | 23 |
| Tupolew | 10 | 1000 | 24 | Tupolew | 10 | 1000 | 24 |
| Orzel | 2 | 100 | 24 | Orzel | 2 | 100 | 24 |
| Erbas123 | 1 | 10 | 2 | Erbas123 | 1 | 10 | 2 |
| Nic | 0 | 0 | 23 | Nic | 0 | 0 | 23 |

| Aplikacja |
| czyMamSamolotDoLotu? |
| false |
```

### Wyniki:
![alt text](http://i.imgur.com/0RxdtPc.png "Logo Title Text 1")
