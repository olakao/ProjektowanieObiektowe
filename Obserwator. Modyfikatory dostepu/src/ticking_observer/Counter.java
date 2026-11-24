package ticking_observer;

public interface Counter {
    void increase();
    int currentValue();
    void reset();
    void addListener(CounterListener listener);
}