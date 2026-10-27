package beep_kompozycja_delegacja;

public class Beeping implements Counter {
    // KOMPOZYCJA – przechowujemy w zmiennej obiekt klasy implementującej interfejs Counter
    private Counter myCounter;

    public Beeping(Counter passedCounter) {
        this.myCounter = passedCounter;
    }

    // DELEGACJA
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
