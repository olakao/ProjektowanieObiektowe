public class SimpleCounter implements Counter {
    int counter = 0;
    public void increase() {
        ++counter;
    }

    public int currentValue() {
        return counter;
    }

    public void reset() {
        counter = 0;
    }

    @Override
    public String toString() {
        return "Simple Counter";
    }
}
