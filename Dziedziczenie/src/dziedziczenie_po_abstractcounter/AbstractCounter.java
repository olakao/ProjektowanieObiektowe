package dziedziczenie_po_abstractcounter;

abstract class AbstractCounter implements Counter {
    int counter = 0;
    abstract public void increase();

    public int currentValue() {
        return counter;
    }

    public void reset() {
        counter = 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
