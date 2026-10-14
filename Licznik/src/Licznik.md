# Prosty licznik w programie Java

---
## Zacznijmy od przywitania :)

```java
public class Witaj {
    public static void main(String[] args) {
        System.out.println("Witam serdecznie!");
    }
}
```
Słowo kluczowe ```static``` oznacza, że metoda może być wywołana 
niezależnie od tego, czy istnieje obiekt danej klasy.

## Prosty licznik

### Kod

```java
// import bibliotek do tworzenia interfejsu graficznego
import javax.swing.*;       // elementy interfejsu graficznego (JFrame, JButton, JLabel)
import java.awt.*;          // tworzenie interfejsu graficznego i rozmieszczanie jego elementów (FlowLayout)
import java.awt.event.*;    // obsługa zdarzeń (Action Listener)

public class CounterApp implements ActionListener {

    JFrame frame = new JFrame("Licznik");       // okno programu
    JButton button = new JButton("Kliknij!");   // przycisk
    JLabel label = new JLabel("0");             // etykieta

    public static void main(String[] args) {
        new CounterApp().run();
    }

    void run() {
        // umieszcza elementy obok siebie
        frame.setLayout(new FlowLayout());          // umieszcza elementy obok siebie
        frame.add(button);
        frame.add(label);
        button.addActionListener(this);           // reakcja na kliknięcie

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // po zamknięciu okna zakończenie działania aplikacji
        frame.pack();                               // dopasowuje rozmiar okna do jego zawartości
        frame.setVisible(true);                     // okno staje się widoczne
    }

    int count = 0;                                  // zmienna licząca kliknięcia

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;                                    // zwiększenie licznika o 1
        label.setText(Integer.toString(count));     // aktualizuje tekst na etykiecie
    }
}
```

### Interfejs ActionListener
Aby przycisk ```Kliknij!``` zmieniał wartość etykiety z 0 na kolejne liczby,
musimy skorzystać z biblioteki ```java.awt.event``` i zaimplementować w klasie
interfejs ```ActionListener```.

Zdefiniowanie, jaka reakcja zostanie wywołana, realizuje poniższy fragment kodu:
```java
    int count = 0;                                  // zmienna licząca kliknięcia

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;                                    // zwiększenie licznika o 1
        label.setText(Integer.toString(count));     // aktualizuje tekst na etykiecie
```
Metoda ```actionPerformed()``` wykonuje się po kliknięciu przycisku. 
Zwiększa wartość zmiennej count o 1, 
a następnie wyświetla nową wartość na etykiecie.

Musimy do tego dodać w metodzie ```run()``` reakcję na kliknięcie przycisku.
```java
        button.addActionListener(this);
```

#### Podsumowując
Bez interfejsu ```ActionListener``` nie mielibyśmy możliwości zwiększania licznika kliknięć - 
etykieta zawsze wskazywałaby ```0```.

## Licznik z własnym interfejsem

### Kod
```java
// import bibliotek do tworzenia interfejsu graficznego
import javax.swing.*;       // elementy interfejsu graficznego (JFrame, JButton, JLabel, JCombo Box)
import java.awt.*;          // tworzenie interfejsu graficznego i rozmieszczanie jego elementów (FlowLayout)
import java.awt.event.*;    // obsługa zdarzeń (Action Listener)

public class CounterInterface implements ActionListener {

    JFrame frame = new JFrame("Licznik");       // okno programu
    JButton button = new JButton("Kliknij!");   // przycisk
    JLabel label = new JLabel("0");             // etykieta
    JButton reset = new JButton("Reset");

    public static void main(String[] args) {
        new CounterInterface().run();
    }

    JComboBox<Counter> counters = new JComboBox<>(new Counter[]{    // lista rozwijalna
            new SimpleCounter(),
            new DoubleCounter(),
            new OverflowCounter(),
    });

    void run() {
        // umieszcza elementy obok siebie
        frame.setLayout(new FlowLayout());          // umieszcza elementy obok siebie
        frame.add(button);
        frame.add(label);
        frame.add(counters);
        frame.add(reset);
        button.addActionListener(this);           // reakcja na kliknięcie
        reset.addActionListener(this);            // reakcja na kliknięcie

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // po zamknięciu okna zakończenie działania aplikacji
        frame.pack();                               // dopasowuje rozmiar okna do jego zawartości
        frame.setVisible(true);                     // okno staje się widoczne
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Counter counter = (Counter) counters.getSelectedItem(); // pobiera wybrany licznik, zapisuje go w zmiennej counter

        if (e.getSource() == button) {
            counter.increase();
        } else if (e.getSource() == reset) {
            counter.reset();
        }

        label.setText(Integer.toString(counter.currentValue()));// aktualizuje tekst na etykiecie
        frame.pack();
    }
}
```
```java
public class OverflowCounter implements Counter {
    int counter = 0;
    public void increase() {
        if(counter == 10) {
            counter = 0;
        } else {
            ++counter;
        }
    }

    public int currentValue() {
        return counter;
    }

    @Override
    public void reset() {
        counter = 0;
    }

    @Override
    public String toString() {
        return "Overflow Counter";
    }
}
```
### Metoda toString()
Klasa ```java.lang.Object``` udostępnia metodę ```toString()```.
Zwraca tekstową reprezentację obiektu.
Poszczególne elementy napisu w rodzaju *SimpleCounter@1b6d3586* określają:
- *SimpleCounter* - nazwa klasy obiektu
- *@* - znak rozdzielający
- *1b6d3586* - zapisana w kodzie szesnastkowym wartość liczbowa przypisana do
danego obiektu, zwracana przez metodę ```hashCode()```

Żeby uzyskać wybraną przez nas nazwę, musimy nadpisać tą metodę:
```java
    @Override
    public String toString() {
        return "Overflow Counter";
    }
```
### Reset

#### Metody interfejsu

W programie dodano przycisk ```Reset```. 
Jak tylko dodamy do interfejsu Counter metodę void ```reset()```:
```java
public interface Counter {
    void increase();
    int currentValue();
    void reset();
}
```
program nie zbuduje się, ponieważ klasy liczników nie mają zdefiniowanych tych metod.
Klasa musi implementować wszystkie metody interfejsu.
Aby program się zbudował, trzeba dodać metodę reset do klas liczników:
```java
    public void reset() {
        counter = 0;
    }
```
#### Więcej niż jeden przycisk

Dodanie przycisku ```Reset``` do programu i dodanie mu akcji:
```java
        frame.add(reset);
        reset.addActionListener(this);           // reakcja na kliknięcie
```
spowoduje, że przycisk reset będzie miał taką samą funkcjonalność jak ```Kliknij!```.

Dlatego musimy zmienić kod i przypisać odpowiednią akcję do reset:
```java
    @Override
    public void actionPerformed(ActionEvent e) {
        Counter counter = (Counter) counters.getSelectedItem(); // pobiera wybrany licznik, zapisuje go w zmiennej counter

        if (e.getSource() == button) {
            counter.increase();
        } else if (e.getSource() == reset) {
            counter.reset();
        }

        label.setText(Integer.toString(counter.currentValue()));// aktualizuje tekst na etykiecie
        frame.pack();
    }
```
