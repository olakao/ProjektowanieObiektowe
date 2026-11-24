package ticking;

public interface Counter {
    void increase();
    int currentValue();
    void reset();
}