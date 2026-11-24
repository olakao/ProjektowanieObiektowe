package ticking_observer_app;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractDecorator implements Counter {

    protected Counter myCounter;

    private final List<CounterListener> listeners = new ArrayList<>();

    public AbstractDecorator(Counter passedCounter) {
        this.myCounter = passedCounter;
        myCounter.addListener(source -> notifyListeners());
    }

    @Override
    public void addListener(CounterListener listener) {
        listeners.add(listener);
    }

    protected void notifyListeners() {
        for (CounterListener listener : listeners) {
            listener.counterChanged(this);
        }
    }
}