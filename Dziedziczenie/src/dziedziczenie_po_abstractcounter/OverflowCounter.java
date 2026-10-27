package dziedziczenie_po_abstractcounter;
public class OverflowCounter extends AbstractCounter {
    @Override
    public void increase() {
        if(counter == 10) {
            counter = 0;
        } else {
            ++counter;
        }
    }
}
