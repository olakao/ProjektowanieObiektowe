package dziedziczenie_po_abstractcounter;

public class SimpleCounter extends AbstractCounter {
    @Override
    public void increase() {
        ++counter;
    }
}
