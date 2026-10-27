# Dziedziczenie w Javie, kompozycja i delegacja

---
Program `Licznik` to prosta aplikacja z interfejsem graficznym, 
umożliwiająca zwiększanie i resetowanie wartości licznika. 
Zawiera trzy rodzaje liczników: `SimpleCounter`, `DoubleCounter` i `OverflowCounter`,
które implementują wspólny interfejs Counter.
Klasy te mają wiele wspólnych elementów. 
Aby ograniczyć powtarzanie kodu i uporządkować strukturę programu,
możemy zastosować różne schematy dziedziczenia, rozważymy dwa.
W pierwszym sposobie `DoubleCounter` i `OverflowCounter` będą dziedziczyć
po klasie `SimpleCounter`, uznanej za modelową implementację licznika.

## Dziedziczenie po SimpleCounter

---
Klasa SimpleCounter implementuje interfejs Counter i stanowi podstawową wersję licznika:
```java
public class SimpleCounter implements Counter {
    int counter = 0;
    public void increase() {
        ++counter;
    }

    public int currentValue() {
        return counter;
    }

    public void reset() {
        counter = 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
```
Klasy `DoubleCounter` i `OverflowCounter` nadpisują tylko metodę `increase()`,
zmieniając sposób zwiększania wartości licznika.
Dziedziczą metody `currentValue()`, `reset()` i `to String()` z klasy `SimpleCounter`:
```java
public class DoubleCounter extends SimpleCounter {
    @Override
    public void increase() {
        counter += 2;
    }
}
```

## Dziedziczenie po AbstractCounter

---
Możemy też wprowadzić klasę abstrakcyjną `AbstractCounter`, 
po której będą dziedziczyć wszystkie trzy klasy liczników:
```java
abstract class AbstractCounter implements Counter {
    int counter = 0;

    abstract public void increase();

    public int currentValue() {
        return counter;
    }

    public void reset() {
        counter = 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
```
Liczniki nadpisują jedynie metodę `increase()`.

```java
public class SimpleCounter extends AbstractCounter {
    public void increase() {
        ++counter;
    }
}
```
Ten sposób wydaje się bardziej elegancki.
Z początku może się wydawać, że niepotrzebnie dodajemy kolejną klasę,
ale dzięki temu kod ma bardziej uporządkowaną strukturę.
Klasa `AbstractCounter` zawiera wspólne elementy wszystkich liczników, 
a każda z klas dziedziczących odpowiada za własny sposób zwiększania wartości.

## Metody klas nadrzędnych

---
Zdefiniowano nową klasę, `BeepingCounter`, 
która dziedziczy po klasie `SimpleCounter`.
```java
public class BeepingCounter extends SimpleCounter{
    public void increase() {
        super.increase();
        java.awt.Toolkit.getDefaultToolkit().beep();
    }
}
```
Dzięki wywołaniu `super.increase()` korzystamy z metody klasy nadrzędnej, 
która zwiększa wartość licznika. 
Następnie wywołujemy metodę `beep()`, 
która dodatkowo przy kliknięciu generuje sygnał dźwiękowy. 

Gdybyśmy chcieli stworzyć odpowiedniki pozostałych klas (tj. `DoubleCounter` oraz `OverflowCounter`) 
implementujących liczniki zgodnie z powyższą metodą,
musielibyśmy zdefiniować dwie nowe klasy: `BeepingDoubleCounter` oraz `BeepingOverflowCounter`, 
które dziedziczyłyby odpowiednio po `DoubleCounter` i `OverflowCounter`.
Ich definicje różniłyby się od `BeepingCounter` jedynie klasą nadrzędną.

## Kompozycja i delegacja

---
Zdefiniowano nową klasę `Beeping`:
```java
public class Beeping implements Counter {
    // KOMPOZYCJA – przechowujemy w zmiennej obiekt klasy implementującej interfejs Counter
    private Counter counter;
    
    public Beeping(Counter counter) {
        this.counter = counter;
    }
    
    // DELEGACJA
    public void increase() {
        counter.increase();
        java.awt.Toolkit.getDefaultToolkit().beep();
    }

    public int currentValue() {
        return counter.currentValue();
    }

    public void reset() {
        counter.reset();
    }

    @Override
    public String toString() {
        return counter.toString() + " (z dźwiękiem)";
    }
}
```
W klasie `Beeping` zastosowano kompozycję i delegację. 
Dzięki temu możemy dodać obsługę dźwięku do różnych rodzajów liczników 
bez konieczności tworzenia osobnej klasy dla każdego z nich. 
Klasa `Beeping` korzysta z metod przekazanego licznika, 
dodatkowo wywołując dźwięk przy zwiększaniu jego wartości.

W wypadku jakbyśmy chcieli dodać do interfejsu `Counter` kolejną metodę,
trzeba by ją było zaimplementować w klasie `Beeping`.
W poprzednim przykładzie w metodach klas nadrzędnych
musielibyśmy ją zaimplementować w klasie `SimpleCounter`.