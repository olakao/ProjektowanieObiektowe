package dziedziczenie_po_simplecounter;

public class DoubleCounter extends SimpleCounter {
    @Override
    public void increase() {
        counter += 2;
    }
}
