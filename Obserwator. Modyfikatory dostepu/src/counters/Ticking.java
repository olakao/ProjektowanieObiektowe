package counters;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ticking extends AbstractDecorator {

    public Ticking(Counter passedCounter) {
        super(passedCounter);

        // timer zwiększa wartość licznika co sekundę
        new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                increase();
            }
        }).start();
    }

    @Override
    public void increase() {
        myCounter.increase();
    }

    @Override
    public int currentValue() {
        return myCounter.currentValue();
    }

    @Override
    public void reset() {
        myCounter.reset();
    }

    @Override
    public String toString() {
        return myCounter.toString() + " (tykający)";
    }
}