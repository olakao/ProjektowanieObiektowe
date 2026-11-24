package ticking;

// klasa Beeping implementuje interfejs Counter i pełni funkcję dekoratora
public class Beeping implements Counter {
    private Counter myCounter;

    public Beeping(Counter passedCounter) {
        this.myCounter = passedCounter;
    }

    public void increase() {
        myCounter.increase();
        java.awt.Toolkit.getDefaultToolkit().beep();
    }

    public int currentValue() {
        return myCounter.currentValue();
    }

    public void reset() {
        myCounter.reset();
    }

    @Override
    public String toString() {
        return myCounter.toString() + " (z dźwiękiem)";
    }
}
