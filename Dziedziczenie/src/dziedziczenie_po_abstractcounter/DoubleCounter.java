package dziedziczenie_po_abstractcounter;

public class DoubleCounter extends AbstractCounter {
    @Override
    public void increase() {
        counter += 2;
    }
}
