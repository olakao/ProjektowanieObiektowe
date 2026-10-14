public class OverflowCounter implements Counter {
    int counter = 0;
    public void increase() {
        if(counter == 10) {
            counter = 0;
        } else {
            ++counter;
        }
    }

    public int currentValue() {
        return counter;
    }

    public void reset() {
        counter = 0;
    }

    @Override
    public String toString() {
        return "Overflow Counter";
    }
}
