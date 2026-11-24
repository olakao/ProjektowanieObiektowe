package ticking_observer_app;

public class Beeping extends AbstractDecorator {

    public Beeping(Counter passedCounter) {
        super(passedCounter);
    }

    @Override
    public void increase() {
        myCounter.increase();
        java.awt.Toolkit.getDefaultToolkit().beep();
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
        return myCounter.toString() + " (z dźwiękiem)";
    }
}