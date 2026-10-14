public class DoubleCounter implements Counter {
    int counter = 0;
    public void increase() {
        counter += 2;
    }

    public int currentValue() {
        return counter;
    }

    public void reset() {
        counter = 0;
    }

    @Override
    public String toString() {
        return "Double Counter";
    }
}
