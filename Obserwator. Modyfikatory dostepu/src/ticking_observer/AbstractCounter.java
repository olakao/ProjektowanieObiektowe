package ticking_observer;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractCounter implements Counter {

    int counter = 0;

    private final List<CounterListener> listeners = new ArrayList<>();

    @Override
    public void addListener(CounterListener listener) {
        listeners.add(listener);
    }

    // Metoda szablonowa – określa kolejność wykonywanych operacji
    @Override
    public final void increase() {
        step();
        notifyListeners();
    }

    // Konkretne liczniki definiują sposób zwiększania wartości
    protected abstract void step();

    // Powiadamia wszystkich zarejestrowanych słuchaczy
    protected void notifyListeners() {
        for (CounterListener listener : listeners) {
            listener.counterChanged(this);
        }
    }

    @Override
    public int currentValue() {
        return counter;
    }

    @Override
    public void reset() {
        counter = 0;
        notifyListeners();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
