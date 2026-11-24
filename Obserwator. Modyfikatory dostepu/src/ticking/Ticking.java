package ticking;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// dekorator automatycznie zwiększający wartość licznika co sekundę
public class Ticking implements Counter {

    // licznik, który zostanie opakowany dekoratorem
    private Counter myCounter;

    // konstruktor przyjmujący obiekt implementujący interfejs Counter
    public Ticking(Counter passedCounter) {
        this.myCounter = passedCounter;

        // timer wywołuje metodę increase() co 1000 ms, czyli co sekundę
        new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                increase();
            }
        }).start();
    }

    // zwiększa wartość opakowanego licznika
    public void increase() {
        myCounter.increase();
    }

    // zwraca aktualną wartość opakowanego licznika
    public int currentValue() {
        return myCounter.currentValue();
    }

    // zeruje opakowany licznik
    public void reset() {
        myCounter.reset();
    }

    // zwraca nazwę licznika z informacją o automatycznym zliczaniu
    @Override
    public String toString() {
        return myCounter.toString() + " (tykający)";
    }
}
